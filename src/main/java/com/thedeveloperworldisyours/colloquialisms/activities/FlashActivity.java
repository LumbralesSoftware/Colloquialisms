package com.thedeveloperworldisyours.colloquialisms.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.thedeveloperworldisyours.colloquialisms.R;
import com.thedeveloperworldisyours.colloquialisms.dao.SentenceDAO;
import com.thedeveloperworldisyours.colloquialisms.models.Sentence;

import java.util.List;

public class FlashActivity extends ActionBarActivity {

    private SentenceDAO mSentenceDAO;
    private List<Sentence> mSentenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        mSentenceDAO = new SentenceDAO(this);
        getData();
    }

    public void getData(){
        if(exitsDB()){
            mSentenceList=mSentenceDAO.readAllAsc();
            gotActivity();
        }
    }

    public void gotActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean exitsDB(){
        int sentence = mSentenceDAO.getCount();

        return sentence > 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
