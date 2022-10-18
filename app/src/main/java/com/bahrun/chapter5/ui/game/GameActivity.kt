package com.bahrun.chapter5.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bahrun.chapter5.R

class GameActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        supportActionBar?.hide()
    }
}