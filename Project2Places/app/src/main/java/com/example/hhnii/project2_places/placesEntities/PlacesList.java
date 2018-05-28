package com.example.hhnii.project2_places.placesEntities;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PlacesList implements Places {

    protected List<Place> placesList;

    public PlacesList() {
        this.placesList= generatePlaces();
        Log.d("Microwave", placesList.toString());
    }

    @Override
    public void addPlace(Place place) {
        placesList.add(place);
    }

    @Override
    public int createPlace() {
        Place place= new Place();
        placesList.add(place);
        return placesList.size()-1;
    }

    @Override
    public Place getPlace(int id) {
        return placesList.get(id);
    }

    @Override
    public int countPlaces() {
        return placesList.size();
    }

    @Override
    public void updatePlace(int id, Place place) {
        placesList.set(id, place);
    }

    @Override
    public void deletePlace(int id) {
        placesList.remove(id);
    }

    public static List<Place> generatePlaces(){
        List<Place> placesList= new ArrayList<>();

        placesList.add(new Place("name", "address", 0, 0,
                PlaceType.OTHER, "phone", "url", "comment", 0));

        placesList.add(new Place("name2", "address2", 0, 0,
                PlaceType.OTHER, "", "", "comment2", 0));

        placesList.add(new Place("name3", "", 0, 0,
                PlaceType.OTHER, "", "", "", 0));

        placesList.add(new Place("name4", "address4", 0, 0,
                PlaceType.OTHER, "phone4", "url4", "comment4", 0));

        placesList.add(new Place("name5", "address5", 0, 0,
                PlaceType.OTHER, "phone5", "url5", "comment5", 0));

        return placesList;
    }

}
