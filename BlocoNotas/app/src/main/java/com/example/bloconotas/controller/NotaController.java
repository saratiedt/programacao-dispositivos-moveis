package com.example.bloconotas.controller;

import android.content.Context;

import com.example.bloconotas.modelo.Nota;
import com.example.bloconotas.modelo.NotaDao;

import java.util.ArrayList;
import java.util.List;

public class NotaController {
    Context mContext;
    static NotaDao notaDao;
    public ArrayList<Nota> mlistaNotas;


    public NotaController(Context context) {
        mContext=context;
        if(notaDao ==null) {
            notaDao = new NotaDao(context);
        }
    }

    public Nota cadastrarNota(Nota nota){
        return  notaDao.insertNota(nota);
    }


}
