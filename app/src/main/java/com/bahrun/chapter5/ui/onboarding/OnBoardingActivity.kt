package com.bahrun.chapter5.ui.onboarding

import android.os.Bundle
import android.os.PersistableBundle
import android.view.ActionMode
import androidx.fragment.app.Fragment
import com.bahrun.chapter5.R
import com.bahrun.chapter5.ui.onboarding.entername.EnterNameFragment
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment

class OnBoardingActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setupSliderFragment()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if (currentFragment is onFinishNavigateListener){
            currentFragment.onFinishNavigateListener()
        }
    }
    private fun setupSliderFragment(){
        isSkipButtonEnabled = false
        addSlide(AppIntroFragment.createInstance(
            title = getString(R.string.text_title_onboarding_1),
            description = getString(R.string.text_desc_onBoarding_1),
            imageDrawable = R.drawable.ic_landing_page1,
            descriptionColorRes = R.color.blue,
            titleColorRes = R.color.blue
        ))

        addSlide(AppIntroFragment.createInstance(
            title = "Let's get started",
            description = "Game Suit VS Computer",
            imageDrawable = R.drawable.ic_landing_page2,
            descriptionColorRes = R.color.blue,
            titleColorRes = R.color.blue
        ))

        addSlide(EnterNameFragment())
    }
}

interface onFinishNavigateListener{
    fun onFinishNavigateListener()
}