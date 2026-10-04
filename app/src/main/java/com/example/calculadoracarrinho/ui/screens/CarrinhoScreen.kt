package com.example.calculadoracarrinho.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoracarrinho.data.Catalogo
import com.example.calculadoracarrinho.domain.emReais
import com.example.calculadoracarrinho.domain.subtotalBruto
import com.example.calculadoracarrinho.domain.totalDescontos
import com.example.calculadoracarrinho.domain.totalFinal
import com.example.calculadoracarrinho.model.ItemCarrinho
import com.example.calculadoracarrinho.ui.components.CardResumo
import com.example.calculadoracarrinho.ui.components.LinhaProduto
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarrinhoScreen(carrinho: List<ItemCarrinho>) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Carrinho de Compras") })
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // Itens do carrinho
            items(carrinho) { item ->
                LinhaProduto(
                    nome = item.produto.nome,
                    descricao = item.produto.descricao,
                    quantidade = item.quantidade,
                    precoUnitario = item.produto.preco.emReais(),
                    subtotal = item.valorTotal().emReais(),
                    descontoPercentual = item.produto.descontoPercentual
                )
            }

            item {
                CardResumo(
                    subtotalBruto = subtotalBruto(carrinho).emReais(),
                    totalDescontos = totalDescontos(carrinho).emReais(),
                    totalFinal = totalFinal(carrinho).emReais()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CarrinhoScreenPreview() {
    CalculadoraCarrinhoTheme {
        CarrinhoScreen(carrinho = Catalogo.carrinhoValidacao)
    }
}