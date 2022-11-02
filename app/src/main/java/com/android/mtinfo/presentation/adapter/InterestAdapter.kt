package com.android.mtinfo.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.mtinfo.BuildConfig
import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.databinding.ListItemBinding
import com.bumptech.glide.Glide

class InterestAdapter: RecyclerView.Adapter<InterestAdapter.InterestViewHolder>() {
    inner class InterestViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(interest: Interest) {

            val posterURL = BuildConfig.POSTER_URL + interest.poster_path
            Glide.with(binding.ivPoster.context)
                .load(posterURL)
                .into(binding.ivPoster)

            binding.cardView.setOnClickListener{
                onItemClickListener?.let {
                    it(interest)
                }
            }
        }
    }

    private val callback = object : DiffUtil.ItemCallback<Interest>() {
        override fun areItemsTheSame(oldItem: Interest, newItem: Interest): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Interest, newItem: Interest): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)


    private lateinit var onItemClickListener: ((Interest)->Unit)
    fun setOnItemClickListener(listener: (Interest)->Unit) {
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