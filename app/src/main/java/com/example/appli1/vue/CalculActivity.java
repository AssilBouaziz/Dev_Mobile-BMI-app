package com.example.appli1.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.appli1.R;
import com.example.appli1.controle.Controle;
public class CalculActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        init();
        this.controle = Controle.getInstance();
    }

    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMC;
    private ImageView imgSmiley;
    private Controle controle;

    private void init() {
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMC = (TextView) findViewById(R.id.lblIMC);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        ecouteCalcul();
    }

    private void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
//Toast.makeText(MainActivity.this, "test",oast.LENGTH_SHORT).show();
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e) {
                }
                ;
                if (rdHomme.isChecked()) {
                    sexe = 1;
                }
                if (poids == 0 || taille == 0 || age == 0) {
                    Toast.makeText(CalculActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                } else {
                    afficheResult(poids, taille, age, sexe);
                }
            }
        });
    }

    private void afficheResult(Integer poids, Integer taille, Integer age, Integer
            sexe) {
        this.controle.creerProfil(poids, taille, age, sexe);
        float img = this.controle.getImc();
        String message = this.controle.getMessage();
        if (message == "normal") {
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMC.setTextColor(Color.GREEN);
        } else {
            lblIMC.setTextColor(Color.RED);
            if (message == "trop faible") {
                imgSmiley.setImageResource(R.drawable.maigre);
            } else {
                imgSmiley.setImageResource(R.drawable.graisse);
            }
        }
        lblIMC.setText(String.format("%.01f", img) + " : IMG " + message);
    }
}