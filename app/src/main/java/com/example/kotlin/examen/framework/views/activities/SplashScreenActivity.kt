package com.example.kotlin.examen.framework.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.examen.databinding.ActivitySplashScreenBinding
import com.example.kotlin.examen.framework.viewmodel.SplashScreenViewModel

class SplashScreenActivity : AppCompatActivity() {
    private val viewModel: SplashScreenViewModel by viewModels()
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarBinding()
        initializeObservers()
        viewModel.onCreate()
    }

    private fun inicializarBinding() {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers() {
        viewModel.acaboCargar.observe(
            this,
            Observer { acaboCargar ->
                if (acaboCargar) {
                    passViewGoToMain()
                }
            },
        )
    }

    private fun passViewGoToMain() {
        var intent: Intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
}
