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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dcac.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                val context= LocalContext.current
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            val intent = Intent(context, TaskActivity::class.java)
                            context.startActivity(intent)
                        }
                ) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        FirstPage(
                            title = stringResource(R.string.first_page_title),
                            intro = "Jetpack Compose is a modern toolkit for building native Android UI. Compose" +
                                    " Simplifies and accelerates UI development on Android with less code," +
                                    " powerful tools, and intuitive Kotlin APIs.",
                            body = "In this tutorial, you build a simple UI component with declarative functions." +
                                    " You call Compose functions to say what elements you want and the Compose compiler" +
                                    " does the rest. Compose is built around Composable functions. These functions let" +
                                    " you describe how it should look and provide data dependancies, rather than focus" +
                                    " on the process of the UI's construction, such as initializing an element and then" +
                                    " attaching it to a parent. To create a Composable function, you add the @Composable" +
                                    "annotation to the function name.",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun FirstPage(title: String, intro: String, body: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center, modifier=modifier) {
        TopImage()
        TextPage(title, intro, body)
    }
}

@Composable
fun TopImage() {
    val image= painterResource(R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null)
}

@Composable
fun TextPage(title: String, intro: String, body: String, modifier: Modifier = Modifier){
    Column (modifier=modifier) {
        TitleText(title)
        ParagraphText(intro, body)
    }
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ParagraphText(intro: String, body: String, modifier: Modifier = Modifier) {
    Column (modifier=modifier) {
        Text(
            text = intro,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = body,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun FirstPagePreview() {
    LearnTogetherTheme {
        FirstPage(
            title = "Jetpack Compose Tutorial",
            intro = "Jetpack Compose is a modern toolkit for building native Android UI. Compose" +
                    " Simplifies and accelerates UI development on Android with less code," +
                    " powerful tools, and intuitive Kotlin APIs.",
            body = "In this tutorial, you build a simple UI component with declarative functions." +
                    " You call Compose functions to say what elements you want and the Compose compiler" +
                    " does the rest. Compose is built around Composable functions. These functions let" +
                    " you describe how it should look and provide data dependancies, rather than focus" +
                    " on the process of the UI's construction, such as initializing an element and then" +
                    " attaching it to a parent. To create a Composable function, you add the @Composable" +
                    "annotation to the function name."
        )
    }
}

