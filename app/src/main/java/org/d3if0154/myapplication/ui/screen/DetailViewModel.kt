package org.d3if0154.myapplication.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.d3if0154.myapplication.database.PenjualanDao
import org.d3if0154.myapplication.model.Penjualan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: PenjualanDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(barang: String, jumlah: Int) {
        val penjualan = Penjualan(
            tanggal = formatter.format(Date()),
            barang = barang,
            jumlah = jumlah.toInt()
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(penjualan)
        }
    }

    suspend fun getPenjualan(id: Long): Penjualan? {
        return dao.getPenjualanById(id)
    }

    fun update(id: Long, barang: String, jumlah: Int) {
        val penjualan = Penjualan(
            id = id,
            tanggal = formatter.format(Date()),
            barang = barang,
            jumlah = jumlah.toInt()
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(penjualan)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}