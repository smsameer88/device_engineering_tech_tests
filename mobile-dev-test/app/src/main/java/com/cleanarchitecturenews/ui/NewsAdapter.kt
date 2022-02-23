package com.cleanarchitecturenews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cleanarchitecturenews.R
import com.cleanarchitecturenews.databinding.NewsItemBinding
import com.cleanarchitecturenews.models.ArticleUiModel

class NewsAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ArticleUiModel, NewsAdapter.NewsListViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListViewHolder {
        return NewsListViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClickListener)
    }

    class NewsListViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArticleUiModel, onClickListener: OnClickListener) {


            binding.tvAuthor.text = item.author
            binding.tvDescription.text = item.description
            Glide.with(itemView)
                .load(item.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)

            binding.clNews.setOnClickListener {
                onClickListener.onNewsItemClick(item.author.toString(), item.url.toString())
            }

            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ArticleUiModel>() {
        override fun areItemsTheSame(oldItem: ArticleUiModel, newItem: ArticleUiModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ArticleUiModel, newItem: ArticleUiModel): Boolean {
            return oldItem.author == newItem.author
        }
    }


    interface OnClickListener {
        fun onNewsItemClick(author: String, url: String)
    }
}