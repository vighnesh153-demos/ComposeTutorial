package com.example.composetutorial.components

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.composetutorial.data.Message
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.sample.SampleMessages
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun Conversation(messages: List<Message>) {
  Surface {
    LazyColumn {
      items(messages) { message ->
        MessageCard(message = message)
      }
    }
  }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
  showBackground = true,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
  name = "Dark Mode"
)
@Composable
fun PreviewConversation() {
  ComposeTutorialTheme {
    Conversation(messages = SampleMessages.conversationSample)
  }
}
