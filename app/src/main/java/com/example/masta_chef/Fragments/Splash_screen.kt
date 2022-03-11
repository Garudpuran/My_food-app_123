package com.example.masta_chef.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.BackStackEntry
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.masta_chef.databinding.FragmentSplashScreenBinding



class Splash_screen : Fragment() {
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
Handler().postDelayed({
                 val action = Splash_screenDirections.actionSplashScreenToItemListFragment()
    binding.lottieAnimationView.findNavController().navigate(action)
    FragmentTransaction.TRANSIT_FRAGMENT_CLOSE
},2000)

    }

}