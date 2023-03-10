package com.example.taskapp.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.data.local.Pref
import com.example.taskapp.databinding.FragmentOnBoardBinding
import com.example.taskapp.ui.onBoard.adapter.OnBoardAdapter

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        val adapter = OnBoardAdapter() {
            pref.saveUserSeen()
            findNavController().navigate(R.id.navigation_home)
        }
        binding.viewpager2.adapter = adapter
        binding.indicator.setViewPager(binding.viewpager2)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver);
    }

}