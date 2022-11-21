package com.bahrun.chapter5.ui.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.ActivityGameMenuBinding
import com.bahrun.chapter5.databinding.GameActivityBinding
import com.bahrun.chapter5.ui.game.GameActivity
import com.bahrun.chapter5.ui.game.MultippelActivity
import com.bahrun.chapter5.ui.menu.GameMenuActivity.Companion.startActivityGameActivity
import kotlinx.coroutines.NonCancellable.start

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
        binding.ivIcMenuVsPlayer2.setOnClickListener {
            MultippelActivity.startActivityMultiple(this)
        }
        binding.ivIcMenuVsComputer.setOnClickListener {
            GameActivity.startActivityComputer(this)
        }
    }

    private fun setNameOnTitle() {
        binding.tvInput.text = "Welcome in Game Suit : $name"
        binding.tvVsPlayer2.text = "$name VS Player2"
        binding.tvVsComputer.text = "$name VS Computer"
    }
    companion object{
        private const val EXTRAS_NAME = "EXTRAS_NAME"

        fun startActivityGameActivity(context: Context, name: String){
            context.startActivity(Intent(context, GameMenuActivity::class.java).apply {
                putExtra(EXTRAS_NAME, name)
            })
        }

    }
}