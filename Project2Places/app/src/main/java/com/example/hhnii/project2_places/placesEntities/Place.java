package com.example.hhnii.project2_places.placesEntities;

public class Place {

    private String name;
    private String address;
    private Geospot position;
    private PlaceType type;
    private String photo;
    private String phone;
    private String url;
    private String comment;
    private long date;
    private float rating;

    public Place() {
        this.date = System.currentTimeMillis();
        this.position= new Geospot(0,0);
        this.type= PlaceType.OTHER;
    }

    public Place(String name, String address, double latitude, double longitude,
                 PlaceType type, String phone, String url, String comment, float rating) {
        this.name= name;
        this.address= address;
        this.position= new Geospot(latitude, longitude);
        this.type= type;
        this.phone= phone;
        this.url= url;
        this.comment= comment;
        this.date= System.currentTimeMillis();
        this.rating= rating;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Geospot getPosition() { return position; }

    public void setPosition(Geospot position) { this.position = position; }

    public PlaceType getType() { return type; }

    public void setType(PlaceType type) { this.type = type; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public long getDate() { return date; }

    public void setDate(long date) { this.date = date; }

    public float getRating() { return rating; }

    public void setRating(float rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", position=" + position +
                ", type=" + type +
                ", photo='" + photo + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                '}';
    }

}
