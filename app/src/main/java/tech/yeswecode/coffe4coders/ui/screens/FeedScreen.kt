package tech.yeswecode.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.yeswecode.coffe4coders.ui.components.BodyText
import tech.yeswecode.coffe4coders.ui.components.CountryISO
import tech.yeswecode.coffe4coders.ui.components.ProductCard
import tech.yeswecode.coffe4coders.ui.components.TitleText
import tech.yeswecode.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun FeedScreen(){
    val list = listOf<CountryISO>(
        CountryISO.COL, CountryISO.CRI, CountryISO.NIC, CountryISO.BRA
    )

    Coffe4codersTheme() {
            Surface(
                color = MaterialTheme.colors.background)
            {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    item {
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            TitleText(title = "Bienvenido")
                            BodyText(body = "\n" +
                                    "and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                                    "\n" )
                        }
                    }
                    items(list) { country ->
                        ProductCard(name = "Cafe",
                            sumary = "delicia",
                            price = 35.0 ,
                            currency ="USD",
                            country = country )

                    }
                }
            }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview(){
        FeedScreen()

}