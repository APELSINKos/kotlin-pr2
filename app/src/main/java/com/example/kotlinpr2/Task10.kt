package com.example.kotlinpr2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class ShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartScreen()
        }
    }
}

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }
    // the sum is calculated from the current list, not added up on every recomposition
    val totalSum = products.sumOf { it.price }

    Column(modifier = Modifier.systemBarsPadding()) {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        AddProductSection {
            val newProduct = Product(
                id = products.size,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(0, 100)
            )
            products = products + newProduct
            // the toast is shown in the click handler, not during composition
            if (totalSum + newProduct.price > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }
        RemoveProductSection(productSize = products.size) {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(
    onAdd: () -> Unit
) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    productSize: Int,
    onRemove: () -> Unit
) {
    if (productSize > 0) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}
