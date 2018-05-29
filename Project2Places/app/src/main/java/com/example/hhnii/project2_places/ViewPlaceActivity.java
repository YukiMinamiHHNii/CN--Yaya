package com.example.hhnii.project2_places;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhnii.project2_places.placesEntities.Place;

import java.text.DateFormat;
import java.util.Date;

import javax.xml.datatype.Duration;

public class ViewPlaceActivity extends AppCompatActivity {

    private long id;
    private Place place;
    private final int EDIT_RESULT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_place);
        Bundle extras= getIntent().getExtras();
        id= extras.getLong("id", -1);
        updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_place_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.share_option:
                return true;
            case R.id.directions_option:
                return true;
            case R.id.edit_option:
                Intent intent= new Intent(this, EditPlaceActivity.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, EDIT_RESULT);
                return true;
            case R.id.delete_option:
                new AlertDialog.Builder(this)
                        .setTitle("Delete place")
                        .setMessage("Are you sure you want to delete this place?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deletePlace((int)id);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deletePlace(int id){
        MainActivity.places.deletePlace(id);
        finish();
        Toast.makeText(this, "Place deleted successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==EDIT_RESULT && resultCode==RESULT_OK){
            updateView();
            findViewById(R.id.viewPlace).invalidate();
        }
    }

    public void updateView(){
        place= MainActivity.places.getPlace((int)id);

        TextView placeName= findViewById(R.id.placeName);
        placeName.setText(place.getName());

        ImageView placeTypeIcon= findViewById(R.id.placeTypeIcon);
        placeTypeIcon.setImageResource(place.getType().getResource());

        TextView placeType= findViewById(R.id.placeType);
        placeType.setText(place.getType().getIdentifier());

        if(!place.getAddress().isEmpty()) {
            TextView placeAddress = findViewById(R.id.placeAddress);
            placeAddress.setText(place.getAddress());
        }else{
            findViewById(R.id.placeAddressIcon).setVisibility(View.GONE);
            findViewById(R.id.placeAddress).setVisibility(View.GONE);
        }

        if(!place.getPhone().isEmpty()) {
            TextView placePhone = findViewById(R.id.placePhone);
            placePhone.setText(place.getPhone());
        }else{
            findViewById(R.id.placePhoneIcon).setVisibility(View.GONE);
            findViewById(R.id.placePhone).setVisibility(View.GONE);
        }

        if(!place.getUrl().isEmpty()) {
            TextView placeUrl = findViewById(R.id.placeUrl);
            placeUrl.setText(place.getUrl());
        }else{
            findViewById(R.id.placeUrlIcon).setVisibility(View.GONE);
            findViewById(R.id.placeUrl).setVisibility(View.GONE);
        }

        if(!place.getComment().isEmpty()) {
            TextView placeInfo = findViewById(R.id.placeInfo);
            placeInfo.setText(place.getComment());
        }else{
            findViewById(R.id.placeInfoIcon).setVisibility(View.GONE);
            findViewById(R.id.placeInfo).setVisibility(View.GONE);
        }

        TextView placeDate= findViewById(R.id.placeDate);
        placeDate.setText(DateFormat.getDateInstance().format(new Date(place.getDate())));

        TextView placeTime= findViewById(R.id.placeTime);
        placeTime.setText(DateFormat.getTimeInstance().format(new Date(place.getDate())));

        RatingBar placeRating= findViewById(R.id.placeRating);
        placeRating.setRating(place.getRating());
        placeRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                place.setRating(rating);
            }
        });
    }
}
