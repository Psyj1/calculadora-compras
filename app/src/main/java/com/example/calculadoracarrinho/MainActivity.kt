package com.example.calculadoracarrinho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculadoracarrinho.data.Catalogo
import com.example.calculadoracarrinho.ui.screens.CarrinhoScreen
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CalculadoraCarrinhoTheme {
                CarrinhoScreen(carrinho = Catalogo.carrinhoValidacao)
            }
        }
    }
}