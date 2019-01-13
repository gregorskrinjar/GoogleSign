package um.vao.jackson;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idRating",
        "value",
        "timeOfPublication",
        "restaurant",
        "user"
})
public class Rating {

    @JsonProperty("idRating")
    private int idRating;
    @JsonProperty("value")
    private int value;
    @JsonProperty("timeOfPublication")
    private LocalDateTime timeOfPublication;
    @JsonProperty("restaurant")
    private Restaurant restaurant;
    @JsonProperty("user")
    private User user;

    public Rating() {
    }

    public Rating(int idRating, int value, LocalDateTime timeOfPublication, Restaurant restaurant, User user) {
        super();
        this.idRating = idRating;
        this.value = value;
        this.timeOfPublication = timeOfPublication;
        this.restaurant = restaurant;
        this.user = user;
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getTimeOfPublication() {
        return timeOfPublication;
    }

    public void setTimeOfPublication(LocalDateTime timeOfPublication) {
        this.timeOfPublication = timeOfPublication;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    @Override
    public String toString() {
        return "Rating{" +
                "idRating=" + idRating +
                ", value=" + value +
                ", timeOfPublication=" + timeOfPublication +
                ", restaurant=" + restaurant +
                ", user=" + user +
                '}';
    }
}
