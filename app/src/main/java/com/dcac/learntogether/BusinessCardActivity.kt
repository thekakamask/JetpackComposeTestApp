package com.dcac.learntogether

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dcac.learntogether.ui.theme.LearnTogetherTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                // A surface container using the "background" color from the theme
                val context= LocalContext.current
                Scaffold(modifier =  Modifier
                    .fillMaxSize()
                    .clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    }
                )  { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        BusinessCard()

                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()){
        BusinessTitle(name = "Jennifer Doe", title = "Android Developer Extraordinaire")
        BusinessContact()
    }
}

@Composable
fun BusinessTitle(name: String, title: String, modifier: Modifier = Modifier) {
    Column(modifier=modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val image = painterResource(R.drawable.android_logo)
        Image(painter = image, contentDescription = null, modifier = modifier.padding(8.dp))
        Text(text = name,
            fontSize = 40.sp,
            textAlign = TextAlign.Center)
        Text(text = title,
            fontSize = 18.sp,
            fontWeight = Bold,
            modifier = modifier.padding(8.dp))

    }
}

@Composable
fun BusinessContact(){
    Column(verticalArrangement = Arrangement.Center,modifier = Modifier
        .padding(8.dp)){
        BusinessData("+33666666666",
            painterResource(R.drawable.phone_icon))
        BusinessData("@InternetSite.com",
            painterResource(R.drawable.link_icon))
        BusinessData("mognet@hotmail.com",
            painterResource(R.drawable.mail_icon))

    }
}

@Composable
fun BusinessData (dataInfo:String,
                  dataIcon: Painter,
                  modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = dataIcon,
            contentDescription = null)
        Text(text = dataInfo,
            fontSize = 15.sp,
            modifier=modifier.padding(start=20.dp) )
    }
}



@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    LearnTogetherTheme {
        BusinessCard()
    }
}