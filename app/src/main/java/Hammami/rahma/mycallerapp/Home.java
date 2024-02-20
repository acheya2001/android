package Hammami.rahma.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    Button btnadd,btnlist ;


    // ici on a declarer le tableau dans le home parce que ont na pas fermer le hme mais si on fermer le list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Recuperation
        btnadd=findViewById(R.id.btn_list_home);
        btnlist=findViewById(R.id.btn_add_home);

        //Evenement
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent cest un objet android il prend lemplacement courant(l'activité courante que vous avez le voir ) de votre interface e vous yhezk ll interface cible  ont appel ca (context)
                Intent i = new Intent(Home.this , Add.class);
                startActivity(i);


            }


        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Home.this , list.class);
                startActivity(i);

            }
        });
    }
}