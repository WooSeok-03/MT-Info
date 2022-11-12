package com.android.mtinfo

import android.app.Activity.RESULT_OK
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.FragmentInterestBinding
import com.android.mtinfo.presentation.adapter.InterestAdapter
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModel
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InterestFragment : Fragment() {
    @Inject
    lateinit var factory: InterestViewModelFactory
    lateinit var viewModel: InterestViewModel
    lateinit var interestAdapter: InterestAdapter
    private lateinit var binding: FragmentInterestBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            viewInterestList()
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_interest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInterestBinding.bind(view)
        viewModel = ViewModelProvider(this, factory).get(InterestViewModel::class.java)

        initRecyclerView()
        viewInterestList()
    }

    private fun initRecyclerView() {
        interestAdapter = InterestAdapter()

        interestAdapter.setOnItemClickListener {
            val intent = Intent(requireContext(), InformationActivity::class.java).apply {
                putExtra("info", it)
            }
            launcher.launch(intent)
        }

        binding.rvInterest.apply {
            adapter = interestAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewInterestList() {
        val responseLiveData = viewModel.getSavedInterest()
        responseLiveData.observe(viewLifecycleOwner) {
            interestAdapter.differ.submitList(it?.toList())
        }
    }
}