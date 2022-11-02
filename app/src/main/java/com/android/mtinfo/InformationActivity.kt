package com.android.mtinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.databinding.ActivityInformationBinding
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModel
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModelFactory
import com.bumptech.glide.Glide
import javax.inject.Inject

class InformationActivity : AppCompatActivity() {
    lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val category = intent.getStringExtra("category")
        val title = intent.getStringExtra("title")
        val poster = intent.getStringExtra("poster")
        val overview = intent.getStringExtra("overview")

        binding.tvTitle.text = title
        binding.tvDescription.text = overview
        val posterURL = BuildConfig.POSTER_URL + poster
        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)
    }

}