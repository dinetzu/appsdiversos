package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
	    //define o tempo que a tela da atividade Splash.Activity ficará exposta
            Handler(Looper.getMainLooper()).postDelayed({
                //cria o valor i para receber as informações de Main.Activity
		val i = intent
                //cria o valor j para receber as informações de i e importá-las para Pedido.Activity
		val j = Intent(this, PedidoActivity::class.java)
                j.putExtras(i)
                //Incia Pedido.Activity
		startActivity(j)
            }//define o delay para que Splash.Activity seja finalizada e a outra comece
	,2000)
        }
    }
