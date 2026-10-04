package com.example.calculadoracarrinho.model

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {

    fun subtotalBruto(): Double = produto.preco * quantidade

    override fun valorTotal(): Double = produto.valorComDesconto() * quantidade

    fun totalDesconto(): Double = produto.valorDesconto() * quantidade
}