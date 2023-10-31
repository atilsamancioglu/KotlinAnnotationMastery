package com.atilsamancioglu.annotationmastery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.atilsamancioglu.annotationmastery.model.Student
import com.atilsamancioglu.annotationmastery.service.FantasticAPI
import com.atilsamancioglu.annotationmastery.ui.theme.AnnotationMasteryTheme
import com.atilsamancioglu.annotationmastery.util.AuthenticationInterceptor
import com.atilsamancioglu.annotationmastery.util.Constants
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val api by  lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient
                .Builder()
                .addInterceptor(AuthenticationInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build()
            ).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FantasticAPI::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnnotationMasteryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        val student = Student(name="atil", surname = "sam" ,email = "atilsamancioglu@gmail.com")
        println(student.email)

        lifecycleScope.launch {
            api.getJokes()
            api.getCryptos()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnnotationMasteryTheme {
        Greeting("Android")
    }
}