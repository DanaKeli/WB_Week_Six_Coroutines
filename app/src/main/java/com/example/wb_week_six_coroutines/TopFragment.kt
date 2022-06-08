package com.example.wb_week_six_coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.wb_week_six_coroutines.databinding.FragmentTopBinding

class TopFragment : Fragment() {
    private var _binding: FragmentTopBinding? = null
    private val binding: FragmentTopBinding get() = _binding!!
    private lateinit var vm: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopBinding.inflate(inflater, container, false)
        vm = ViewModelProviders.of(requireActivity()).get(VM::class.java)
        vm.pi.observe(viewLifecycleOwner) {
            binding.tvPi.text = it
        }
        binding.scrollView.fullScroll(View.FOCUS_DOWN)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}