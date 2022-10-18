package com.bahrun.chapter5.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.ActivitySplashScreenBinding
import com.bahrun.chapter5.ui.game.GameActivity
import com.bahrun.chapter5.ui.onboarding.OnBoardingActivity

class SplashScreen : AppCompatActivity() {

    private val binding : ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}