package com.example.calculadoracarrinho.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LinhaProduto(
    nome: String,
    descricao: String?,
    quantidade: Int,
    precoUnitario: String,
    subtotal: String,
    descontoPercentual: Double,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = nome,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = descricao ?: "Sem descrição",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 4.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Qtd: $quantidade",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(
                    text = "Unit.: $precoUnitario",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(end = 12.dp)
                )
                if (descontoPercentual > 0.0) {
                    Text(
                        text = "-${descontoPercentual}%",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Text(
                text = subtotal,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LinhaProdutoPreview() {
    LinhaProduto(
        nome = "Notebook Dell Inspiron",
        descricao = "Intel Core i7, 16GB RAM, SSD 512GB, tela 15,6\" Full HD.",
        quantidade = 2,
        precoUnitario = "R$ 3.499,00",
        subtotal = "R$ 6.648,10",
        descontoPercentual = 5.0
    )
}

@Preview(showBackground = true, name = "Sem descrição")
@Composable
private fun LinhaProdutoSemDescricaoPreview() {
    LinhaProduto(
        nome = "Headset Gamer",
        descricao = null,
        quantidade = 1,
        precoUnitario = "R$ 199,90",
        subtotal = "R$ 199,90",
        descontoPercentual = 0.0
    )
}