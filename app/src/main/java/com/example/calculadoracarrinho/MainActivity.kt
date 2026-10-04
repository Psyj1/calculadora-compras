package com.example.calculadoracarrinho

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculadoracarrinho.data.Catalogo
import com.example.calculadoracarrinho.domain.emReais
import com.example.calculadoracarrinho.domain.imprimirRelatorioDescontos
import com.example.calculadoracarrinho.domain.subtotalBruto
import com.example.calculadoracarrinho.domain.totalDescontos
import com.example.calculadoracarrinho.domain.totalFinal
import com.example.calculadoracarrinho.ui.screens.CarrinhoScreen
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Gera o relatório funcional no Logcat (filtro: "Carrinho").
        // Fica aqui para que rodar o app já produza a saída esperada pelo enunciado.
        imprimirRelatorio()

        setContent {
            CalculadoraCarrinhoTheme {
                CarrinhoScreen(carrinho = Catalogo.carrinhoValidacao)
            }
        }
    }

    private fun imprimirRelatorio() {
        val carrinho = Catalogo.carrinhoValidacao
        Log.i("Carrinho", "Subtotal bruto: ${subtotalBruto(carrinho).emReais()}")
        Log.i("Carrinho", "Descontos: ${totalDescontos(carrinho).emReais()}")
        Log.i("Carrinho", "Total final: ${totalFinal(carrinho).emReais()}")
        imprimirRelatorioDescontos(carrinho)
    }
}