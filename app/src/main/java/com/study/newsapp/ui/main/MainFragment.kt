package com.study.newsapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.study.newsapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding:FragmentMainBinding? = null
    private val mBinding get() = binding!!

    private val viewModel : MainViewModel by  viewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment", "onViewCreated: ViewModel loading started") // Отладочное сообщение при начале загрузки ViewModel
        try {
            viewModel.all
        } catch (e: Exception) {
            Log.e("MainFragment", "onViewCreated: ViewModel loading failed", e) // Отладочное сообщение в случае ошибки загрузки ViewModel
        }
    }
}