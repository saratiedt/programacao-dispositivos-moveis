package com.example.bloconotas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;


public class NotaDao {
        Context mContext;
        SQLiteDatabase database;

        public NotaDao(Context mContext) {
            this.mContext = mContext;
            database = mContext.openOrCreateDatabase("dbnotas", Context.MODE_PRIVATE, null);

            database.execSQL("CREATE TABLE IF NOT EXISTS notas" +
                    "  (id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    " titulo varchar," +
                    " texto varchar)");
        }
        public Nota insertNota(Nota nota) {
            if (nota.getId()==null){
                ContentValues contentValues= new ContentValues();
                contentValues.put("titulo",nota.getTitulo());
                contentValues.put("texto",nota.getTexto());
                long i= database.insert("notas",null,contentValues);
                nota.setId( (int) i);
            }
            return nota;
        }



    }
