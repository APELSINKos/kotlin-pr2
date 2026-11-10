package com.example.kotlinpr2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String?,
    val address: String
)

val contacts = listOf(
    Contact(
        "Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95",
        "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
    ),
    Contact(
        "Василий", "Егорович", "Кузякин", null,
        "Ивановская область, дер. Крутово, д. 4"
    ),
    Contact(
        "Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78",
        "Москва, Большая Никитская, д. 43, кв. 290"
    )
)

// Image 1: contact fields one under another
@Composable
fun ContactColumn(
    contact: Contact,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment
    ) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.patronymic}")
        Text(text = "Фамилия: ${contact.surname}")
        Text(text = "Мобильный телефон: ${contact.phone ?: "---"}")
        Text(text = "Адрес: ${contact.address}")
    }
}

// Image 2: list of contacts, each one on a gray card
@Composable
fun ContactList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        for (contact in contacts) {
            ContactColumn(
                contact = contact,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
        }
    }
}

// Row: contact fields on the left, star on the right
@Composable
fun ContactRow(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactColumn(
            contact = contact,
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        Image(
            painter = painterResource(android.R.drawable.btn_star_big_on),
            contentDescription = "Звезда"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactColumnPreview() {
    ContactColumn(contact = contacts[0])
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    ContactList(contacts = contacts)
}

@Preview(showBackground = true)
@Composable
fun ContactRowPreview() {
    ContactRow(contact = contacts[0])
}
