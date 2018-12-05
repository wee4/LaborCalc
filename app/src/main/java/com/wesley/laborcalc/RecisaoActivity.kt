package com.wesley.laborcalc

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_recisao.*

class RecisaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recisao)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addListeners()
        setupSpinner()
    }

    private fun setupSpinner() {
        var motivos = arrayOf("Pedido de demissão",
            "Dispensa sem justa causa",
            "Dispensa com justa causa",
            "Termino de contrato de experiência",
            "Antecipada na experiência p/ empregador",
            "Antecipada na experiência p/ empregado",
            "Aposentadoria do empregado",
            "Falecimento do empregado",
            "Demissão de comum acordo")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, motivos)

        // adicionando o modelo com a lista de opções no spinner
        spinnerMotivo.adapter = adapter
        spinnerMotivo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // pegando o valor do item selecionado no spinner
                val selectedItem = parent.getItemAtPosition(position).toString()
                }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }


    private fun addListeners() {
        btnCalcular.setOnClickListener {

        }

        btnVerFonte.setOnClickListener {
            val uris = Uri.parse("https://www.calcule.net/trabalhista/calculo-rescisao-clt/")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intents)
         }

    }
}
