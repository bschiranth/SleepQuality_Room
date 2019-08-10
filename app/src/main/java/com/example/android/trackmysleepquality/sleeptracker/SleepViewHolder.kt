package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListSleepItemViewBinding

class SleepViewHolder private constructor(val binding: ListSleepItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataItem: SleepNight) {
        binding.sleep = dataItem
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): SleepViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListSleepItemViewBinding.inflate(layoutInflater, parent, false)
            return SleepViewHolder(binding)
        }
    }
}