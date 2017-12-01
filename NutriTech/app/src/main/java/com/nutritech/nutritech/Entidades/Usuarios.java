package com.nutritech.nutritech.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.nutritech.nutritech.BD.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Henrique Domanski on 22/11/2017.
 */

public class Usuarios {

    private String id;
    private String nome;
    private String sobrenome;
    private String aniversario;
    private String email;
    private String senha;
    private String sexo;


//Criação do usuario para implementar ao banco de dados

    public Usuarios() {
    }



    //metodo de salvar os atributos do usuario no BD
    public void salvar (){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude

    //Definindo a lista no hasmap
    public Map<String, Object> toMap (){
        HashMap<String, Object> hashMapUsuario = new HashMap<>();

        hashMapUsuario.put("id", getId());
        hashMapUsuario.put("email", getEmail());
        hashMapUsuario.put("senha", getSenha());
        hashMapUsuario.put("nome", getNome());
        hashMapUsuario.put("sobrenome", getSobrenome());
        hashMapUsuario.put("Aniversario", getAniversario());
        hashMapUsuario.put("Sexo", getSexo());

        return hashMapUsuario;

    }

    //Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
}
