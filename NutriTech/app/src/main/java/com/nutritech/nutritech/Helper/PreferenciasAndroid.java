package com.nutritech.nutritech.Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Henrique Domanski on 24/11/2017.
 */

public class PreferenciasAndroid {
    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "prejetoFirebase.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "identificarUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public PreferenciasAndroid(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);

        editor = preferences.edit();
    }

    public void salvarUsuarioPreferencias(String identificadorUusario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUusario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    public String getIdentificador (){
        return preferences.getString(CHAVE_IDENTIFICADOR, null);
    }

    public String getNome (){
        return preferences.getString(CHAVE_NOME, null);
    }

}




