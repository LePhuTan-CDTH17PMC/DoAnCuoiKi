package com.example.doancuoiki.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.doancuoiki.Class.LichSu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DB_LichSuChoi {
    String DATABASE_NAME = "DBLichSuChoi.sqlite";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase db = null;

    Context context;

    public DB_LichSuChoi(Context context) {
        this.context = context;

        processSQLite();
    }

    private void processSQLite() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try{
                CopyDatabaseFromAsset();
                Toast.makeText(context, "Copy successful !!!", Toast.LENGTH_SHORT).show();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void CopyDatabaseFromAsset() {
        try{
            InputStream databaseInputStream = context.getAssets().open(DATABASE_NAME);

            String outputStream = getPathDatabaseSystem();

            File file = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!file.exists()){
                file.mkdir();
            }

            OutputStream databaseOutputStream = new FileOutputStream(outputStream);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = databaseInputStream.read(buffer)) > 0){
                databaseOutputStream.write(buffer,0,length);
            }


            databaseOutputStream.flush();
            databaseOutputStream.close();
            databaseInputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String getPathDatabaseSystem() {
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    public ArrayList<LichSu> getAllLichSu(){
        ArrayList<LichSu> arrayList = new ArrayList<>();

        db = context.openOrCreateDatabase(DATABASE_NAME,context.MODE_PRIVATE,null);

        String sql = "SELECT * FROM LichSuChoi";

        Cursor cursor  = db.rawQuery(sql ,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            int name = cursor.getInt(1);
            String diem = cursor.getString(2);

            arrayList.add(new LichSu(0,1,"1000"));
        }
        return arrayList;
    }

    public void insertLichSu(LichSu lichSu){

        db = context.openOrCreateDatabase(DATABASE_NAME,context.MODE_PRIVATE,null);

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",lichSu.getId());
        contentValues.put("name",lichSu.getName());
        contentValues.put("diem",lichSu.getDiem());

        if(db.insert("LichSuChoi",null,contentValues) > 0){
            Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
        }
    }
}
