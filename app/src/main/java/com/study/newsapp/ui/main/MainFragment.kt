package com.study.newsapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.newsapp.R
import com.study.newsapp.databinding.FragmentMainBinding
import com.study.newsapp.ui.adapters.NewsAdapter
import com.study.newsapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.news_adapter
import kotlinx.android.synthetic.main.fragment_main.progress_bar


@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding:FragmentMainBinding? = null
    private val mBinding get() = binding!!

    private val viewModel : MainViewModel by  viewModels<MainViewModel>()
    lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        newsAdapter.setOnItemClickListener {
            val bundle = bundleOf("article" to it)
            view.findNavController().navigate(
                R.id.action_mainFragment_to_detailsFragment,
                bundle
            )
        }

        viewModel.newsLiveData.observe(viewLifecycleOwner){
            response ->
            when(response){
                is Resource.Success -> {
                   progress_bar.visibility = View.INVISIBLE
                   response.data?.let {
                       newsAdapter.differ.submitList(it.articles)
                   }
                }
                is Resource.Error -> {
                    progress_bar.visibility = View.INVISIBLE
                    response.data?.let {
                        Log.e("checkData", "MainFragment error: ${it}")
                    }
                }

                is Resource.Loading -> {
                    progress_bar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun initAdapter(){
        newsAdapter = NewsAdapter()
        news_adapter.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}