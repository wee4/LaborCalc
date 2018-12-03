package com.wesley.laborcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SeguroDesempregoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguro_desemprego)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
