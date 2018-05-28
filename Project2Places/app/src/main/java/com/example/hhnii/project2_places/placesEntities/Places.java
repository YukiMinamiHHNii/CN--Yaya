package com.example.hhnii.project2_places.placesEntities;

public interface Places {

    void addPlace(Place place);

    int createPlace();

    Place getPlace(int id);

    int countPlaces();

    void updatePlace(int id, Place place);

    void deletePlace(int id);

}
