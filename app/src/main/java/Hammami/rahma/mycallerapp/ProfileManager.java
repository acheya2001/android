package Hammami.rahma.mycallerapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProfileManager {
    Context context;
    SQLiteDatabase database = null;

    // Constructor
    public ProfileManager(Context context) {
        this.context = context;
    }

    // Open the database
    public void open() {
        MyProfileHelper dbHelper = new MyProfileHelper(context, "base_rahma", null, 1);
        database = dbHelper.getWritableDatabase();
    }

    // Insert a new profile into the database
    public long insert(String name, String lastName, String number) {
        long a =0;
        ContentValues values = new ContentValues();
        values.put(MyProfileHelper.col_name, name);
        values.put(MyProfileHelper.col_lastName, lastName);
        values.put(MyProfileHelper.col_number, number);

        a=database.insert(MyProfileHelper.table_profil, null, values);
        return a ;
    }

    // Retrieve all profiles from the database
    public ArrayList<Profil> selectAll() {
        ArrayList<Profil> data = new ArrayList<>();
        Cursor cursor = database.query(
                MyProfileHelper.table_profil,
                new String[]{ MyProfileHelper.col_name, MyProfileHelper.col_lastName, MyProfileHelper.col_number},
                null, null, null, null, null
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String name = cursor.getString(0);
            String lastName = cursor.getString(1);
            String number = cursor.getString(2);

            data.add(new Profil(name, lastName, number));
            cursor.moveToNext();
        }
        cursor.close();

        return data;
    }



    // Delete profil ml base de donnees
    public long delete(String number) {
        long result = -1;
        result = database.delete(
                MyProfileHelper.table_profil,
                MyProfileHelper.col_number + "=" + number,
                null
        );
        return result;
    }

    public void close() {
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}
