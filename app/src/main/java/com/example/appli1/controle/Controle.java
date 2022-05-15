package com.example.appli1.controle;
import com.example.appli1.modele.Profil;
public final class Controle {
    private static Controle instance=null;
    private Profil profil;
    private Controle(){
        super();
    }
    public static final Controle getInstance(){
        if (Controle.instance == null){
            Controle.instance = new Controle();

        }
        return Controle.instance;
    }
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer
            sexe){
        profil = new Profil(poids, taille, age, sexe);
    }
    public float getImc(){
        return profil.getImc();
    }
    public String getMessage(){
        return profil.getMessage();
    }
}
