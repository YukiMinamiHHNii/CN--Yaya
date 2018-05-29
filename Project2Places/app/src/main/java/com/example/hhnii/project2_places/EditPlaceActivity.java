package com.example.hhnii.project2_places;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hhnii.project2_places.placesEntities.Place;
import com.example.hhnii.project2_places.placesEntities.PlaceType;

public class EditPlaceActivity extends AppCompatActivity {

    private EditText inputName;
    private Spinner inputType;
    private EditText inputAddress;
    private EditText inputPhone;
    private EditText inputUrl;
    private EditText inputComment;
    private long id;
    private Place place;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_place);
        Bundle extras= getIntent().getExtras();
        id= extras.getLong("id", -1);
        place= MainActivity.places.getPlace((int)id);

        inputName= findViewById(R.id.inputName);
        inputName.setText(place.getName());

        inputType= findViewById(R.id.inputType);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, PlaceType.getIdentifiers());
        inputType.setAdapter(adapter);

        inputAddress= findViewById(R.id.inputAddress);
        inputAddress.setText(place.getAddress());

        inputPhone= findViewById(R.id.inputPhone);
        inputPhone.setText(place.getPhone());

        inputUrl= findViewById(R.id.inputUrl);
        inputUrl.setText(place.getUrl());

        inputComment= findViewById(R.id.inputComment);
        inputComment.setText(place.getComment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_place_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.save_option:
                prepareSave();
                return true;
            case R.id.cancel_option:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void prepareSave(){
        Intent intent= new Intent();
        setResult(RESULT_OK, intent);

        place.setName(inputName.getText().toString());
        place.setType(PlaceType.values()[inputType.getSelectedItemPosition()]);
        place.setAddress(inputAddress.getText().toString());
        place.setPhone(inputPhone.getText().toString());
        place.setUrl(inputUrl.getText().toString());
        place.setComment(inputComment.getText().toString());
        MainActivity.places.updatePlace((int)id, place);
        finish();
    }

}
