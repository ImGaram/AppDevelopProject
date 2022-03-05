package com.example.appdevelopproject.daggerhiltapppractice

import androidx.fragment.app.Fragment
import com.example.appdevelopproject.daggerhiltapppractice.di.SomeClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyFragment: Fragment() {
    @Inject
    lateinit var someClass: SomeClass   // singleton으로 표시된 someClass 주입
}