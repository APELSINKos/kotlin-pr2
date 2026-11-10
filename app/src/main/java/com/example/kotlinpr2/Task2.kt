package com.example.kotlinpr2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinpr2.ui.theme.KotlinPR2Theme

// Task 2: three previews for HelloPreview
@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape"
)
@Preview(
    name = "round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp,dpi=240,isRound=true"
)
@Composable
fun HelloPreview() {
    KotlinPR2Theme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Hello(name = "Александр")
        }
    }
}
