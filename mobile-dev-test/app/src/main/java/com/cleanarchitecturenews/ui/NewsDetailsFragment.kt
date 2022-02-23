package com.cleanarchitecturenews.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cleanarchitecturenews.R
import com.cleanarchitecturenews.databinding.NewsDetailsFragmentBinding
import com.cleanarchitecturenews.utils.Error
import com.cleanarchitecturenews.utils.Loading
import com.cleanarchitecturenews.utils.Success
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment(R.layout.news_details_fragment) {

    private val viewModel: NewsViewModel by activityViewModels()

    private lateinit var binding: NewsDetailsFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = NewsDetailsFragmentBinding.bind(view)
        binding.lifecycleOwner = this

        NewsDetailsFragmentArgs.fromBundle(requireArguments()).apply {
            viewModel.author = author
            viewModel.url = url
        }

        binding.webView.webViewClient = WebViewClient()

        binding.webView.loadUrl(viewModel.url)

        true.also { binding.webView.settings.javaScriptEnabled = it }

        val likesUrl = "https://cn-news-info-api.herokuapp.com/likes/${
            viewModel.url.replace("https://", "").replace("/", "-")
        }"

        val commentsUrl =
            "https://cn-news-info-api.herokuapp.com/comments/${
                viewModel.url.replace("https://", "").replace("/", "-")
            }"

        viewModel.getLikes(likesUrl)
        viewModel.getComments(commentsUrl)
        observeUiState()
        observeLikesComments()
    }

    private fun observeLikesComments() {
        viewModel.likesList.observe(viewLifecycleOwner) {
            binding.tvLikes.text = it.likes.toString()
            binding.textView.visibility = View.VISIBLE
            binding.tvLikes.visibility = View.VISIBLE
        }

        viewModel.commentsList.observe(viewLifecycleOwner) {
            binding.tvNoOfComments.text = it.comments.toString()
            binding.textView4.visibility = View.VISIBLE
            binding.tvNoOfComments.visibility = View.VISIBLE
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
}
