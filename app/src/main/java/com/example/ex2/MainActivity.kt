package com.example.ex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ex2.ui.theme.Ex2Theme
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Ex2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        ) {
            FeetToMetresConverter()
        }
    }
}

@Composable
fun FeetToMetresConverter() {
    var feetText by remember { mutableStateOf("") }

    val feetValue = feetText.toDoubleOrNull()
    val metres = (feetValue ?: 0.0) * 0.305

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = feetText,
                onValueChange = { feetText = it },
                label = { Text("Enter feet:") },
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 8.dp)
            )

            Button(
                onClick = { feetText = "" },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (feetValue == null && feetText.isNotEmpty()) {
            Text(
                text = "Please enter a valid number",
                color = Color.Red
            )
        } else {
            Text(
                text = "Metres: $metres",
                fontSize = 20.sp
            )
        }
    }
}
