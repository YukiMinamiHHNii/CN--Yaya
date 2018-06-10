package com.example.hhnii.project2_places;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hhnii.project2_places.placesEntities.Places;
import com.example.hhnii.project2_places.placesEntities.PlacesList;

public class MainActivity extends AppCompatActivity {

    private Button showPlacesBtn, preferencesBtn, aboutButton, exitButton;
    public static Places places= new PlacesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showPlacesBtn= findViewById(R.id.showPlacesBtn);
        showPlacesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSavedPreferences();
            }
        });

        preferencesBtn= findViewById(R.id.preferencesBtn);
        preferencesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreferences(null);
            }
        });

        aboutButton= findViewById(R.id.aboutBtn);
        aboutButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        showAbout(null);
                    }
                }
        );
        exitButton= findViewById(R.id.exitBtn);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            showPreferences(null);
            return true;
        }else if(id== R.id.about_settings){
            showAbout(null);
            return true;
        }else if(id== R.id.search_settings){
            showPlaceView(null);
            return true;
    }
        return super.onOptionsItemSelected(item);
    }

    public void showPreferences(View view){
        Intent intent= new Intent(this, PreferencesActivity.class);
        startActivity(intent);
    }

    public void showAbout(View view){
        Intent intent= new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void showPlaceView(View view){
        final EditText search= new EditText(this);
        search.setText("0");

        new AlertDialog.Builder(this)
                .setTitle("Search place")
                .setMessage("Insert id of the place to show").setView(search)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent= new Intent(MainActivity.this, ViewPlaceActivity.class);
                        intent.putExtra("id", Long.parseLong(search.getText().toString()));
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();

    }

    public void showSavedPreferences(){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        String test= "notifications: " + preferences.getBoolean("notificationPref", false)
                + "\n" + "maxPlaces: " + preferences.getString("placesMaxPref", "")
                + "\n" + "orderPref: " + preferences.getString("orderPref", "")
                + "\n" + "mailActivate: " + preferences.getBoolean("mailPrefActivate", false)
                + "\n" + "mailAddress: " + preferences.getString("mailPrefAddress", "")
                + "\n" + "mailType: " + preferences.getString("mailPrefType", "");
        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();
    }

}