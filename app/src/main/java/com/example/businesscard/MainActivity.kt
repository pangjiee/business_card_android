package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFE6FFE6)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconInfo(
            icon = painterResource(id = R.drawable.android_logo),
            name = "Jenifer Doe", role = "Android Developer Extraordinaire"
        )
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 55.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(0.6f)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactInfo(
                icon = painterResource(id = R.drawable.android_call),
                message = "+11 (123) 444 555 666"
            )
            ContactInfo(
                icon = painterResource(id = R.drawable.share_68),
                message = "@AndroidDev"
            )
            ContactInfo(
                icon = painterResource(id = R.drawable.email_97),
                message = "jen.doe@android.com"
            )
        }
    }

}


@Composable
private fun IconInfo(icon: Painter, name: String, role: String, modifier: Modifier = Modifier) {
    Image(
        painter = icon, contentDescription = null,
        modifier = modifier
            .background(Color.DarkGray)
            .height(150.dp)
            .width(150.dp)
    )
    Text(
        text = name,
        fontSize = 55.sp,
        fontWeight = FontWeight.ExtraLight
    )
    Text(
        text = role,
        color = Color(0xFF06402B),
        fontWeight = FontWeight.Bold

    )
}


@Composable
private fun ContactInfo(icon: Painter, message: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = icon, contentDescription = null,
            modifier = modifier
                .height(25.dp)
                .width(30.dp),
        )
        Text(
            text = message,
            textAlign = TextAlign.Start,
            modifier = modifier.padding(start = 30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}