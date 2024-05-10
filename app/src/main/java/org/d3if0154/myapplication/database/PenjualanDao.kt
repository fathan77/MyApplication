package org.d3if0154.myapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.d3if0154.myapplication.model.Penjualan
import kotlinx.coroutines.flow.Flow

@Dao
interface PenjualanDao {

    @Insert
    suspend fun insert(penjualan: Penjualan)

    @Update
    suspend fun update(penjualan: Penjualan)

    @Query("SELECT * FROM penjualan ORDER BY tanggal DESC")
    fun getPenjualan(): Flow<List<Penjualan>>

    @Query("SELECT * FROM penjualan WHERE id = :id")
    suspend fun getPenjualanById(id: Long): Penjualan?

    @Query("DELETE FROM penjualan WHERE id = :id")
    suspend fun deleteById(id: Long)
}