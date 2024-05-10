package org.d3if0154.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0154.myapplication.model.Penjualan

@Database(entities = [Penjualan::class], version = 1, exportSchema = false)
abstract class PenjualanDb : RoomDatabase() {

    abstract val dao: PenjualanDao

    companion object {

        @Volatile
        private var INSTANCE: PenjualanDb? = null

        fun getInstance(context: Context): PenjualanDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PenjualanDb::class.java,
                        "penjualan.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}