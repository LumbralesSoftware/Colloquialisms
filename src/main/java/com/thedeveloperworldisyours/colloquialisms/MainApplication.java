package com.thedeveloperworldisyours.colloquialisms;

import android.app.Application;
import android.graphics.Typeface;

import com.thedeveloperworldisyours.colloquialisms.utils.Constants;

import garin.artemiy.sqlitesimple.library.util.SimpleDatabaseUtil;
import garin.artemiy.sqlitesimple.library.SQLiteSimple;

/**
 * Created by javiergonzalezcabezas on 23/5/15.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initializeTypefaces();
        // also may use isFirstStartOnAppVersion with your version
        if (SimpleDatabaseUtil.isFirstApplicationStart(this)) {
            SQLiteSimple databaseSimple = new SQLiteSimple(this, Constants.DATABASE_NAME);
//            databaseSimple.rawQuery("CREATE  TABLE "main"."Sentence" ("_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "sentenceENG" VARCHAR NOT NULL , "sentenceES" VARCHAR NOT NULL , "language" VARCHAR NOT NULL )");
//            databaseSimple.rawQuery("INSERT INTO table_name (_id,sentenceENG,sentenceENG,language)\n" +
//                    "VALUES ('1','HELLO','HOLA','ES');");
        }

    }

    public static class Fonts {
        public static Typeface PENCIL;
    }

    private void initializeTypefaces() {

        Fonts.PENCIL = Typeface.createFromAsset(getAssets(), Constants.FONT);
    }

}