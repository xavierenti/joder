package com.example.hijoputa.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.AlertDialog
import com.example.hijoputa.R

class MainActivity : ComponentActivity() {

    val btChangeScreen by lazy { findViewById<Button>(R.id.bt_change_screen) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        btChangeScreen.setOnClickListener{
            /*
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.setText("Soy un toast muy molon")

            toast.show()
            */

            var builder = AlertDialog.Builder(this)
            builder.setTitle("Puto titulo del dialogo")
            //builder.setMessage("Mensage todavia mas puto del dialogo")
            builder.setPositiveButton("Puto Positivo"){dialoge, witch ->
                dialoge.dismiss()
            }

            builder.setOnCancelListener{
                val toast = Toast(this)
                toast.setText("Puto Cancelado")
                toast.show()
            }

            builder.setNegativeButton("Puto Final"){dialoge, which ->
                dialoge.dismiss()
            }

            builder.setNeutralButton("Puto Neutro"){dialoge, which ->
                dialoge.dismiss()
            }

            val options = arrayOf("Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4")
            val selectedAnswers = booleanArrayOf (false, false, false, false)

            /*builder.setMultiChoiceItems(options, selectedAnswers){dialog, which, isChecked ->
                selectedAnswers[which] = isChecked
            }
*/

            /*val input = EditText(this)
            input.hint = "Escribe puto"
            builder.show(input)
            */

                

            val dialog = builder.create()
            dialog.show()
        }
    }
}
