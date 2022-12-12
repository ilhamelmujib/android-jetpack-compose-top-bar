package id.ilhamelmujib.topbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ilhamelmujib.topbar.ui.theme.TopBarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopBarAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopBarTopBarApp()
                }
            }
        }
    }
}

@Composable
fun TopBarApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Jet Coffee")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Hellow helloww")
        }
    }
}

@Composable
fun TopBarDicodingApp() {
    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primary)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_dicoding),
                    contentDescription = "Logo",
                    modifier = Modifier.height(40.dp)
                )
            }
        }
    ) {

    }
}

@Composable
fun TopBarTopBarApp() {
    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                title = {
                    Text("Top Bar App")
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                    }
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { }) {
                            Text(text = "Call me")
                        }
                    }
                }
            )
        }
    ) {

    }
}

@Preview
@Composable
fun TopBarTopBarAppPreview() {
    TopBarAppTheme {
        TopBarTopBarApp()
    }
}

@Preview
@Composable
fun TopBarDicodingAppPreview() {
    TopBarAppTheme {
        TopBarDicodingApp()
    }
}

@Preview
@Composable
fun TopBarAppPreview() {
    TopBarAppTheme {
        TopBarApp()
    }
}