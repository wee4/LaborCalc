package com.wesley.laborcalc

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_seguro_desemprego.*

class SeguroDesempregoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguro_desemprego)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btnCalcular.setOnClickListener {
            val result:Double = txtSalary1.text.toString().toDouble()
            + txtSalary2.text.toString().toDouble()
            + txtSalary3.text.toString().toDouble()
            val media = result/3
            val partialResult = applyPercentage(result)
            val totalResult = partialResult * 4
            txtResultado.text =  "Resultado: R$ %.2f".format(totalResult)
            txtParcelado.text = "Você tem direito a 4 parcelas no valor de: R$ %.2f".format(partialResult)
        }


        btnVerFonte.setOnClickListener {
            val uris = Uri.parse("https://www.calcule.net/trabalhista/calculo-seguro-desemprego/")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intents)
        }

    }

    fun applyPercentage(value:Double):Double{
        if(value <= 1480.25) return value * 0.8
        if(value > 1480.25 && value <= 2467.33) return (value - 1480.26) * 0.5 + 1184.20
        if(value > 2467.33) return 1677.74
        return 0.0
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
