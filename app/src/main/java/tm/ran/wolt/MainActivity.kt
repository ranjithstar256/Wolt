package tm.ran.wolt

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CustomScaffold()

            //ScaffoldExample()
            //CombinedScreen()

            /* Column(Modifier.fillMaxSize()) {

                 var name by remember { mutableStateOf("") }

                 TextField(value = name,
                     onValueChange = { name = it },
                     label = { Text("Name") },
                     placeholder = { Text("Enter your name") })

                 Button(
                     onClick = {
                         Toast.makeText(this@MainActivity,
                             "Hello $name", Toast.LENGTH_SHORT).show()
                     },
                     enabled = name.isNotEmpty()
                 ) {
                     Text("Simple Button")
                 }
                 Text(name)
             }
 */


        }
    }

    @Composable
    fun SimpleUI() {
        // Remember a mutable state variable to update text on button click
        val message = remember { mutableStateOf("Hello, Jetpack Compose!") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message.value,
                fontSize = 24.sp
            )
            Button(onClick = {
                message.value = "You clicked the button!"
            }) {
                Text(text = "Click Me")
            }
        }
    }


    @Composable
    fun ProfileScreen() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "John Doe",
                fontSize = 32.sp
            )
            Text(
                text = "Android Developer",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { /* Placeholder action */ }) {
                    Text(text = "Follow")
                }
                Button(onClick = { /* Placeholder action */ }) {
                    Text(text = "Message")
                }
            }
        }
    }


    @Composable
    fun ModifierExample() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Composable Card",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "This card uses padding, fillMaxWidth, and a shadow effect for elevation."
                )
            }
        }
    }

    @Composable
    fun CombinedScreen() {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(40.dp)
        ) {
            SimpleUI()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileScreen()
            Spacer(modifier = Modifier.height(16.dp))
            ModifierExample()
            Spacer(modifier = Modifier.height(16.dp))

        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldExample() {
        Scaffold(

            floatingActionButton = {
                FloatingActionButton(onClick = {
                Toast.makeText(this@MainActivity,
                    "Floating Action Button", Toast.LENGTH_SHORT).show()

                 }) {
                    Text("+")
                }
            },
            content = {
                padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text("Welcome to Jetpack Compose!", fontSize = 24.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { /* Add action */ }) {
                        Text("Click Me")
                    }
                }
            },

        )
    }








    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun MainContent(padding: PaddingValues) {

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(padding)
                     ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
             /* *//*  Image(
                    painterResource(id = android.R.drawable.btn_plus),
                    contentDescription =
                    "instagram logo",
                    modifier = Modifier.size(width = 220.dp, height = 100.dp)
                )*/
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Kotlin: Because torturing yourself with Java just wasn't enough.",
                    color = Color.Blue,
                    fontFamily =
                    FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))

                Spacer(modifier = Modifier.height(40.dp))


            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomScaffold() {
        val datePicker = TimePickerDialog(
            LocalContext.current
            ,null, 2022, 0, true
        )
        Scaffold(

            topBar = { CustomTopBar() },
            content = { h -> MainContent(h)},
            bottomBar = { CustomBottomBar()},
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        datePicker.show()
                    }
                ) {
                    Icon(Icons.Filled.Add,"")
                }
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomBottomBar() {
        remember { mutableStateOf(0) }
        BottomAppBar(
            modifier = Modifier.drawBehind {
                drawLine(
                    Color.LightGray,
                    Offset(0f, 0f),
                    Offset(size.width, 0f),
                    4f
                )
            },
            containerColor = Color.White,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment =
                Alignment.CenterVertically
            ) {

                var showList = remember {
                    mutableStateOf("")
                }
                Icon(imageVector = Icons.Default.Home, "", modifier = Modifier.size(30.dp))
                Icon(imageVector = Icons.Default.Favorite, "", modifier = Modifier.size(30.dp))
                Icon(imageVector = Icons.Default.Person, "", modifier = Modifier.size(30.dp))
                Text(text = "Hi")
            }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomTopBar() {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
                    Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            end = 50
                                .dp
                        )
                ) {
                    Icon(
                        Icons.Filled.AccountBox, contentDescription = "", modifier = Modifier
                            .size(30.dp)
                    )
                    Image(
                        painterResource(id = android.R.drawable.star_big_on),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )


                }
            },
            modifier = Modifier.drawBehind {
                drawLine(
                    Color.Green,
                    Offset(0f, size.height),
                    Offset(size.width, size.height),
                    5f
                )
            }
        )
    }
}






