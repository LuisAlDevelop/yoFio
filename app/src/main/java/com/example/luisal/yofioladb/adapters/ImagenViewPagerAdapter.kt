package com.example.luisal.yofioladb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.luisal.yofioladb.databinding.ItemImageBinding
import com.example.luisal.yofioladb.itemsClass.ItemImage

class ImagenViewPagerAdapter(private val items: MutableList<ItemImage> = arrayListOf()):
    RecyclerView.Adapter<ImagenViewPagerAdapter.MyViewHolderImage>() {

    fun setDataList(data: MutableList<ItemImage>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: MyViewHolderImage, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolderImage {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemImageBinding.inflate(layoutInflater, parent, false)
        return MyViewHolderImage(binding)
    }

    class MyViewHolderImage(val binding: ItemImageBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ItemImage) {
            binding.apply {
                dataImage = data
                executePendingBindings()
            }
        }
    }
}