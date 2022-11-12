package com.android.mtinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.ActivityInformationBinding
import com.android.mtinfo.presentation.viewmodel.information.InformationViewModel
import com.android.mtinfo.presentation.viewmodel.information.InformationViewModelFactory
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InformationActivity : AppCompatActivity() {
    lateinit var binding: ActivityInformationBinding

    @Inject
    lateinit var factory: InformationViewModelFactory
    lateinit var viewModel: InformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, factory).get(InformationViewModel::class.java)
        setContentView(binding.root)


        val information = intent.getSerializableExtra("info") as Information

        viewModel.getLiked(information)

        binding.tvTitle.text = information.title
        binding.tvDescription.text = information.overview
        val posterURL = BuildConfig.POSTER_URL + information.poster_path
        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)

        viewModel.likeResult.observe(this) {
            binding.btLike.text = getString(if(it) R.string.liked else R.string.like)
            if(!it) setResult(RESULT_OK, Intent().putExtra("liked", it))
        }

        binding.btLike.setOnClickListener {
            viewModel.likeInterest(information)
        }
    }

}