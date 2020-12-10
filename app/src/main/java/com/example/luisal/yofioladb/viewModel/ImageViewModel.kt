package com.example.luisal.yofioladb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.luisal.yofioladb.itemsClass.ItemImage

class ImageViewModel: ViewModel() {
    private  val _imageList: MutableLiveData<MutableList<ItemImage>> by lazy {
        MutableLiveData<MutableList<ItemImage>>().apply {
            value = mutableListOf(
                ItemImage("nameImage", "in file", "584.3", "05-06-20", "134.4"),
                ItemImage("nameData", "in file", "584.3", "05-06-20", "134.4")
            )

        }
    }
    val imageList: LiveData<MutableList<ItemImage>> get() = _imageList

    fun getImage() {
        //_imageList.postValue(mutableListOf())
    }
}