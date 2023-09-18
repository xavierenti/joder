package com.example.hijoputa

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hijoputa.ui.theme.HijoputaTheme

class MainActivity : ComponentActivity() {

    enum class  Colors(val text: String, val number:Int, val color: Color){
        Red("Rojo", 0, Color(255,0,0)),
        Green("Green", 1, Color(0,255,0)),
        Blue("Blue", 2, Color(0,0,255));

        fun WithAlpha(alpha:Float): Color{
            return this.color.copy(alpha)
        }
    }

    enum class Operations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HijoputaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Column(){
                        /*
                        Greeting("Android")
                        Greeting("Jodete")
                        for(i in 1..10){Greeting("joputa")}

                        Spacer(modifier = Modifier.height(16.dp))

                        val names = listOf("conyo", "quantos", "nombres")

                        for(name in names){
                            Greeting(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        for(i in names.indices){
                            Greeting(name= "indice: " + i.toString())
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        
                        names.forEach{name -> 
                            Greeting(name = name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        
                        names.forEachIndexed { index, name ->  
                            Greeting(name = name + ", indice: " + index.toString())
                        }
                        */
                        Greeting(name = "Puto Color", color = Colors.Red)
                        
                        
                        
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,color:MainActivity.Colors, modifier: Modifier = Modifier) {

    Text(
        text = "Hello ${name.uppercase()}",
        modifier = modifier,
        color = color.WithAlpha(1.0f)
    )

}
/*
fun Greeting(name: String?, name2: String?,modifier: Modifier = Modifier) {

    /*
    val name = name?.let{
        val name2 = name2?.let{
            Text(
                text = "Hello ${name.uppercase()}!",
                modifier = modifier
            )
        }
    }?: run {
        Text(
            text = "Hello es null!",
            modifier = modifier
        )
    }
    */

    val name = name ?: run {
        Log.e("Null","name is null")
        return
    }
    val name2 = name2 ?: run {
        Log.e("Null","name2 is null")
        return
    }
    Text(
        text = "Hello ${name.uppercase()}",
        modifier = modifier
    )

}
*/
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HijoputaTheme {

    }
}