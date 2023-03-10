package com.example.androidtestapp.data

import androidx.room.Insert
import androidx.room.Query

interface SpendDao {
    @Insert
    suspend fun addSpend(spend: Spend)

    @Query("SELECT * FROM spends ORDER BY date DESC LIMIT 20")
    suspend fun getLast20Spends(): List<Spend>
}