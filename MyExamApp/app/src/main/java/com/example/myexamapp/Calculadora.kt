package com.example.myexamapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    private lateinit var display: TextView
    private var operando1: Double = 0.0
    private var operando2: Double = 0.0
    private var operador: String? = null
    private var nuevoNumero: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Calcu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        display = findViewById(R.id.zeroDisplay)

        val botonDivision = findViewById<Button>(R.id.Division)
        val botonMultiplicacion = findViewById<Button>(R.id.Multiplicacion)
        val botonResta = findViewById<Button>(R.id.Resta)
        val botonSuma = findViewById<Button>(R.id.Suma)
        val botonIgual = findViewById<Button>(R.id.Igual)
        val botonCero = findViewById<Button>(R.id.button0)
        val botonUno = findViewById<Button>(R.id.button1)
        val botonDos = findViewById<Button>(R.id.button2)
        val botonTres = findViewById<Button>(R.id.button3)
        val botonCuatro = findViewById<Button>(R.id.button4)
        val botonCinco = findViewById<Button>(R.id.button5)
        val botonSeis = findViewById<Button>(R.id.button6)
        val botonSiete = findViewById<Button>(R.id.button7)
        val botonOcho = findViewById<Button>(R.id.button8)
        val botonNueve = findViewById<Button>(R.id.button9)
        val botonInverso = findViewById<Button>(R.id.invButton)

        val botonesNumeros = listOf(
            botonCero, botonUno, botonDos, botonTres, botonCuatro,
            botonCinco, botonSeis, botonSiete, botonOcho, botonNueve
        )

        for (boton in botonesNumeros) {
            boton.setOnClickListener { agregarNumero(boton.text.toString()) }
        }

        botonSuma.setOnClickListener { operacion("+") }
        botonResta.setOnClickListener { operacion("-") }
        botonMultiplicacion.setOnClickListener { operacion("*") }
        botonDivision.setOnClickListener { operacion("/") }
        botonIgual.setOnClickListener { calcularResultado() }
        botonInverso.setOnClickListener { invertirNumero() }
    }

    private fun agregarNumero(numero: String) {
        if (nuevoNumero) {
            display.text = numero
            nuevoNumero = false
        } else {
            display.append(numero)
        }
    }

    private fun operacion(op: String) {
        operando1 = display.text.toString().toDouble()
        operador = op
        nuevoNumero = true
    }

    private fun calcularResultado() {
        operando2 = display.text.toString().toDouble()
        val resultado = when (operador) {
            "+" -> operando1 + operando2
            "-" -> operando1 - operando2
            "*" -> operando1 * operando2
            "/" -> if (operando2 != 0.0) operando1 / operando2 else "Error"
            else -> "Error"
        }
        display.text = resultado.toString()
        nuevoNumero = true
    }

    private fun invertirNumero() {
        val valorActual = display.text.toString()
        val valorInvertido = valorActual.reversed()
        display.text = valorInvertido
    }
}
