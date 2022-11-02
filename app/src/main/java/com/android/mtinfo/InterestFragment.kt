package com.android.mtinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mtinfo.databinding.FragmentInterestBinding
import com.android.mtinfo.presentation.adapter.InterestAdapter
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModel

class InterestFragment : Fragment() {
    private lateinit var binding: FragmentInterestBinding
    lateinit var interestAdapter: InterestAdapter
    lateinit var interestViewModel: InterestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_interest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInterestBinding.bind(view)
        interestViewModel = (activity as MainActivity).interestViewModel
        interestAdapter = (activity as MainActivity).interestAdapter


    }

    private fun initRecyclerView() {
        binding.rvInterest.apply {
            adapter = interestAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewInterestList() {
        val responseLiveData = interestViewModel.getSavedInterest()
        responseLiveData.observe(viewLifecycleOwner) {
            interestAdapter.differ.submitList(it?.toList())
        }
    }
}