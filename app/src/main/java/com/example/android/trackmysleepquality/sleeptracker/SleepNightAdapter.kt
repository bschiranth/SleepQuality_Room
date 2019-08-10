package com.example.android.trackmysleepquality.sleeptracker

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter : ListAdapter<SleepNight, SleepViewHolder>(SleepNightDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  SleepViewHolder {
        return SleepViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.bind(holder, dataItem)
    }
}


class SleepNightDiffUtilCallback: DiffUtil.ItemCallback<SleepNight>() {

    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
       return oldItem == newItem
    }

}