package com.bahrun.chapter5.ui.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.ActivityGameMenuBinding
import com.bahrun.chapter5.ui.game.GameActivity

class GameMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameMenuBinding

    private val name: String? by lazy {
        intent.getStringExtra(EXTRAS_NAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setNameOnTitle()
        setMenuClickListeners()
    }

    private fun setMenuClickListeners() {
        binding.ivIcMenu1.setOnClickListener {

        }
        binding.ivIcMenu2.setOnClickListener {

        }
    }

    private fun setNameOnTitle() {
        binding.tvInput.text = "Welcome in Game Suit : $name"
        binding.tv
    }
    companion object{
        private const val EXTRAS_NAME = "EXTRAS_NAME"

        fun startActivity(context: Context, name: String){
            context.startActivity(Intent(context, GameMenuActivity::class.java).apply {
                putExtra(EXTRAS_NAME, name)
            })
        }
    }
}