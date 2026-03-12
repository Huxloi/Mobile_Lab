package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                WoofApp()
            }
        }
    }
}

@Composable
fun WoofApp() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        WoofHeader()

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(DataSource.dogs) { dog ->
                DogItem(dog)
            }

        }

    }
}

@Composable
fun WoofHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(R.drawable.ic_woof_logo),
            contentDescription = "Woof logo",
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Woof",
            style = MaterialTheme.typography.displayLarge
        )

    }

}

@Composable
fun DogItem(dog: Dog) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column {

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(dog.imageResourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                    )

                    Column(
                        modifier = Modifier.padding(start = 16.dp)
                    ) {

                        Text(
                            text = stringResource(dog.name),
                            style = MaterialTheme.typography.displayMedium
                        )

                        Text(
                            text = stringResource(R.string.years_old, dog.age),
                            style = MaterialTheme.typography.bodyLarge
                        )

                    }

                }

                IconButton(
                    onClick = { expanded = !expanded }
                ) {

                    Icon(
                        imageVector =
                            if (expanded)
                                Icons.Filled.KeyboardArrowUp
                            else
                                Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )

                }

            }

            if (expanded) {

                Column(
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                ) {

                    Text(
                        text = "About",
                        style = MaterialTheme.typography.labelSmall
                    )

                    Text(
                        text = "Stealing socks",
                        style = MaterialTheme.typography.bodyLarge
                    )

                }

            }

        }

    }

}