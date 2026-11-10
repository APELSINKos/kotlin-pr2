package com.example.kotlinpr2

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// Variant 1: green italic text, 16 sp, centered
@Composable
fun GreenItalicText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_info),
        modifier = modifier,
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

// Variant 2: only one line, the end is replaced with an ellipsis
@Composable
fun OneLineText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_info),
        modifier = modifier,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

// Variant 3: first line indent 48 sp, 24 sp, black underlined text on green background
@Composable
fun UnderlinedText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_info),
        modifier = modifier.background(Color.Green),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp))
    )
}

@Preview(showBackground = true)
@Composable
fun GreenItalicTextPreview() {
    GreenItalicText()
}

@Preview(showBackground = true)
@Composable
fun OneLineTextPreview() {
    OneLineText()
}

@Preview(showBackground = true)
@Composable
fun UnderlinedTextPreview() {
    UnderlinedText()
}
