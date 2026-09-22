package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContent{Calculator2()};
    }
}
@Composable
fun Calculator2()
{
    var display by remember{mutableStateOf("")};
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Bottom)
    {
        Text(text = display, fontSize = 40.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        Row(modifier = Modifier.fillMaxWidth())
        {
            CalculatorButton2("7"){display+= "7"}
            CalculatorButton2("8"){display+= "8"}
            CalculatorButton2("9"){display+= "9"}
            CalculatorButton2("/"){display+= "/"}
        }
        Row(modifier = Modifier.fillMaxWidth())
        {
            CalculatorButton2("4"){display+= "4"}
            CalculatorButton2("5"){display+= "5"}
            CalculatorButton2("6"){display+= "6"}
            CalculatorButton2("*"){display+= "*"}
        }
        Row(modifier = Modifier.fillMaxWidth())
        {
            CalculatorButton2("1"){display+= "1"}
            CalculatorButton2("2"){display+= "2"}
            CalculatorButton2("3"){display+= "3"}
            CalculatorButton2("-"){display+= "-"}
        }
        Row(modifier = Modifier.fillMaxWidth())
        {
            CalculatorButton2("0"){display+= "0"}
            CalculatorButton2("."){display+= "."}
            CalculatorButton2("="){display = calculate2(display)}
            CalculatorButton2("+"){display+= "+"}
        }
        Row(modifier = Modifier.fillMaxWidth())
        {
            CalculatorButton2("C"){display = ""}
        }
    }
}

@Composable
fun CalculatorButton2(text : String, onClick : () -> Unit)
{
    Button(onClick = onClick, modifier = Modifier
        .weight(1f)
        .padding(4.dp))
    {
        Text(text = text, fontSize = 24.sp)
    }
}

fun calculate2(expression : String) : String
{
    return try
    {
        var parts = expression.split("+", "-", "*", "/")
        if(parts.size() != 2)
        {
            return "ERROR"
        }
        val v1 = parts[0].toDouble()
        val v2 = parts[1].toDouble()
        when
        {
            expression.contains("+") -> (v1 + v2).toString()
            expression.contains("-") -> (v1 - v2).toString()
            expression.contains("*") -> (v1 * v2).toString()
            expression.contains("/") ->
            {
                if(v2 == 0.0)
                "ERROR";
                (v1 / v2).toString();
            }
            else -> "ERROR"
        }
    }
    catch(e : Exception)
    {
        "ERROR"
    }
}
