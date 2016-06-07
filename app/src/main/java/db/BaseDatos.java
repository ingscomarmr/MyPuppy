package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.omunguia.mypuppy.bean.ListaMascotas;
import com.omunguia.mypuppy.bean.Mascota;

import java.util.ArrayList;

/**
 * Created by omunguia on 05/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    public Context context;

    public BaseDatos(Context context) {
        super(context, BaseDatosConfig.NAME_DB, null, BaseDatosConfig.VERSION_DB);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTableMyPuppy = "CREATE TABLE "+
                BaseDatosConfig.Puppy.NAME_TABLE             +"("+
                BaseDatosConfig.Puppy.PUPPY_ID               +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                BaseDatosConfig.Puppy.PUPPY_NOMBRE           +" TEXT,"+
                BaseDatosConfig.Puppy.PUPPY_LIKES            +" INTEGER,"+
                BaseDatosConfig.Puppy.PUPPY_IMG_RECURSO_ID   +" INTEGER )";

        /* esta de mas si arriba se puede poner los likes
        String  crearTablePuppyLikes = "CREATE TABLE "+
                BaseDatosConfig.PuppyLikes.NAME_TABLE             +"("+
                BaseDatosConfig.PuppyLikes.PUPPY_lIKES_ID               +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                BaseDatosConfig.PuppyLikes.PUPPY_ID           +" INTEGER,"+
                BaseDatosConfig.PuppyLikes.NO_LIKES   +" INTEGER, " +
                " FOREIGN KEY(" + BaseDatosConfig.PuppyLikes.PUPPY_ID + ") REFERENCES " + BaseDatosConfig.Puppy.NAME_TABLE + "(" + BaseDatosConfig.Puppy.PUPPY_ID + ") " +
                ")";*/

        Log.i("#Crear tabla",crearTableMyPuppy);
        db.execSQL(crearTableMyPuppy);
        //Log.i("#Crear tabla", crearTablePuppyLikes);
        //db.execSQL(crearTablePuppyLikes);
        //db.close();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            Log.i("#inicializa DB", "Inicializar base de datos");
            db.execSQL("DROP TABLE IF EXIST " + BaseDatosConfig.Puppy.NAME_TABLE);
            db.execSQL("DROP TABLE IF EXIST " + BaseDatosConfig.PuppyLikes.NAME_TABLE);
            onCreate(db);
        }
    }

    public ArrayList<Mascota> getMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + BaseDatosConfig.Puppy.NAME_TABLE;
        Log.i("#Obtener mascotas","Obtener mascotas:" + query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        while (cursor.moveToNext()){
            Mascota mascota = new Mascota();
            mascota.setIdMascota(cursor.getInt(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_ID)));
            mascota.setNombre(cursor.getString(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_NOMBRE)));
            mascota.setImgStr(cursor.getInt(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_IMG_RECURSO_ID)));
            mascota.setLikes(cursor.getInt(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_LIKES)));
            Log.i("#item Mascota",mascota.getNombre());
            mascotas.add(mascota);
        }

        cursor.close();
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> getMascotasTop5(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + BaseDatosConfig.Puppy.NAME_TABLE + " ORDER BY " + BaseDatosConfig.Puppy.PUPPY_LIKES + " DESC LIMIT 5";
        Log.i("#Obtener mascotas","Obtener mascotas:" + query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        while (cursor.moveToNext()){
            Mascota mascota = new Mascota();
            mascota.setIdMascota(cursor.getInt(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_ID)));
            mascota.setNombre(cursor.getString(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_NOMBRE)));
            mascota.setImgStr(cursor.getInt(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_IMG_RECURSO_ID)));
            mascota.setLikes(cursor.getInt(cursor.getColumnIndex(BaseDatosConfig.Puppy.PUPPY_LIKES)));
            Log.i("#item Mascota",mascota.getNombre());
            mascotas.add(mascota);
        }

        cursor.close();
        db.close();

        return mascotas;
    }

    public void insertMascota(ContentValues contentValues){
        Log.i("#inserta", "inserta contacto");
        SQLiteDatabase db = this.getReadableDatabase();
        db.insert(BaseDatosConfig.Puppy.NAME_TABLE, null, contentValues);
        db.close();
    }

    public void likeMascota(int idPuppy,int likes){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + BaseDatosConfig.Puppy.NAME_TABLE +
                " SET " + BaseDatosConfig.Puppy.PUPPY_LIKES + "=" + likes +
                " WHERE " + BaseDatosConfig.Puppy.PUPPY_ID + "=" + idPuppy;
        Log.i("#update likes", query);
        db.execSQL(query);
        db.close();
    }

    public int countMascotas(){
        int total = 0;
        String query = "SELECT COUNT(*) as Total FROM " + BaseDatosConfig.Puppy.NAME_TABLE;
        Log.i("#query", query);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            total = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return total;
    }
}
