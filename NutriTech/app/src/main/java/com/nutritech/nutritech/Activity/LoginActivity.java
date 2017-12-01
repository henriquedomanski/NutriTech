package com.nutritech.nutritech.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nutritech.nutritech.Activity.Funcionalidades.CadastroActivity;
import com.nutritech.nutritech.BD.ConfiguracaoFirebase;
import com.nutritech.nutritech.Entidades.Usuarios;
import com.nutritech.nutritech.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private TextView tvAbreCadastro;
    private Button btnLogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;

    //Validação da tela de login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //chamadas do layout login

        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnLogar = (Button) findViewById(R.id.btnLogar);
        tvAbreCadastro = (TextView) findViewById(R.id.tvAbreCadastro);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")){

                    usuarios = new Usuarios();
                    usuarios.setEmail(edtEmail.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());

                    validarlogin();

                }else{
                    Toast.makeText(LoginActivity.this, "Preencha os campos de email e senha", Toast.LENGTH_SHORT).show();

                }
            }
        });
        //chamada do botão de abrir cadastro

        tvAbreCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreCadastroUsuario();
            }
        });


    }

    //metodo de validação de login
    private void validarlogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    abrirTelaPrincipal ();
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(LoginActivity.this, "Usuario ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Redirecionamento para a tela de MENU
    public void abrirTelaPrincipal (){
        Intent intentAbrirTelaPrincipal = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intentAbrirTelaPrincipal);
    }
    //Redirecionamento para a tela de cadastro
    public void abreCadastroUsuario(){
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(intent);
    }
}
