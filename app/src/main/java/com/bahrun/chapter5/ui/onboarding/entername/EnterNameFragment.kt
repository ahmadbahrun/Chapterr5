package com.bahrun.chapter5.ui.onboarding.entername

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.FragmentEnterNameBinding
import com.bahrun.chapter5.ui.menu.GameMenuActivity
import com.bahrun.chapter5.ui.onboarding.onFinishNavigateListener


class EnterNameFragment : Fragment(), onFinishNavigateListener {

    private lateinit var binding: FragmentEnterNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterNameBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onFinishNavigateListener() {
        val name = binding.etInputName.text.toString().trim()
        if (name.isEmpty()){
            Toast.makeText(requireContext(), "Please input your name !", Toast.LENGTH_SHORT).show()
        }else{
            navigateToMenu(name)
        }
    }

    private fun navigateToMenu(name : String) {
        GameMenuActivity.startActivity(requireContext(),name)
        //Toast.makeText(requireContext(), "Welcome to My Game : $name", Toast.LENGTH_SHORT).show()
    }
}