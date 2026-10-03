package com.example.calculadoracarrinho.model

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagavel {


    fun valorComDesconto(): Double = preco * (1 - descontoPercentual / 100.0)

    /** Valor do desconto em reais. */
    fun valorDesconto(): Double = preco - valorComDesconto()

    /** Como um Produto isolado é "1 unidade", seu total é seu valor com desconto. */
    override fun valorTotal(): Double = valorComDesconto()
}