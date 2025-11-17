package com.example.kotlin_android_prueba

import com.example.kotlin_android_prueba.ApiService
import retrofit2.Retrofit
import retrofit2.create
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val api: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ProfileScreen(api)
            }
        }
    }
}

@Composable
fun ProfileScreen(api: ApiService) {
    var loading by remember { mutableStateOf(true) }
    var profile by remember { mutableStateOf<ProfileResponse?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                loading = true
                profile = api.getProfile()
            } catch (e: Exception) {
                error = e.localizedMessage ?: "Error desconocido"
            } finally {
                loading = false
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        when {
            loading -> {
                CircularProgressIndicator()
                Text("Cargando...", Modifier.padding(top = 8.dp))
            }
            error != null -> {
                Text("Error: $error", color = MaterialTheme.colorScheme.error)
            }
            profile != null -> {
                Text("Usuario: ${profile!!.name}", style = MaterialTheme.typography.headlineSmall)
                Text("Email: ${profile!!.email ?: "—"}", Modifier.padding(top = 8.dp))
            }
            else -> {
                Text("Sin datos")
            }
        }
    }
}

