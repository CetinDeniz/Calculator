package personal.axuca.basiccalculator

import android.widget.Button
import personal.axuca.basiccalculator.databinding.ActivityMainBinding

fun ActivityMainBinding.setButtonsClickListeners() {

    fun Button.setOnClickListener() {
        this.setOnClickListener {
            if (textInput.text == "0") {
                textInput.text = this.text
            } else {
                textInput.text = "${textInput.text}${this.text}"
            }
        }
    }

    button0.setOnClickListener {
        if (textInput.text == "0") return@setOnClickListener
        textInput.text = "${textInput.text}${button0.text}"
    }
    button1.setOnClickListener()
    button2.setOnClickListener()
    button3.setOnClickListener()
    button4.setOnClickListener()
    button5.setOnClickListener()
    button6.setOnClickListener()
    button7.setOnClickListener()
    button8.setOnClickListener()
    button9.setOnClickListener()

    buttonClear.setOnClickListener {
        textInput.text = "0"
        textOutput.text = ""
    }

    buttonBackspace.setOnClickListener {
        if (textInput.text.length == 1) {
            textInput.text = "0"
            return@setOnClickListener
        }
        textInput.text = textInput.text.dropLast(1)
    }

    buttonEqual.setOnClickListener {
        textOutput.text = "=${calculateResult(textInput.text)}"
    }

    buttonAddition.setOnClickListener {
        if (textInput.text.last() == '+') return@setOnClickListener
        else textInput.text = "${textInput.text}+"
    }

}

fun calculateResult(text: CharSequence): String {
    return text.split("+").filterNot { it == "+" || it == "" }.sumOf {
        it.toLong()
    }.toString()
}