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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dcac.learntogether.ui.theme.LearnTogetherTheme

class TaskActivity : ComponentActivity() {
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
                            val intent = Intent(context, QuadrantActivity::class.java)
                            context.startActivity(intent)
                        }
                ) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        TaskPage(
                            title = stringResource(R.string.all_tasks_completed),
                            body = stringResource(R.string.nice_work),
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun TaskPage(title: String, body: String, modifier: Modifier = Modifier) {
    Column(modifier=modifier, verticalArrangement = Arrangement.Center, horizontalAlignment= Alignment.CenterHorizontally) {
        val taskImage= painterResource(R.drawable.ic_task_completed)
        Image(painter = taskImage, contentDescription = null)
        TaskText(title, body)
    }
}

@Composable
fun TaskText(title: String, body: String, modifier: Modifier = Modifier) {
    Column (modifier=modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = Bold,
            modifier=modifier.padding(top = 24.dp, bottom = 8.dp))
        Text(
            text=body,
            fontSize = 16.sp)
    }
}




@Preview(showBackground = true)
@Composable
fun TaskActivityPreview() {
    LearnTogetherTheme {
        TaskPage(title = stringResource(R.string.all_tasks_completed), body = stringResource(R.string.nice_work))

    }
}
