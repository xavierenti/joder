package com.example.apuntesclase

import android.content.Context
import android.graphics.Path.Op
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.hijoputa.R

class MainActivity : ComponentActivity() {

    enum class Operations(val operation: (Int, Int) -> Int) {
        Add({a, b -> a + b}),
        Subtract({a, b, -> a - b}),
        Multiply({a, b, -> a * b}),
        Divide({a, b, -> a / b});

        public fun Operate(a: Int, b: Int) : Int {
            return this.operation(a,b)
        }
    }

    class ButtonsRow(var linearLayout : LinearLayout, val contenxt: Context) {
        var buttons : MutableList<Button> = mutableListOf()

        fun AddButtonToRow(text : String) : Button {
            var bt = Button(contenxt)
            bt.text = text
            bt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1.0f
            )
            linearLayout.addView(bt)
            buttons.add(bt)

            return bt
        }
    }

    class ButtonsGrid(var parent: LinearLayout, val contenxt : Context) {
        // Necesita su Layout y el número de líneas que va a tener la GRID
        val baseLinearLayout : LinearLayout
        private var rows : MutableList<ButtonsRow> = mutableListOf()

        init {
            // Generamos el LinearLayout y lo asignamos a la vista padre
            baseLinearLayout = LinearLayout(contenxt)
            baseLinearLayout.orientation = LinearLayout.VERTICAL
            parent.addView(baseLinearLayout)
        }

        fun AddNewRow() {
            val linearLayout = LinearLayout(contenxt)
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1.0f
            )
            baseLinearLayout.addView(linearLayout)
            rows.add(ButtonsRow(linearLayout, contenxt))
        }

        fun GetRow(index : Int) : ButtonsRow? {
            if (index >= rows.count() || index < 0) {
                return null
            }

            return rows[index]
        }
    }

    val result : TextView by lazy { findViewById(R.id.result) }
    val buttonsContainer : LinearLayout by lazy { findViewById(R.id.buttons_container) }

    var numB : Int = 0;
    var numA : Int = 0;
    var operation : Operations? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val btGrid = ButtonsGrid(buttonsContainer, this)

        var names : MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "()", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "X"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ".", "<->", "="))

        for (y in names.indices) {
            btGrid.AddNewRow()
            var row : ButtonsRow? = btGrid.GetRow(y)
            for (x in names[y].indices) {
                row?.AddButtonToRow(names[y][x])?.setOnClickListener {
                    when (names[y][x]) {
                        "1" -> {

                            if (operation == null) {
                                numA = numA * 10 + 1
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 1
                                result.text = numB.toString()
                            }
                        }
                        "2" -> {
                            if (operation == null) {
                                numA = numA * 10 + 2
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 2
                                result.text = numB.toString()
                            }
                        }
                        "3" -> {
                            if (operation == null) {
                                numA = numA * 10 + 3
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 3
                                result.text = numB.toString()
                            }
                        }
                        "4" -> {
                            if (operation == null) {
                                numA = numA * 10 + 4
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 4
                                result.text = numB.toString()
                            }
                        }
                        "5" -> {
                            if (operation == null) {
                                numA = numA * 10 + 5
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 5
                                result.text = numB.toString()
                            }
                        }
                        "6" -> {
                            if (operation == null) {
                                numA = numA * 10 + 6
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 6
                                result.text = numB.toString()
                            }
                        }
                        "7" -> {
                            if (operation == null) {
                                numA = numA * 10 + 7
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 7
                                result.text = numB.toString()
                            }
                        }
                        "8" -> {
                            if (operation == null) {
                                numA = numA * 10 + 8
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 8
                                result.text = numB.toString()
                            }
                        }
                        "9" -> {
                            if (operation == null) {
                                numA = numA * 10 + 9
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB * 10 + 9
                                result.text = numB.toString()
                            }
                        }
                        "+" -> {
                            operation = Operations.Add

                            if (numB != 0) {
                                result.text = operation?.Operate(numA,numB).toString()
                                numA = operation?.Operate(numA, numB)!!
                                numB = 0
                            }
                        }
                        "-" -> {
                            operation = Operations.Subtract
                            if (numB != 0) {
                                result.text = operation?.Operate(numA,numB).toString()
                                numA = operation?.Operate(numA, numB)!!
                                numB = 0
                            }
                        }
                        "X" -> {
                            operation = Operations.Multiply
                            if (numB != 0) {
                                result.text = operation?.Operate(numA,numB).toString()
                                numA = operation?.Operate(numA, numB)!!
                                numB = 0
                            }
                        }
                        "/" -> {
                            operation = Operations.Divide
                            if (numB != 0) {
                                result.text = operation?.Operate(numA,numB).toString()
                                numA = operation?.Operate(numA, numB)!!
                                numB = 0
                            }
                        }
                        "=" -> {
                            result.text = operation?.Operate(numA,numB).toString()
                            numA = 0
                            numB = 0
                            operation = null
                        }
                        "<->" -> {
                            if (operation == null) {
                                numA = numA / 10
                                result.text = numA.toString()
                            }
                            else {
                                numB = numB / 10
                                result.text = numB.toString()
                            }
                        }
                        "AC" -> {
                            numA = 0
                            numB = 0
                            operation = null

                            result.text = "0"
                        }

                        else -> result.text = names[y][x]
                    }
                }
            }
        }
    }
}
