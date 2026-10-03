package com.example.calculadoracarrinho.data

import com.example.calculadoracarrinho.model.ItemCarrinho
import com.example.calculadoracarrinho.model.Produto

object Catalogo {

    // Produtos (lista fixa)
    val notebook = Produto(
        nome = "Notebook Dell Inspiron",
        preco = 3499.00,
        descricao = "Intel Core i7, 16GB RAM, SSD 512GB, tela 15,6\" Full HD.",
        descontoPercentual = 5.0
    )

    val mouse = Produto(
        nome = "Mouse sem fio",
        preco = 89.90,
        descricao = "Mouse óptico sem fio com receptor USB, 1600 DPI.",
        descontoPercentual = 0.0
    )

    val teclado = Produto(
        nome = "Teclado mecânico RGB",
        preco = 349.90,
        descricao = "Teclado mecânico com switches azuis e iluminação RGB.",
        descontoPercentual = 0.0
    )

    val monitorUltrawide = Produto(
        nome = "Monitor Ultrawide Gamer 34 Polegadas Curvo 144Hz",
        preco = 2899.00,
        descricao = "Painel VA, resolução 3440x1440, 144Hz, FreeSync, curvatura 1500R.",
        descontoPercentual = 10.0
    )

    val headset = Produto(
        nome = "Headset Gamer",
        preco = 199.90,
        descricao = null, // sem descrição (obrigatório)
        descontoPercentual = 0.0
    )

    val webcam = Produto(
        nome = "Webcam Full HD",
        preco = 249.90,
        descricao = "Webcam 1080p com microfone embutido e foco automático.",
        descontoPercentual = 0.0
    )

    val cadeira = Produto(
        nome = "Cadeira Gamer Reclinável",
        preco = 1299.00,
        descricao = "Estrutura em aço, reclínio de 180°, apoio lombar e de braços.",
        descontoPercentual = 15.0
    )

    val mousepad = Produto(
        nome = "Mousepad Speed Extra Grande",
        preco = 79.90,
        descricao = "Mousepad 90x40cm, borda costurada e base antiderrapante.",
        descontoPercentual = 0.0
    )

    // Carrinho com o cenário de validação do PDF
    val carrinhoValidacao: List<ItemCarrinho> = listOf(
        ItemCarrinho(notebook, quantidade = 2),
        ItemCarrinho(mouse, quantidade = 1),
        ItemCarrinho(teclado, quantidade = 1),
    )
}