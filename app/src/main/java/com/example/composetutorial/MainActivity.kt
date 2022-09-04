package com.example.composetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.components.Conversation
import com.example.composetutorial.sample.SampleMessages
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.setContent { MyApp() }
  }
}

@Composable
fun MyApp() {
  ComposeTutorialTheme {
    Conversation(messages = SampleMessages.conversationSample)
  }
}

@Preview(
  name = "Light Mode",
  widthDp = 400
)
@Preview(
  uiMode = UI_MODE_NIGHT_YES,
  name = "Dark Mode",
  widthDp = 400
)
@Composable
fun PreviewMyApp() {
  MyApp()
}
