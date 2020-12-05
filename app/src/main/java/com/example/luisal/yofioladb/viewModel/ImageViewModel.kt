package com.example.luisal.yofioladb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.luisal.yofioladb.itemsClass.ItemImage

class ImageViewModel: ViewModel() {
    private  val _imageList: MutableLiveData<MutableList<ItemImage>> by lazy {
        MutableLiveData<MutableList<ItemImage>>().apply {
            value = mutableListOf()
        }
    }
    val imageList: LiveData<MutableList<ItemImage>> get() = _imageList

    fun getImage() {
        _imageList.postValue(mutableListOf())
    }
}