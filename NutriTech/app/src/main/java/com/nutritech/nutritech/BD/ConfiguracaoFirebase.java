package com.nutritech.nutritech.BD;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Henrique Domanski on 22/11/2017.
 */


//Conexão com BD firebase

public class ConfiguracaoFirebase {

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;

    //Referencia
    public static DatabaseReference getFirebase () {

        if (referenciaFirebase == null){
    referenciaFirebase = FirebaseDatabase.getInstance().getReference();

        }
        return referenciaFirebase;
    }

    //Autenticação
    public static FirebaseAuth getFirebaseautenticacao (){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();

        }
        return autenticacao;

    }
}
