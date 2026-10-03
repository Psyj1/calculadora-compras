package com.example.calculadoracarrinho.model

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {

    /** Subtotal bruto: preço cheio × quantidade. */
    fun subtotalBruto(): Double = produto.preco * quantidade

    /** Subtotal já com desconto aplicado × quantidade. */
    override fun valorTotal(): Double = produto.valorComDesconto() * quantidade

    /** Total de desconto deste item. */
    fun totalDesconto(): Double = produto.valorDesconto() * quantidade
}