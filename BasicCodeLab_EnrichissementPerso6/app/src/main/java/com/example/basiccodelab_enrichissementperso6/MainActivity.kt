package com.example.basiccodelab_enrichissementperso6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiccodelab_enrichissementperso6.ui.theme.BasicCodeLab_EnrichissementPerso6Theme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodeLab_EnrichissementPerso6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayPlaylist("Android")
                }
            }
        }
    }
}

@Composable
fun DisplayPlaylist(name: String, modifier: Modifier = Modifier.fillMaxWidth()) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)){
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Playlist ", color = Color.Gray,)
                Text(text = name, modifier=modifier, textAlign = TextAlign.Center)
                if (expanded.value) {
                    Text(text= "nb of titles, total listing time", color = Color.Gray,)
                }
            }
            ElevatedButton(
                onClick = {
                    expanded.value = !expanded.value
                          }, modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(if (expanded.value) "Currently listening" else "Listen")
            }
        }
    }
}
@Composable
fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf("Chill with Clément", "Road trip with Etienne Clément and Emilie", "Party with Emilie")) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier=modifier.padding(4.dp)) {
            for (name in names) {
                DisplayPlaylist(name = name)
            }
        }
    }
}



@Preview(showBackground = true, widthDp = 320)
@Composable
fun DisplayPlaylistPreview() {
    BasicCodeLab_EnrichissementPerso6Theme {
        MyApp()
    }
}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to TunaJam!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { shouldShowOnboarding = false }
        ) {
            Text("My Playlists")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicCodeLab_EnrichissementPerso6Theme {
        OnboardingScreen()
    }
}