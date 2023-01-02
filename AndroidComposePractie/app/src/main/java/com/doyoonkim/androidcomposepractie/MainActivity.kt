package com.doyoonkim.androidcomposepractie

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doyoonkim.androidcomposepractie.ui.theme.AndroidComposePractieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePractieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // BirthdayGreetingWithText(msg = "Happy Birthday", from = "Yoon")
                    BirthdayGreetingWithImage( from = "Yoon")
                }
            }
        }
    }

    fun makeToastMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun Greeting(name: String) {
    // Surface is a container that represents a section of UI where
    // you can alter the appearance, such as the background color or border.
    Surface(color = Color.Magenta) {
        // Text(text = "Hello $name!")

        // Modifier is used to augment or decorate a composable.
        Text(text = "Test Modifier", modifier = Modifier.padding(24.dp))

    }
}

// Part of the Android Compose Tutorial - Bday card.
@Composable
fun BirthdayGreetingWithText(msg: String = stringResource(R.string.greeting_message), from: String) {
    // The way Colum/Row/Box function takes arguments is called 'Trailing Lambda'
    // Just like move out last function passed as parameter outside of the argument parentheses, and
    // express it using lambda expression.
    // Originally, it takes parameter 'content', which takes function.
    Column(
        modifier = Modifier
            .padding(
                top = 10.dp,
                bottom = 10.dp
            )
    ) {
        Text(
            text = msg,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(
                    start = 15.dp,
                    end = 15.dp
                )
        )
        Text(
            text = "- from $from",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(
                    start = 15.dp,
                    end = 15.dp
                )
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(msg: String = stringResource(R.string.greeting_message), from: String) {
    // Use image resource on Android Compose.

    // Box Composable
    // Box layout is ont of the standard layout element in Compose,
    // which stacks elements on top of another. (This is default layout applied.)

    Box {
        // Image
        val backgroundImage = painterResource(R.drawable.androidparty)
        Image(
            painter = backgroundImage,
            contentDescription = "Birthday greeting image with cupcake.",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // Greeting Message
        BirthdayGreetingWithText(msg = msg, from = from)
    }
}

// Preview has an attribute called 'showsystemui' that display preview with system ui.
@Preview(name = "Main Preview", showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComposePractieTheme {
        // BirthdayGreetingWithText(msg = "Happy B-day!", from = "Yoon")
        BirthdayGreetingWithImage(from = "Yoon")
    }
}