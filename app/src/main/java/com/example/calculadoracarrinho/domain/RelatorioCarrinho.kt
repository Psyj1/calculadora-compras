package com.example.calculadoracarrinho.domain

import android.util.Log
import com.example.calculadoracarrinho.model.ItemCarrinho

private const val TAG = "Carrinho"

fun subtotalBruto(carrinho: List<ItemCarrinho>): Double =
    carrinho
        .map { it.subtotalBruto() }
        .reduce { acc, valor -> acc + valor }

fun totalDescontos(carrinho: List<ItemCarrinho>): Double =
    carrinho
        .map { it.totalDesconto() }
        .reduce { acc, valor -> acc + valor }

fun totalFinal(carrinho: List<ItemCarrinho>): Double =
    carrinho
        .map { it.valorTotal() }
        .reduce { acc, valor -> acc + valor }

fun imprimirRelatorioDescontos(carrinho: List<ItemCarrinho>) {
    Log.i(TAG, "=== Produtos com desconto aplicado (maior → menor) ===")

    carrinho
        .filter { it.produto.descontoPercentual > 0.0 }
        .sortedByDescending { it.valorTotal() }
        .map { "${it.produto.nome} — ${it.valorTotal().emReais()}" }
        .forEach { Log.i(TAG, it) }

    Log.i(TAG, "======================================================")
}