package com.example.m5lesson1.presenter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m5lesson1.databinding.FragmentCounterBinding
import com.example.m5lesson1.presenter.viewmodel.CounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CounterViewModel by viewModels()
    private val koinViewModel by viewModel<CounterViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val text = binding.edText.text.toString()
            val apiKey = "7d6454ad-5149-4c51-b2f9-615b091e98da:fx"
            if (text.isNotEmpty()) {
                viewModel.translateText(apiKey, text,"ru")
            }
        }

        viewModel.translation.observe(viewLifecycleOwner) { translation ->
            binding.text.text = translation
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}