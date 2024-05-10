package org.d3if0154.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "penjualan")
data class Penjualan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val barang: String,
    val jumlah: Int,
    val tanggal: String
)
