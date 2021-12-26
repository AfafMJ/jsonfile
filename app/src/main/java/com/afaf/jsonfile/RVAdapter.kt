package com.afaf.jsonfile


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afaf.jsonfile.databinding.ItemRowBinding
import com.bumptech.glide.Glide


class RVAdapter(private val images: ArrayList<Image>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        return ViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        val image = images[position]

        holder.binding.apply {
            textView.text = image.title
            Glide.with(holder.itemView.context)
                .load(image.url)
                .into(imageView)
        }
    }

    override fun getItemCount(): Int = images.size

}
