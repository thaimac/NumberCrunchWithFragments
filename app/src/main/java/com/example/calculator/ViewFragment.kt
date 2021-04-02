package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import net.objecthunter.exp4j.ExpressionBuilder

class ViewFragment : Fragment() {
    lateinit var input: TextView //keeps track of and displays user input
    lateinit var zero: Button
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var decimal: Button
    lateinit var add: Button
    lateinit var minus: Button
    lateinit var multiply: Button
    lateinit var divide: Button
    lateinit var backspace: Button
    lateinit var clear: Button
    lateinit var equals: Button
    var lastKeyNumeric: Boolean = false //flag to see if last key pressed was a number
    var stateError: Boolean = false
    var lastDot: Boolean = false //flag to see if last key pressed was the decimal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.view_fragment_layout, container, false)
        input = view.findViewById(R.id.textView) as TextView

        zero = view.findViewById(R.id.button0) as Button
        zero.setOnClickListener {
            if (stateError) {
                input.text = "0"
                stateError = false
            } else {
                input.append("0")
            }
            lastKeyNumeric = true
        }

        one = view.findViewById(R.id.button1) as Button
        one.setOnClickListener {
            if (stateError) {
                input.text = "1"
                stateError = false
            } else {
                input.append("1")
            }
            lastKeyNumeric = true
        }

        two = view.findViewById(R.id.button2) as Button
        two.setOnClickListener {
            if (stateError) {
                input.text = "2"
                stateError = false
            } else {
                input.append("2")
            }
            lastKeyNumeric = true
        }

        three = view.findViewById(R.id.button3) as Button
        three.setOnClickListener {
            if (stateError) {
                input.text = "3"
                stateError = false
            } else {
                input.append("3")
            }
            lastKeyNumeric = true
        }

        four = view.findViewById(R.id.button4) as Button
        four.setOnClickListener {
            if (stateError) {
                input.text = "4"
                stateError = false
            } else {
                input.append("4")
            }
            lastKeyNumeric = true
        }

        five = view.findViewById(R.id.button5) as Button
        five.setOnClickListener {
            if (stateError) {
                input.text = "5"
                stateError = false
            } else {
                input.append("5")
            }
            lastKeyNumeric = true
        }

        six = view.findViewById(R.id.button6) as Button
        six.setOnClickListener {
            if (stateError) {
                input.text = "6"
                stateError = false
            } else {
            input.append("6")
        }
            lastKeyNumeric = true
        }

        seven = view.findViewById(R.id.button7) as Button
        seven.setOnClickListener {
            if (stateError) {
                input.text = "7"
                stateError = false
            } else {
                input.append("7")
            }
            lastKeyNumeric = true
        }

        eight = view.findViewById(R.id.button8) as Button
        eight.setOnClickListener {
            if (stateError) {
                input.text = "8"
                stateError = false
            } else {
                input.append("8")
            }
            lastKeyNumeric = true
        }

        nine = view.findViewById(R.id.button9) as Button
        nine.setOnClickListener {
            if (stateError) {
                input.text = "9"
                stateError = false
            } else {
                input.append("9")
            }
            lastKeyNumeric = true
        }

        decimal = view.findViewById(R.id.buttonDot) as Button
        decimal.setOnClickListener {
            if(lastKeyNumeric && !stateError && !lastDot) {
                input.append(".")
                lastKeyNumeric = false
                lastDot = true
            }
        }

        add = view.findViewById(R.id.buttonPlus) as Button
        add.setOnClickListener {
            if(lastKeyNumeric && !stateError) {
                input.append("+")
                lastKeyNumeric = false
                lastDot = false
            }
        }

        minus = view.findViewById(R.id.buttonSubtract) as Button
        minus.setOnClickListener {
            if(lastKeyNumeric && !stateError) {
                input.append("-")
                lastKeyNumeric = false
                lastDot = false
            }
        }

        multiply = view.findViewById(R.id.buttonMultiply) as Button
        multiply.setOnClickListener {
            input.append("*")
        }

        divide = view.findViewById(R.id.buttonDivide) as Button
        divide.setOnClickListener {
            input.append("/")
        }

        backspace = view.findViewById(R.id.bksp) as Button
        backspace.setOnClickListener {
            if(input.length() != 0) {
                this.input.text = input.text.substring(0, input.length() - 1)
            }
        }

        clear = view.findViewById(R.id.clr) as Button
        clear.setOnClickListener {
            this.input.text = ""
        }

        equals = view.findViewById(R.id.buttonequals) as Button
        equals.setOnClickListener {
            val text = input.text.toString()
            val expr = ExpressionBuilder(text).build()
            try {
                val result = expr.evaluate()
                input.text = result.toString()
                lastDot = true
            } catch (ex: ArithmeticException) {
                input.text = "Invalid expression"
                stateError = true
                lastKeyNumeric = false
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
