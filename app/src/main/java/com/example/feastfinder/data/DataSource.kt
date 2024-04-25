package com.example.feastfinder.data

import com.example.feastfinder.R
import com.example.feastfinder.ui.theme.model.Platillo


class DataSource() {
    fun loadPlatillos(): List<Platillo>{
        return listOf(
            Platillo(R.string.chilaquiles,R.drawable.chilaquiles),
            Platillo(R.string.camaron,R.drawable.tacos_camaron),
            Platillo(R.string.pizza,R.drawable.pizza),
            Platillo(R.string.pastel,R.drawable.pastel_chocolate),
            Platillo(R.string.pozole,R.drawable.pozole),
            Platillo(R.string.flan,R.drawable.flan)
        )
    }
}