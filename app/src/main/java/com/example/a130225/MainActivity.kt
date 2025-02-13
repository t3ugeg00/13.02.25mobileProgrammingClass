package com.example.a130225

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a130225.ui.theme._130225Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _130225Theme {
                Scaffold(
                    topBar = {
                        var expanded by remember { mutableStateOf(false) }

                        TopAppBar (
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("M-app")
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = {}
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "Menu"
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = {
                                        expanded = !expanded
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.MoreVert,
                                        contentDescription = "More"
                                    )
                                }
                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false }
                                ) {
                                    DropdownMenuItem(
                                        text = { Text("Info") },
                                        onClick = { expanded = false }
                                    )
                                    DropdownMenuItem(
                                        text = { Text("Settings") },
                                        onClick = { expanded = false }
                                    )
                                }
                            }
                        )
                    }
                ) {
                    innerPadding ->
                    Counter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Counter(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableIntStateOf(0) }

    Button (
        onClick = {counter++},
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Count $counter")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _130225Theme {
        Counter()
    }
}