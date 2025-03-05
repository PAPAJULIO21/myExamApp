package com.example.myexamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botonCalculadora = findViewById<Button>(R.id.calculadora)
        botonCalculadora.setOnClickListener {
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }

        val montanas = findViewById<Button>(R.id.misMontanas)
        montanas.setOnClickListener {
            val intent = Intent(this, MisMontanas::class.java)
            startActivity(intent)
        }
    }
}