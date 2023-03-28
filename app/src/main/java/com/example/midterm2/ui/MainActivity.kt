package com.example.midterm2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.midterm2.model.UserItemModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState


class MainActivity : ComponentActivity() {
    private val dataLoaderViewModel: DataLoaderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataLoaderViewModel.loadUsers()

        setContent {
            MyApp {
                Column {
                    TopNavBar()
                    UserList(dataLoaderViewModel)
                }
            }
        }
    }
}

@Composable
fun TopNavBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        elevation = 4.dp,
        color = MaterialTheme.colors.onError
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Users",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3
            )
        }
    }
}

@Composable
fun UserList(dataLoaderViewModel: DataLoaderViewModel) {
    val usersList by dataLoaderViewModel.usersList.observeAsState(emptyList())

    LazyColumn {
        items(usersList) { userItem ->
            UserCard(userItem)
        }
    }
}

@Composable
fun UserCard(user: UserItemModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.LightGray)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "${user.firstName} ${user.lastName}")
            Text(text = user.email, color = Color.Gray)
        }
        Text(text = user.nationality)
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
