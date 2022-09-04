package com.example.composetutorial.components

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import com.example.composetutorial.data.Message
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Preview(name = "Light Mode", showBackground = true)
@Preview(
  showBackground = true,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
  name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
  ComposeTutorialTheme {
    Surface {
      MessageCard(message = Message("Vighnesh",
                                    "Hey. Take a look at JetpackCompose, it's great. It is similar to react"))
    }
  }
}

@Composable
fun MessageCard(message: Message) {
  Row(modifier = Modifier.padding(all = 8.dp)) {
    Image(
      painter = painterResource(id = R.drawable.profile_pic),
      contentDescription = stringResource(R.string.contact_profile_picture),
      modifier = Modifier
        .size(40.dp)
        .clip(CircleShape)
        .border(width = 1.5.dp, color = MaterialTheme.colors.secondary, shape = CircleShape)
    )
    Spacer(modifier = Modifier.width(8.dp))

    // var isExpanded by remember { mutableStateOf(false) }
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
      targetValue = if (isExpanded)
        MaterialTheme.colors.primary
      else
        MaterialTheme.colors.surface
    )

    Column {
      Text(
        text = message.author,
        color = MaterialTheme.colors.secondaryVariant,
        style = MaterialTheme.typography.subtitle2
      )
      Spacer(modifier = Modifier.height(8.dp))
      Row(horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically) {
        Surface(
          shape = MaterialTheme.shapes.medium,
          elevation = 1.dp,
          color = surfaceColor,
          modifier = Modifier
            .animateContentSize()
            .padding(1.dp)
        ) {
          Text(
            text = message.body,
            modifier = Modifier.padding(all = 4.dp),
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            style = MaterialTheme.typography.body2
          )
        }
        IconButton(onClick = { isExpanded = !isExpanded }) {
          Icon(
            imageVector = if (isExpanded)
              Icons.Filled.ExpandLess
            else
              Icons.Filled.ExpandMore,
            contentDescription = if (isExpanded)
              stringResource(R.string.see_less)
            else
              stringResource(R.string.see_more)
          )
        }
      }
    }
  }
}
