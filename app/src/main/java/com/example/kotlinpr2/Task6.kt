package com.example.kotlinpr2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Function 1: circle of its own size in the top right corner, black background
@Composable
fun CircleInCorner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(240.dp, 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг"
        )
    }
}

// Function 2: circle stretched to the box size, painted purple, blue background
@Composable
fun StretchedCircle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(240.dp, 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleInCornerPreview() {
    CircleInCorner()
}

@Preview(showBackground = true)
@Composable
fun StretchedCirclePreview() {
    StretchedCircle()
}
