package com.wesley.laborcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SalarioLiquidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario_liquido)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
