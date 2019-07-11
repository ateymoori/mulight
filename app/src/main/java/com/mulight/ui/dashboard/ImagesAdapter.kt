package com.mulight.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mulight.R
import com.mulight.utils.bases.listen
import com.mulight.utils.bases.loadFromURL
import com.mulight.utils.entities.ImageDBModel
import kotlinx.android.synthetic.main.image_thumbnail_item.view.*

class ImagesAdapter(private val items: List<ImageDBModel>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<ImagesAdapter.Holder>() {
    lateinit var mContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        mContext = parent.context
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.image_thumbnail_item, parent, false))
            .listen { pos, _ ->
                imageSelectHandler.onSelect(items[pos])
            }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = items[position].title
        holder.img.loadFromURL(items[position].address)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Holder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val img: ImageView = view.img
        val title: TextView = view.title
    }

    lateinit var imageSelectHandler: ImageSelect

    interface ImageSelect {
        fun onSelect(image: ImageDBModel)
    }
}