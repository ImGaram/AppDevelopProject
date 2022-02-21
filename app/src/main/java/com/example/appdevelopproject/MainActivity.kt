package com.example.appdevelopproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdevelopproject.todoapp.MainViewModel
import com.example.appdevelopproject.databinding.ActivityMainBinding
import com.example.appdevelopproject.todoapp.recyclerview.Todo
import com.example.appdevelopproject.todoapp.recyclerview.TodoAdapter
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    val RC_SIGN_IN = 1000

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 로그인이 안된 경우
        if (FirebaseAuth.getInstance().currentUser == null) {
            login()
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoAdapter(emptyList(), onClickDeleteIcon = {
                viewModel.deleteTodo(it)
            }, onClickItem = {
                viewModel.toggleTodo(it)
            })
        }
        binding.addButton.setOnClickListener {
            val todo = Todo(binding.editText.text.toString())
            viewModel.addTodo(todo)
        }

        // 관찰하는 코드
        viewModel.todoLiveData.observe(this, Observer {
            (binding.recyclerView.adapter as TodoAdapter).setData(it)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {    // 로그인 결과를 받는다
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                val mainViewModel = MainViewModel()
                mainViewModel.fetchData()
            } else {
                // 로그인 실패 시
                finish()
            }
        }
    }

    // 아이템 클릭 리스너
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_log_out -> {
                logout()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // 로그인
    fun login() {
        // 이메일 로그인 구현
        val provider = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build() )
        // 첫 화면에 로그인 화면 추가
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .build(),
            RC_SIGN_IN)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    // 로그 아웃
    fun logout() {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                login()
            }
    }
}
