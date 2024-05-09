package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    //cria-se a var binding que é responsável por interligar o layout com o arquivo principal
    private lateinit var binding:ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
	//mostra qual layout que o binding interligará
	binding = ActivityPedidoBinding.inflate(layoutInflater)
	//mostra o conteúdo do binding invés do conteúdo default
        setContentView(binding.root)

	//cria-se o valor i para receber os valores passados pela Splash.Activity
        val i = intent
	//cria as variáveis referentes à quantidade de cada comida e recebe os valores informados na Main.Activity e transforma-os em inteiros
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

	//cria o valor que mostrará o resumo do pedido
        val TEXTO = "Resumo do Pedido\n" +
                //escreve a quantidade de pizza e o preço total de pizzas (quantidade vezes o preço unitário)
		"Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                //escreve a quantidade de salada e o preço total de saladas (quantidade vezes o preço unitário)
		"Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
		//escreve a quantidade de hamburguer e o preço total de hamburgueres (quantidade vezes o preço unitário)
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"
	//passa o texto da variável TEXTO ao texto de textResumo pelo binding
        binding.textResumo.text = TEXTO

    }
}