package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //cria-se a var binding que é responsável por interligar o layout com o arquivo principal
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
	//mostra qual layout que o binding interligará
        binding = ActivityLoginBinding.inflate(layoutInflater)
	//mostra o conteúdo do binding invés do conteúdo default
        setContentView(binding.root)

	//introduz um script quando o usuário clicar no botão entrar
        binding.buttonEntrar.setOnClickListener {
            //põe o elemento introduzido pelo usuário no editUsername no valor username
	    val username = binding.editUsername.text.toString().trim()
            //põe o elemento introduzido pelo usuário no editPassword no valor password
	    val password = binding.editPassword.text.toString().trim()

	    //cria uma verificação para que o usuário entre no sistema caso ponha as seguintes informações
            if (username.equals("Diana") && password.equals("6")) {
                //cria-se um valor para inteligar Login.Activity à Main.Activity
		val i = Intent(this, MainActivity::class.java)
                //Passa os dados de username do Login.Activity à Main.Activity
		i.putExtra("username", username)
                //inicia a tela Main.Activity
		startActivity(i)
                //fecha a tela do Login.Activity
		finish()
            } //caso não der certo, o programa irá exibir um pop-up mostrando que as informações requeridas para logar no programa não foram inseridas corretamente.
		else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}