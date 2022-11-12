package com.android.mtinfo.presentation.adapter

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.mtinfo.BuildConfig
import com.android.mtinfo.data.model.tvshow.TvShow
import com.android.mtinfo.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    inner class TvShowViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {

            val posterURL = BuildConfig.POSTER_URL + tvShow.poster_path
            Glide.with(binding.ivPoster)
                .load(posterURL)
                .into(binding.ivPoster)

            binding.cardView.setOnClickListener{
                onClickListener?.invoke(tvShow)
            }
        }
    }

    private val callback = object: DiffUtil.ItemCallback<TvShow>() {
        override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, callback)


    private var onClickListener: ((TvShow)->Unit) ?= null
    fun setOnClickListener(listener: (TvShow)->Unit) {
        onClickListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size
}