package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //cria-se a var binding que é responsável por interligar o layout com o arquivo principal
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
	super.onCreate(savedInstanceState)
	//mostra qual layout que o binding interligará
        binding = ActivityMainBinding.inflate(layoutInflater)
        //mostra o conteúdo do binding invés do conteúdo default
	setContentView(binding.root)
	
	//cria-se um valor para receber as informações da variável "i" do Login.Activity
        val username = intent.extras?.getString("username")
                //põe um texto no textview do layout deste arquivo
		if(!username.isNullOrEmpty()){
                binding.textOla.setText("Olá $username")
            }
	    //introduz o fechamento do programa quando o botão button.Fechar for apertado
            binding.buttonFechar.setOnClickListener {
                finishAffinity()
            }
	    //introduz uma nova ação para quando o botão button.Pedir for apertado.
            binding.buttonPedir.setOnClickListener {
                //cria-se um valor para que interligue Main.Activity à Splash.Activity
		val i = Intent(this, SplashActivity::class.java)
                //envia os valores da quantia solicitada dos itens (pizza, salada e hamburguer) à Splash.Activity
		i.putExtra("quantidadePizza",binding.editQuantidadePizza.text.toString())
                i.putExtra("quantidadeSalada",binding.editQuantidadeSalada.text.toString())
                i.putExtra("quantidadeHamburguer",binding.editQuantidadeHamburguer.text.toString())
                startActivity(i)
                finish()
            }
	    //inteliga o botão checkPizza à esta atividade
            binding.checkPizza.setOnClickListener {
                //põe uma condição para que caso o usuário aperte a checkbox, irá alterar o texto da variável para 1 e o deixará visível
		if(binding.checkPizza.isChecked()){
                    binding.editQuantidadePizza.setText("1")
                    binding.textPrecoPizza.visibility = View.VISIBLE
                }//caso contrário, o texto se tornará 0 e ficará invisível
		else{
                    binding.editQuantidadePizza.setText("0")
                    binding.textPrecoPizza.visibility = View.GONE
                }
            }
	    //inteliga o botão checkSalada à esta atividade
            binding.checkSalada.setOnClickListener {
                //põe uma condição para que caso o usuário aperte a checkbox, irá alterar o texto da variável para 1 e o deixará visível
		if(binding.checkSalada.isChecked()){
                    binding.editQuantidadeSalada.setText("1")
                    binding.textPrecoSalada.visibility = View.VISIBLE
                }//caso contrário, o texto se tornará 0 e ficará invisível
		else{
                    binding.editQuantidadeSalada.setText("0")
                    binding.textPrecoSalada.visibility = View.GONE
                }
            }
	    //inteliga o botão checkHamburguer à esta atividade
            binding.checkHamburger.setOnClickListener {
                //põe uma condição para que caso o usuário aperte a checkbox, irá alterar o texto da variável para 1 e o deixará visível
		if(binding.checkHamburger.isChecked()){
                    binding.editQuantidadeHamburguer.setText("1")
                    binding.textPrecoHamburguer.visibility = View.VISIBLE
                }//caso contrário, o texto se tornará 0 e ficará invisível
		else{
                    binding.editQuantidadeHamburguer.setText("0")
                    binding.textPrecoHamburguer.visibility = View.GONE
                }
            }

    }
}