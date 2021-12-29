package tech.yeswecode.coffe4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffe4coders.ui.components.*
import tech.yeswecode.coffe4coders.ui.theme.Coffe4codersTheme
import java.lang.reflect.Modifier

@Composable
fun CheckoutScreen(navController: NavController, country: CountryISO) {
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

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    Scaffold(topBar = {
        CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            navController.navigate("detail/${country.iso}")
        }
    }, content = {
        Column(
            modifier = androidx.compose.ui.Modifier.verticalScroll(rememberScrollState())
        ) {
            ProductCard(
                name = "Cafe de Colombia",
                sumary = "Cafe de las montañas",
                price = 35.0,
                currency = "USD",
                country = country
            ) {}
            Column(
                modifier = androidx.compose.ui.Modifier.padding(16.dp)
            ) {
                CustomTextField(value = name, placeholder = "Nombre completo") {
                    name = it
                }
                CustomTextField(value = email, placeholder = "Correo Electrónico") {
                    email = it
                }
                CustomTextField(value = phone, placeholder = "Numero Telefonico") {
                    phone = it
                }
                CustomTextField(value = address, placeholder = "Direccion") {
                    address = it
                }
                DropdownTexField(
                    suggestions = cities, value = city, placeholder = "Ciudad"
                ) {
                    city = it
                }

                Column {
                    Row {
                        Text("Subtotal", style = MaterialTheme.typography.caption)
                        Text(
                            "35.0 USD",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = androidx.compose.ui.Modifier.fillMaxWidth())
                    }
                    Row {
                        Text("Envio", style = MaterialTheme.typography.caption)
                        Text("10.0 USD", style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = androidx.compose.ui.Modifier.fillMaxWidth())
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text("$ 45.0 USD",
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Start
                    )
                    CustomButton(label = "Finalizar pedido") {

                    }
                }
            }
        }
    })
}


@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    Coffe4codersTheme {
        CheckoutScreen(navController, CountryISO.COL)
    }
}