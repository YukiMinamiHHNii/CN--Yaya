package com.example.hhnii.project2_places.placesEntities;
import com.example.hhnii.project2_places.R;

public enum PlaceType {

    BAR("Bar", R.drawable.bar),
    DRINKING("Drinking", R.drawable.drinking),
    EDUCATION("Education", R.drawable.education),
    GAS("Gas", R.drawable.gas),
    HOTEL("Hotel", R.drawable.hotel),
    NATURE("Nature", R.drawable.nature),
    RESTAURANT("Restaurant", R.drawable.restaurant),
    SHOPPING("Shopping", R.drawable.shopping),
    SHOWS("Shows", R.drawable.shows),
    SPORTS("Sports", R.drawable.sports),
    OTHER("Other", R.drawable.other);

    private String identifier;
    private int resource;

    PlaceType(String identifier, int resource) {
        this.identifier= identifier;
        this.resource= resource;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getResource() {
        return resource;
    }

    public static String[] getIdentifiers(){
        String[] typesArray= new String[PlaceType.values().length];

        for(PlaceType type: PlaceType.values()){
            typesArray[type.ordinal()]=type.getIdentifier();
        }

        return typesArray;
    }

}
