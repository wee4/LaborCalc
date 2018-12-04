package com.wesley.laborcalc

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_ferias.*

class FeriasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ferias)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addListener()
    }


    fun addListener(){
        seekBarDias.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                txtDias.text = "Dias de férias: ${seekBar.progress.toString()}"
                if(seekBar.progress >= 30){
                    switchAbono.isClickable = false
                    switchAbono.isChecked = false
                }else{
                    switchAbono.isClickable = true
                    switchAbono.isChecked = true
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        btnCalcular.setOnClickListener {
            val valorDiasDeFerias = (txtSalary.text.toString().toDouble() / 30) * seekBarDias.progress
            val diasVendidos = 30 - seekBarDias.progress
            val valorDiasVendidos = valorDiasDeFerias / 3
            val decimo = txtSalary.text.toString().toDouble() /2
            val abonoPec = (txtSalary.text.toString().toDouble() / 30)  * diasVendidos - valorDiasVendidos

            var result = valorDiasDeFerias + valorDiasVendidos

            if(switchDecimo.isChecked){
                result += decimo
            }

            if(switchAbono.isChecked){
                val tercoAbono = abonoPec / 3
                result+= abonoPec + tercoAbono
            }

            txtResultado.text = "Total Bruto à receber: \n R$ %.2f".format(result)

        }


        btnVerFonte.setOnClickListener {
            val uris = Uri.parse("https://www.calcule.net/trabalhista/calculo-de-ferias/")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intents)
        }
    }
}
