package com.example.appli1.modele;
import com.example.appli1.modele.Profil;
public class Profil{
    //constantes
    private static final Integer minFemme = 15; //maigre si en dessous
    private static final Integer maxFemme = 30; //gros si en dessus
    private static final Integer minHomme = 10; //maigre si en dessous
    private static final Integer maxHomme = 25; //gros si en dessus
    //propriétés
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float imc;
    private String message;
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMC();
        this.resultIMC();
    }
    public Integer getPoids() {
        return poids;
    }
    public Integer getTaille() {
        return taille;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getSexe() {
        return sexe;
    }
    public float getImc() {
        return imc;
    }

    public String getMessage() {
        return message;
    }
    private void calculIMC(){
        float tailleM = ((float)taille)/100;
        this.imc = (float)((1.2*poids/(tailleM*tailleM))+(0.23*age)-(10.83*sexe)- 5.4);
    }
    private void resultIMC(){
        Integer min;
        Integer max;
        if (sexe==0){ //Femme
            min = minFemme;
            max = maxFemme;
        }else { //Homme
            min = minHomme;
            max = maxHomme;
        }
//message correspondant
        message = "normal";
        if (imc<min){
            message="trop faible";
        }else{
            if (imc>max){
                message = "trop élevé";
            }
        }
    }
}