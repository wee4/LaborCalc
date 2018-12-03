package com.wesley.laborcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SalarioPorHoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.salario_por_hora)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
