package com.android.mtinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.android.mtinfo.databinding.FragmentTvShowBinding
import com.android.mtinfo.presentation.adapter.TvShowAdapter
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModel

class TvShowFragment : Fragment() {
    lateinit var tvShowViewModel: TvShowViewModel
    lateinit var tvShowAdapter: TvShowAdapter
    lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvShowBinding.bind(view)
        tvShowViewModel = (activity as MainActivity).tvShowViewModel
        tvShowAdapter = (activity as MainActivity).tvShowAdapter

        tvShowAdapter.setOnClickListener {
            val intent = Intent(context, InformationActivity::class.java)
            intent.apply {
                this.putExtra("category", "tvshow")
                this.putExtra("title", it.name)
                this.putExtra("poster", it.poster_path)
                this.putExtra("overview", it.overview)
            }
            (activity as MainActivity).startActivity(intent)
        }

        initRecyclerView()
        showTvShowList()
    }

    private fun initRecyclerView() {
        binding.rvTvshow.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showTvShowList() {
        binding.progressBar.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.getTvShow()
        responseLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                tvShowAdapter.differ.submitList(it.toList())
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}