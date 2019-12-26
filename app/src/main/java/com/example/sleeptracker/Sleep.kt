package com.example.sleeptracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep")
data class Sleep (
    @PrimaryKey(autoGenerate = true) val id:Int,
    val startDate: Long = System.currentTimeMillis(),
    val endDate: String,
    val quality: Int
)