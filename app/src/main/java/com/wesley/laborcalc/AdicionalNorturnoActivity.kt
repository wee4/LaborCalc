package com.wesley.laborcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class AdicionalNorturnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicional_noturno)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
