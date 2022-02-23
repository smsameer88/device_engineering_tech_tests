package com.cleanarchitecturenews.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleanarchitecturenews.R
import com.cleanarchitecturenews.databinding.NewsFragmentBinding
import com.cleanarchitecturenews.utils.Error
import com.cleanarchitecturenews.utils.Loading
import com.cleanarchitecturenews.utils.Success
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.news_fragment), NewsAdapter.OnClickListener {

    private val viewModel: NewsViewModel by activityViewModels()

    private lateinit var newsAdapter: NewsAdapter

    private lateinit var binding: NewsFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = NewsFragmentBinding.bind(view)
        binding.lifecycleOwner = this

        newsAdapter = NewsAdapter(this)

        binding.newsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = newsAdapter
        }

        viewModel.getAllCoins()
        observeUiState()
        observeArticleList()
    }

    private fun observeArticleList() {
        viewModel.articleList.observe(viewLifecycleOwner) {
            newsAdapter.submitList(it)
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is Loading -> showLoading()
                is Success -> showNewsData()
                is Error -> showError()
            }
        }
    }

    private fun showLoading() {
        binding.loadingSpinner.visibility = View.VISIBLE
        binding.tvError.visibility = View.GONE
    }

    private fun showError() {
        binding.tvError.visibility = View.VISIBLE
        binding.loadingSpinner.visibility = View.GONE
    }

    private fun showNewsData() {
        binding.loadingSpinner.visibility = View.GONE
        binding.tvError.visibility = View.GONE
    }

    override fun onNewsItemClick(author: String, url: String) {
        findNavController().navigate(
            NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(
                author,
                url
            )
        )
    }
}
