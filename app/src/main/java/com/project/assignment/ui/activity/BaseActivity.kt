package com.project.assignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.assignment.databinding.ActivityBaseBinding
import com.project.assignment.databinding.ActivityMainBinding

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}