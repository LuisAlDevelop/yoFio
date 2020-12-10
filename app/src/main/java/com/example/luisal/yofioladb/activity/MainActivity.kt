package com.example.luisal.yofioladb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.luisal.yofioladb.adapters.ImagenViewPagerAdapter
import com.example.luisal.yofioladb.databinding.ActivityMainBinding
import com.example.luisal.yofioladb.viewModel.ImageViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val viewModelImage: ImageViewModel by lazy {
        ViewModelProviders.of(this).get(ImageViewModel::class.java)
    }

    private val imagesAdapter: ImagenViewPagerAdapter by lazy {
        ImagenViewPagerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpOnClickListener()
        setUpRecyclerView()
        setUpOnObservable()
        viewModelImage.getImage()
    }

    private fun setUpOnClickListener() {
        binding.apply {
            txtImage.setOnClickListener {
                if (recyclerDataImages.visibility == View.VISIBLE){
                    recyclerDataImages.visibility = View.GONE
                }else {
                    recyclerDataImages.visibility = View.VISIBLE
                }
            }
            txtVideos.setOnClickListener {
                if (recyclerDataVideos.visibility == View.VISIBLE){
                    recyclerDataVideos.visibility = View.GONE
                }else{
                    recyclerDataVideos.visibility = View.VISIBLE
                }
            }
            txtMusic.setOnClickListener {
                if (recyclerDataMusic.visibility == View.VISIBLE){
                    recyclerDataMusic.visibility = View.GONE
                }else{
                    recyclerDataMusic.visibility = View.VISIBLE
                }
            }
            txtOther.setOnClickListener {
                if (recyclerDataOther.visibility == View.VISIBLE){
                    recyclerDataOther.visibility = View.GONE
                }else{
                    recyclerDataOther.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setUpRecyclerView(){
        binding.apply {
            recyclerDataImages.adapter = imagesAdapter
        }
    }

    private fun setUpOnObservable(){
        viewModelImage.imageList.observe(this, Observer { itemList ->
            imagesAdapter.setDataList(itemList)
            binding.txtImage.text = "Imagenes: ${itemList.size}"
        })
    }
}