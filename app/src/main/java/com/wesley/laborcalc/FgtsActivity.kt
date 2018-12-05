package com.wesley.laborcalc

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_fgts.*

class FgtsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fgts)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnCalcular.setOnClickListener {
            val fgts = ((txtSalary.text.toString().toDouble() * 0.8) * txtMonth.text.toString().toDouble()) /10
            txtResultado.text =  "Resultado: R$ %.2f".format(fgts)
            txtByMes.text = "Valor por mês: R$ %.2f".format((txtSalary.text.toString().toDouble() * 0.08))
            txtCalculo.text = "Cálculo: " + txtSalary.text.toString() + " x 0.8" + " x " + txtMonth.text.toString()
        }


        btnVerFonte.setOnClickListener {
            val uris = Uri.parse("http://www.calculador.com.br/calculo/fgts")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intents)
        }

    }

    // adicionando as funções nos itens do menu
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // caso o botão home seja selecionado (esse é o botão padrão quando inserimos o DisplayHome
        return if (item?.itemId == android.R.id.home) {
            // finalizando a activity
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
