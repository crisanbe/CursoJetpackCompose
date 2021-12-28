package tech.yeswecode.coffe4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import tech.yeswecode.coffe4coders.ui.components.DropdownTexField
import tech.yeswecode.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun CheckoutScreen() {
    val cities = listOf(
        "Ciudad de Mexico, Mexico",
        "la habana,Cuba",
        "Cancun, Mexico",
        "Medellin, COlombia",
        "Buenos aires, Argentina",
        "Sau paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Ciudad panama, Panama"
    )

    var city by remember { mutableStateOf("") }

    DropdownTexField(
        suggestions = cities, value = city, placeholder = "Ciudad") {
        city = it
    }
}


@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    //Coffe4codersTheme{
        CheckoutScreen()
    //}
}