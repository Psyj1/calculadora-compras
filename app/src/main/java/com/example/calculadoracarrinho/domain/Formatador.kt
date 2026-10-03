package com.example.calculadoracarrinho.domain

import java.text.NumberFormat
import java.util.Locale

private val formatoBR: NumberFormat =
    NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

/** Formata um Double como "R$ 1.234,56". */
fun Double.emReais(): String = formatoBR.format(this)