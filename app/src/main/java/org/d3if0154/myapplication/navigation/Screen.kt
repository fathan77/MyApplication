package org.d3if0154.myapplication.navigation


import org.d3if0154.myapplication.ui.screen.KEY_ID_PENJUALAN

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_PENJUALAN}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}