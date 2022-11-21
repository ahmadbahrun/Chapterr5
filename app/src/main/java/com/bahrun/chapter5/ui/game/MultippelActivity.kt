package com.bahrun.chapter5.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.ActivityMultippelBinding
import com.bahrun.chapter5.databinding.GameActivityBinding.inflate

class MultippelActivity : AppCompatActivity() {

    private val binding: ActivityMultippelBinding by lazy {
        ActivityMultippelBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    companion object{
        fun startActivityMultiple(context: Context){
        context.startActivity(Intent(context,MultippelActivity::class.java))
        }
    }
}