package com.example.calculadoracarrinho

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadoracarrinho.data.Catalogo
import com.example.calculadoracarrinho.domain.emReais
import com.example.calculadoracarrinho.domain.imprimirRelatorioDescontos
import com.example.calculadoracarrinho.domain.subtotalBruto
import com.example.calculadoracarrinho.domain.totalDescontos
import com.example.calculadoracarrinho.domain.totalFinal
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ── Parte 1: teste no Logcat ─────────────────────────────
        val carrinho = Catalogo.carrinhoValidacao

        Log.i("Carrinho", "Subtotal bruto: ${subtotalBruto(carrinho).emReais()}")
        Log.i("Carrinho", "Descontos: ${totalDescontos(carrinho).emReais()}")
        Log.i("Carrinho", "Total final: ${totalFinal(carrinho).emReais()}")

        imprimirRelatorioDescontos(carrinho)
        // ─────────────────────────────────────────────────────────

        setContent {
            CalculadoraCarrinhoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = "Testando a Parte 1 — veja o Logcat",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    CalculadoraCarrinhoTheme {
        Text("Preview")
    }
}