package com.example.kotlinpr2

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Task 1: greeting with a name that can be null
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    val text = if (name != null) "Привет, $name!" else "Имя не задано"
    Text(
        text = text,
        modifier = modifier
    )
}
