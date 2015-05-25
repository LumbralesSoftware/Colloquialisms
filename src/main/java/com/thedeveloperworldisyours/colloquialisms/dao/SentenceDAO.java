package com.thedeveloperworldisyours.colloquialisms.dao;

import android.content.Context;

import com.thedeveloperworldisyours.colloquialisms.models.Sentence;
import com.thedeveloperworldisyours.colloquialisms.utils.Constants;

import garin.artemiy.sqlitesimple.library.SQLiteSimpleDAO;


/**
 * Created by javiergonzalezcabezas on 23/5/15.
 */
public class SentenceDAO extends SQLiteSimpleDAO<Sentence> {
    public SentenceDAO(Context context) {
        super(Sentence.class, context, Constants.DATABASE_NAME);
    }
}
