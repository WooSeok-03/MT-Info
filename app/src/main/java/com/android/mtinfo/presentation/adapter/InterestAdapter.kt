package com.android.mtinfo.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.mtinfo.BuildConfig
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.ListItemBinding
import com.bumptech.glide.Glide

class InterestAdapter: RecyclerView.Adapter<InterestAdapter.InterestViewHolder>() {
    inner class InterestViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(interest: Information) {

            val posterURL = BuildConfig.POSTER_URL + interest.poster_path
            Glide.with(binding.ivPoster.context)
                .load(posterURL)
                .into(binding.ivPoster)

            binding.cardView.setOnClickListener{
                onItemClickListener?.invoke(interest)
            }
        }
    }

    private val callback = object : DiffUtil.ItemCallback<Information>() {
        override fun areItemsTheSame(oldItem: Information, newItem: Information): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Information, newItem: Information): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)


    private var onItemClickListener: ((Information)->Unit) ?= null
    fun setOnItemClickListener(listener: (Information)->Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InterestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InterestViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size
}