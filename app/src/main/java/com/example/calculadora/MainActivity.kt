package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        numero_zero.setOnClickListener{ acrescentarUmaExpressao("0",true) }
        numero_um.setOnClickListener{ acrescentarUmaExpressao("1",true) }
        numero_dois.setOnClickListener{ acrescentarUmaExpressao("2",true) }
        numero_tres.setOnClickListener{ acrescentarUmaExpressao("3",true) }
        numero_quatro.setOnClickListener{ acrescentarUmaExpressao("4",true) }
        numero_cinco.setOnClickListener{ acrescentarUmaExpressao("5",true) }
        numero_seis.setOnClickListener{ acrescentarUmaExpressao("6",true) }
        numero_sete.setOnClickListener{ acrescentarUmaExpressao("7",true) }
        numero_oito.setOnClickListener{ acrescentarUmaExpressao("8",true) }
        numero_nove.setOnClickListener{ acrescentarUmaExpressao("9",true) }
        ponto.setOnClickListener { acrescentarUmaExpressao(".",true) }


        //operadores
        soma.setOnClickListener { acrescentarUmaExpressao("+",false) }
        subtracao.setOnClickListener { acrescentarUmaExpressao("-",false) }
        multiplicacao.setOnClickListener { acrescentarUmaExpressao("*",false) }
        divisao.setOnClickListener { acrescentarUmaExpressao("/",false) }

        limpar.setOnClickListener {
            expressao.text = ""
            text_resultado.text = ""
        }

        backspace.setOnClickListener {
            val string = expressao.text.toString()

            if(string.isNotBlank()){
                expressao.text = string.substring(0,string.length-1)
            }
            text_resultado.text = ""
        }

        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult  = resultado.toLong()

                if(resultado == longResult.toDouble()){
                    text_resultado.text = longResult.toString()
                }else{
                    text_resultado.text = resultado.toString()
                }
            }catch (e: Exception){}
        }

    }
    fun acrescentarUmaExpressao(string:String, limpar_dados:Boolean){

        if(text_resultado.text.isNotEmpty()){
            expressao.text = ""
        }

        if(limpar_dados){
            text_resultado.text = ""
            expressao.append(string)
        }else{
            expressao.append(text_resultado.text)
            expressao.append(string)
            text_resultado.text = ""
        }
    }
}