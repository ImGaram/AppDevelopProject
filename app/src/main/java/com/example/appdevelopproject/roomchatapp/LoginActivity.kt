package com.example.appdevelopproject.roomchatapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.appdevelopproject.RoomChatActivity
import com.example.appdevelopproject.databinding.ActivityLoginBinding
import com.example.appdevelopproject.roomchatapp.db.UserDbBuilder
import com.example.appdevelopproject.roomchatapp.entity.UserEntity
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var userDb: UserDbBuilder? = null
    private val pickImageFromAlbum = 0
    private var userEntity: UserEntity = UserEntity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDb = UserDbBuilder.getInstance(this)

        binding.selectImage.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            photoPickerIntent.putExtra("crop", true)
            startActivityForResult(photoPickerIntent, pickImageFromAlbum)
        }

        binding.goChatBtn.setOnClickListener {
            adduser()
        }
    }

    private var uri: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            pickImageFromAlbum -> {
                uri = data?.data
                binding.selectImage.setImageURI(uri)
            }

            CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE -> {
                val result = CropImage.getActivityResult(data)
                if (requestCode == Activity.RESULT_OK) {
                    binding.selectImage.setImageBitmap(result.bitmap)
                    binding.selectImage.setImageURI(result.uri)
                    uri = result.uri
                    userEntity.profileImg = uri.toString()
                    Log.d("TAG", "onActivityResult image url: $uri")
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Toast.makeText(this, "문제가 발생했습니다, 다시 시도해 주세요.", Toast.LENGTH_SHORT).show()
                }
            }
            else -> finish()
        }
    }

    private fun adduser() {
        val id = binding.userId.text.toString()
        val username = binding.userUsername.text.toString()

        // 값이 비지 않은 경우
        if (id.isNotEmpty() && username.isNotEmpty()) {
            userEntity.id = id
            userEntity.username = username

            // IO 쓰레드에서 진행
            val userBuilder = UserDbBuilder.getInstance(this)
            CoroutineScope(Dispatchers.IO).launch {
                userDb?.userDao()?.insert(userEntity)
                Log.d("TAG", "adduser db data: ${userDb?.userDao()?.getAll().toString()}")

                val user = userDb?.userDao()?.getAll()
                Log.d("TEST", "get all user [SUCCESS]: $user")
            }

            startActivity(Intent(this, RoomChatActivity::class.java))
        } else {    // 빈 경우
            Toast.makeText(this, "모두 입력 하세요", Toast.LENGTH_SHORT).show()
        }
    }
}