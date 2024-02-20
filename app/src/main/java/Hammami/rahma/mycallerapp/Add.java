package Hammami.rahma.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

    SearchView search;
    ListView lv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        search = findViewById(R.id.search_list);
        lv = findViewById(R.id.listview_list);

        // Création d'une instance de ProfileManager
        ProfileManager profileManager = new ProfileManager(Add.this);

        // Ouverture de la base de données
        profileManager.open();

        // Récupération de tous les profils depuis la base de données


        ArrayList<Profil> data= profileManager.selectAll();

        // Fermeture de la base de données
        profileManager.close();
/*
        ArrayAdapter ad = new ArrayAdapter(
                Add.this,
                android.R.layout.simple_list_item_1, Home.data) ;
        lv.setAdapter(ad);*/
        MyProfilAdapter ad = new MyProfilAdapter(
                Add.this,
                data);
        lv.setAdapter(ad);



    }


}