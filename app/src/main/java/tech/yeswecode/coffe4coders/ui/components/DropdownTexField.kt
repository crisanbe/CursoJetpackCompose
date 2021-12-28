package tech.yeswecode.coffe4coders.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize

@Composable
fun DropdownTexField(
    suggestions: List<String>,
    value: String,
    placeholder: String,
    onChangeValue: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown

    Column() {
        CustomTextField(value = value,
            placeholder = placeholder,
            onValueChange = onChangeValue,
            enabled = false,
            trailingIcon = {
                Icon(icon, contentDescription = null,
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    })
            },
            onGloballyPositioned = { coordinates ->
                textfieldSize = coordinates.size.toSize()
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current){
                textfieldSize.width.toDp()
            })
        ) {
            suggestions.forEach{label ->
                DropdownMenuItem(onClick = {
                    onChangeValue(label)
                }) {
                    Text(label, style = MaterialTheme.typography.body2)

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownTexFieldPreview() {
    val cities = listOf(
        "Ciudad de Mexico, Mexico",
        "la habana,Cuba",
        "Cancun, Mexico",
        "Medellin, COlombia",
        "Buenos aires, Argentina",
        "Sau paulo, Brasil"
    )
    DropdownTexField(cities, "","Ciudades"){}
}