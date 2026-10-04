package com.example.calculadoracarrinho.model

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagavel {


    fun valorComDesconto(): Double = preco * (1 - descontoPercentual / 100.0)

    fun valorDesconto(): Double = preco - valorComDesconto()

    override fun valorTotal(): Double = valorComDesconto()
}