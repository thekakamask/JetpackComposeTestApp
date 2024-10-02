package com.dcac.learntogether


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcac.learntogether.ui.theme.LearnTogetherTheme
import com.dcac.learntogether.ui.theme.QuadrantActivityColumnBackgroundColor
import com.dcac.learntogether.ui.theme.QuadrantActivityImageBackgroundColor
import com.dcac.learntogether.ui.theme.QuadrantActivityRowBackgroundColor
import com.dcac.learntogether.ui.theme.QuadrantActivityTextBackgroundColor

class QuadrantActivity : ComponentActivity() {
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
                            val intent = Intent(context, BirthdayActivity::class.java)
                            context.startActivity(intent)
                        }
                ) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        QuadrantComposable()

                    }

                }
            }
        }
    }
}

@Composable
fun QuadrantComposable(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableElement(
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.displays_text_and),
                backgroundColor = QuadrantActivityTextBackgroundColor,
                modifier = Modifier.weight(1f)
            )
            ComposableElement(
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.a_layout_composable_that),
                backgroundColor = QuadrantActivityImageBackgroundColor,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableElement(
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.a_layout_composable_that_2),
                backgroundColor = QuadrantActivityRowBackgroundColor,
                modifier = Modifier.weight(1f)
            )
            ComposableElement(
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.creates_a_composable_that),
                backgroundColor = QuadrantActivityColumnBackgroundColor,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
private fun ComposableElement(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}




@Preview(showBackground = true)
@Composable
fun QuadrantActivityPreview() {
    LearnTogetherTheme {
        QuadrantComposable(
        )
    }
}