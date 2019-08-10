package com.example.android.trackmysleepquality.sleeptracker

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter(val sleepNightListener: SleepNightListener) : ListAdapter<SleepNight, SleepViewHolder>(SleepNightDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  SleepViewHolder {
        return SleepViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.bind(dataItem, sleepNightListener)
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

class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNight) = clickListener(night.nightId)
}