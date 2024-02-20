package Hammami.rahma.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // declaration globale des composantes
    EditText edemail,edpwd ;
    Button btnexit , btnlogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // recuperation des composantes
        btnexit = findViewById(R.id.btnexit_auth);
        btnlogin = findViewById(R.id.btnlogin_auth);
        edemail = findViewById(R.id.edemail_auth);
        edpwd = findViewById(R.id.edpassword_auth);


        //evenement

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Home.class);
                startActivity(i);
                finish();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish();


            }
        });

    }
}