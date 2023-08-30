package com.example.appcomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.appcomponentes.ui.theme.AppComponentesTheme
import com.example.appcomponentes.ui.theme.DarkBlueMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppComponentesTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {

        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MenuTopBar()

        }

    }
}



@Preview(showBackground = true, widthDp = 250, heightDp = 530)
@Composable
fun AppPreview() {
    App()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar() {

    Scaffold (

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = DarkBlueMenu
                ),
                title = {
                    Column() {
                        Text(text = "Ovelhas", color = Color.White)
                        Text(text = "Por que sim", color = Color.White , style = MaterialTheme.typography.bodySmall)
                    }
                },
                navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.ArrowBack, tint = Color.White, contentDescription = "")
                    }
                },
                actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.sede), contentDescription = "")
                    }
                }
            )
        }

    ) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(it)){

            ListView()
        }
    }
}

@Preview(showBackground = true, widthDp = 250, heightDp = 400)
@Composable
fun MenuTopBarPreview() {
    MenuTopBar()
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListView() {
    @Composable
    fun ListItem(photoUrl: Painter, title: String, subtitle: String) {
        Surface(
            onClick = { /* TODO */ },
            shape = MaterialTheme.shapes.large,
            color = Color.Black
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = photoUrl,
                    modifier = Modifier
                        .size(58.dp)
                        .clip(CircleShape),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
                Column {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            Modifier
                .widthIn(max = 600.dp)
                .padding(7.dp)) {
            item {
                ListItem(
                    photoUrl = painterResource(id = R.drawable.img1),
                    title = "Asriel",
                    subtitle = "Asriel@gmail.com"
                )
            }
            item {
                ListItem(
                    photoUrl = painterResource(id = R.drawable.img2),
                    title = "Ahlevo",
                    subtitle = "Ahlevo@gmail.com"
                )
            }
            item {
                ListItem(
                    photoUrl = painterResource(id = R.drawable.img3),
                    title = "Shawmn",
                    subtitle = "Shawn@gmail.com"
                )
            }
            item {
                ListItem(
                    photoUrl = painterResource(id = R.drawable.img4),
                    title = "Wooly",
                    subtitle = "Wooly@gmail.com"
                )
            }
            item {
                ListItem(
                    photoUrl = painterResource(id = R.drawable.img5),
                    title = "Bob",
                    subtitle = "Bob@gmail.com"
                )
            }

        }
    }
}