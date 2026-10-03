package com.example.calculadoracarrinho.domain

import android.util.Log
import com.example.calculadoracarrinho.model.ItemCarrinho

private const val TAG = "Carrinho"

/** Subtotal bruto: soma dos preços cheios × quantidade. */
fun subtotalBruto(carrinho: List<ItemCarrinho>): Double =
    carrinho
        .map { it.subtotalBruto() }
        .reduce { acc, valor -> acc + valor }

/** Total de descontos aplicados no carrinho. */
fun totalDescontos(carrinho: List<ItemCarrinho>): Double =
    carrinho
        .map { it.totalDesconto() }
        .reduce { acc, valor -> acc + valor }

/** Total final do carrinho (já com descontos). */
fun totalFinal(carrinho: List<ItemCarrinho>): Double =
    carrinho
        .map { it.valorTotal() }
        .reduce { acc, valor -> acc + valor }

/**
 * Relatório no Logcat: apenas produtos COM desconto,
 * ordenados do maior valor total para o menor.
 */
fun imprimirRelatorioDescontos(carrinho: List<ItemCarrinho>) {
    Log.i(TAG, "=== Produtos com desconto aplicado (maior → menor) ===")

    carrinho
        .filter { it.produto.descontoPercentual > 0.0 }
        .sortedByDescending { it.valorTotal() }
        .map { "${it.produto.nome} — ${it.valorTotal().emReais()}" }
        .forEach { Log.i(TAG, it) }

    Log.i(TAG, "======================================================")
}