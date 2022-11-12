package com.android.mtinfo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.FragmentTvShowBinding
import com.android.mtinfo.domain.InformationCategory
import com.android.mtinfo.presentation.adapter.TvShowAdapter
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModel
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowFragment : Fragment() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    lateinit var viewModel: TvShowViewModel
    lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvShowBinding.bind(view)
        viewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecyclerView()
        showTvShowList()
    }

    private fun initRecyclerView() {
        tvShowAdapter = TvShowAdapter()

        tvShowAdapter.setOnClickListener {
            val intent = Intent(context, InformationActivity::class.java)
            val information = Information(
                id = it.id,
                title = it.name,
                overview = it.overview,
                poster_path = it.poster_path,
                category = InformationCategory.TV_SHOW
            )
            intent.putExtra("info", information)

            requireActivity().startActivity(intent)
        }

        binding.rvTvshow.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showTvShowList() {
        binding.progressBar.visibility = View.VISIBLE

        val responseLiveData = viewModel.getTvShow()
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