package com.doyoonkim.androidcomposepractice_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doyoonkim.androidcomposepractice_01.ui.theme.AndroidComposePractice01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePractice01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        Image(
                            painter = painterResource(R.drawable.bg_compose_background),
                            contentDescription = "Banner Image",
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        HeadingText(value = "Jetpack Compose Tutorial")
                        BodyText(value = stringResource(R.string.article_paragraph_1))
                        BodyText(value = stringResource(R.string.article_paragraph_2))
                    }
                }
            }
        }
    }
}

@Composable
fun HeadingText(value: String) {
    Text(
        text = value,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(
                top = 15.dp,
                bottom = 15.dp,
                start = 10.dp,
                end = 10.dp
            )
    )
}

@Composable
fun BodyText(value: String) {
    Text(
        text = value,
        textAlign = TextAlign.Justify,
        fontSize = 11.sp,
        modifier = Modifier
            .padding(
                top = 5.dp,
                bottom = 5.dp,
                start = 10.dp,
                end = 10.dp
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComposePractice01Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column() {
                Image(
                    painter = painterResource(R.drawable.bg_compose_background),
                    contentDescription = "Banner Image",
                    modifier = Modifier
                        .fillMaxWidth()
                )
                HeadingText(value = "Jetpack Compose Tutorial")
                BodyText(value = stringResource(R.string.article_paragraph_1))
                BodyText(value = stringResource(R.string.article_paragraph_2))
            }
        }
    }
}