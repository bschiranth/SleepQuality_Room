package com.example.android.trackmysleepquality.sleeptracker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import kotlinx.android.synthetic.main.list_sleep_item_view.view.*

class SleepViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
    val quality: TextView = itemView.findViewById(R.id.quality_string)
    val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

}