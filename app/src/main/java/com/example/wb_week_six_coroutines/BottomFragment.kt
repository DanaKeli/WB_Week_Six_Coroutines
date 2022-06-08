package com.example.wb_week_six_coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.wb_week_six_coroutines.databinding.FragmentBottomBinding

class BottomFragment : Fragment() {

    private var _binding: FragmentBottomBinding? = null
    private val binding: FragmentBottomBinding get() = _binding!!
    private lateinit var vm: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomBinding.inflate(inflater, container, false)
        vm = ViewModelProviders.of(requireActivity()).get(VM::class.java)
        initViews()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        vm.onReset()
        _binding = null
    }


    private fun initViews() {
        binding.apply {
            vm.time.observe(viewLifecycleOwner) {
                tvTimer.text = Utils.getFormattedTime(it)
                if (it == 0L) {
                    root.setBackgroundColor(resources.getColor(R.color.white))
                } else if ((it % 20000) == 0L) {
                    root.setBackgroundColor(Utils.getColor())
                }
            }
            btnStart.setOnClickListener {
                vm.onStart()
            }
            btnPause.setOnClickListener {
                vm.onPause()
            }
            btnReset.setOnClickListener {
                vm.onReset()
            }
        }
    }
}