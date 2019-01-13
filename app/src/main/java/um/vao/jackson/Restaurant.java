package um.vao.jackson;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idRestaurant",
        "name",
        "description",
        "photoUrl",
        "address",
        "latitude",
        "longitude",
        "currentRating",
        "type"
})
public class Restaurant {

    @JsonProperty("idRestaurant")
    private int idRestaurant;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("photoUrl")
    private String photoUrl;
    @JsonProperty("address")
    private String address;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("currentRating")
    private double currentRating;
    @JsonProperty("type")
    private String type;

    public Restaurant() {
    }

    public Restaurant(String name, String description, String photoUrl, String address, double latitude, double longitude, double currentRating, String type) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.currentRating = currentRating;
        this.type = type;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(double currentRating) {
        this.currentRating = currentRating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NonNull
    @Override
    public String toString() {
        return "Restaurant{" +
                "idRestaurant=" + idRestaurant +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", currentRating=" + currentRating +
                ", type='" + type + '\'' +
                '}';
    }
}