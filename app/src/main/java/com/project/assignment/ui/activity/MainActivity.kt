package com.project.assignment.ui.activity

import android.os.Bundle
import com.project.assignment.databinding.ActivityMainBinding
import com.project.assignment.ui.activity.BaseActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}