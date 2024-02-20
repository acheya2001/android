package Hammami.rahma.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class list extends AppCompatActivity {

    Button btnsave , btnexit ;
    EditText ednom , edlast , ednumber ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnsave = findViewById(R.id.btnsave_add);
        btnexit = findViewById(R.id.btnexit_add);
        ednom = findViewById(R.id.ednom_add);
        edlast = findViewById(R.id.edlast_add);
        ednumber = findViewById(R.id.ednumber_add);



        //Acition hedhi mte3 class Profil


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String nom=ednom.getText().toString();
                String prenom = edlast.getText().toString();
                String numero = ednumber.getText().toString();

                Profil p = new Profil(nom,prenom,numero);

                // ici il va recuperer les donner de l'instance p et le stocker dans le home ? ou ? dans le table data
                Home.data.add(p);

                // cette ligne de Toast affiche une ecriture comme splash screen fissa3 tetnaha
                Toast.makeText(list.this , "données ajoutées..." ,Toast.LENGTH_SHORT);*/

                // Création d'une instance de ProfileManager
                ProfileManager profileManager = new ProfileManager(list.this);

                // Ouverture de la base de données
                profileManager.open();

                // Récupération des données des champs de saisie
                String nom=ednom.getText().toString();
                String prenom = edlast.getText().toString();
                String numero = ednumber.getText().toString();

                // Insertion du profil dans la base de données
                long result = profileManager.insert(nom, prenom, numero);

                // Fermeture de la base de données
                profileManager.close();


            }











        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.this.finish();
            }
        });

    }
}