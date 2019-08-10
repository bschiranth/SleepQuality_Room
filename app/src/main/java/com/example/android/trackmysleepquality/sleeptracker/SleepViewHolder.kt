package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListSleepItemViewBinding

class SleepViewHolder private constructor(val binding: ListSleepItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(holder: SleepViewHolder, dataItem: SleepNight) {
        val res = holder.itemView.context.resources
        binding.sleepLength.text = convertDurationToFormatted(dataItem.startTimeMilli, dataItem.endTimeMilli, res)
        binding.qualityString.text = convertNumericQualityToString(dataItem.sleepQuality, res)

        binding.qualityImage.setImageResource(when (dataItem.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }

    companion object {
        fun from(parent: ViewGroup): SleepViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListSleepItemViewBinding.inflate(layoutInflater, parent, false)
            return SleepViewHolder(binding)
        }
    }
}