package com.nutritech.nutritech.Activity.Funcionalidades;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.nutritech.nutritech.Activity.LoginActivity;
import com.nutritech.nutritech.BD.ConfiguracaoFirebase;
import com.nutritech.nutritech.Entidades.Usuarios;
import com.nutritech.nutritech.Helper.Base64Custom;
import com.nutritech.nutritech.Helper.PreferenciasAndroid;
import com.nutritech.nutritech.R;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtCadEmail;
    private EditText edtCadNome;
    private EditText edtCadSobrenome;
    private EditText edtCadSenha;
    private EditText edtCadConfirmarSenha;
    private EditText edtCadAniversario;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnCadastrar;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Chamada nos botoes do layout
        edtCadEmail = (EditText) findViewById(R.id.edtCadEmail);
        edtCadNome = (EditText) findViewById(R.id.edtCadNome);
        edtCadSobrenome = (EditText) findViewById(R.id.edtCadSobrenome);
        edtCadSenha = (EditText) findViewById(R.id.edtCadSenha);
        edtCadConfirmarSenha = (EditText) findViewById(R.id.edtCadConfirmarSenha);
        edtCadAniversario = (EditText) findViewById(R.id.edtCadAniversario);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);


        //setando os cadastros
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCadSenha.getText().toString().equals(edtCadConfirmarSenha.getText().toString())){

                    usuarios = new Usuarios();
                    usuarios.setNome(edtCadNome.getText().toString());
                    usuarios.setEmail(edtCadEmail.getText().toString());
                    usuarios.setSenha(edtCadSenha.getText().toString());
                    usuarios.setAniversario(edtCadAniversario.getText().toString());
                    usuarios.setSobrenome(edtCadSobrenome.getText().toString());
                    if (rbFeminino.isChecked()){
                        usuarios.setSexo("Feminino");
                    }else{
                        usuarios.setSexo(("Masculino"));
                    }
                cadastrarUsuario();

                }else{
                    Toast.makeText(CadastroActivity.this, "Erro ao confirmar senha", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    //Validações do cadastro
    private void cadastrarUsuario(){
        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail() ,
                usuarios.getSenha()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastroActivity.this, "Usuario cadastrado com sucesso", Toast.LENGTH_LONG).show();

                    String idetificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());

                    FirebaseUser usuarioFirebase = task.getResult().getUser();

                    usuarios.setId (idetificadorUsuario);
                    usuarios.salvar();

                    PreferenciasAndroid preferenciasAndroid = new PreferenciasAndroid(CadastroActivity.this);
                    preferenciasAndroid.salvarUsuarioPreferencias(idetificadorUsuario, usuarios.getNome());

                    abrirLoginUsuario();

                }else {
                    String erroExcecao = "";

                    try {

                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroExcecao = "Digite uma sennha mais forte, que contenha no minimo 8 Caracteres entre letras e numeros";


                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "O E-mail digitado é invalido, digite um novo E-mail";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao = "Esse e-mail já está cadastrado no sistema";

                    }catch (Exception e){
                        erroExcecao = "Erro ao efetuar o Cadastro";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, "Erro"+ erroExcecao, Toast.LENGTH_LONG).show();

                }

            }
        });

    }
    //Redirecionamento para a tela de login
    public void abrirLoginUsuario(){
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        finish();
    }
}
