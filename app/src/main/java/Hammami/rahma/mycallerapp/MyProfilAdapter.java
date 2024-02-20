package Hammami.rahma.mycallerapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyProfilAdapter extends BaseAdapter {
    Context con ;
    ArrayList<Profil> data ;

    MyProfilAdapter(Context con , ArrayList<Profil> data){
        this.con=con;
        this.data=data;

    }

    @Override
    public int getCount() {
        //elle retourne le nb de views a créer
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //crér un view
        //convertir code xml
        LayoutInflater inf = LayoutInflater.from(con);
        View v = inf.inflate(R.layout.view_profil,null);

        //recuperation de sous views /HOLDERS

        TextView tvname = v.findViewById(R.id.tvname_profil);
        TextView tvlastname=v.findViewById(R.id.tvlastname_profil);
        TextView tvnumber=v.findViewById(R.id.tvnumber_profil);

        ImageView imgDelete = v.findViewById(R.id.imgDelete);
        ImageView imgEdit=v.findViewById(R.id.imgEdit);
        ImageView imgCall=v.findViewById(R.id.imgCall) ;

        Profil p = data.get(position);
        //affecter le view/HOLDER


        //pour addicher les numeros

        tvname.setText(p.nom);
        tvlastname.setText(p.prenom);
        tvnumber.setText(p.numero);


        //action sur le holders
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //numerotation pour appler
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+p.numero));
                con.startActivity(i);
            }
        });


        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pour afficher une alerte dialogue de suppression
                AlertDialog.Builder alert= new AlertDialog.Builder(con);
                alert.setTitle("Suppression");
                alert.setMessage("Confirmer la suppression?");
                alert.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //suppression
                        data.remove(position);
                        //pour refracher la data
                        notifyDataSetChanged();

                    }
                });




                alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.setNeutralButton("Exit",null);
                alert.show();

            }
        });
        imgEdit.setOnClickListener(new View.OnClickListener() {

            AlertDialog dialog;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert= new AlertDialog.Builder(con);
                alert.setTitle("Edition");
                alert.setMessage("Modifier les infos !");

                //convertir le fichier xml
                LayoutInflater inf = LayoutInflater.from(con);
                View vd = inf.inflate(R.layout.view_dialog,null);
                //recuperer les views
                EditText ednom=vd.findViewById(R.id.ednom_dialog);
                EditText edprenom=vd.findViewById(R.id.edprenom_dialog);
                EditText ednumero=vd.findViewById(R.id.ednumero_dialog);
                Button btnenregistrer=vd.findViewById(R.id.btnenregistrer_dialog);
                Button btnannuler=vd.findViewById(R.id.btnannuler_dialog);
// ici rendre le numero non editable
                ednumero.setEnabled(false);


                ednom.setText(p.nom);
                edprenom.setText(p.prenom);
                ednumero.setText(p.numero);

                btnenregistrer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newnom =ednom.getText().toString();
                        String newprenom = edprenom.getText().toString();
                        Profil newprofil = new Profil(newnom,newprenom,p.numero);

                        //modifier les donnees nomprenom dans la bdd
                        data.set(position,newprofil);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                btnannuler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });




                alert.setView(vd);
                dialog = alert.create();
                dialog.show();
            }
        });

        return v ;






       
    }
}
