package um.vao.jackson;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idComment",
        "text",
        "edited",
        "timeOfPublication",
        "restaurant",
        "user"
})
public class Comment {

    @JsonProperty("idComment")
    private int idComment;
    @JsonProperty("text")
    private String text;
    @JsonProperty("edited")
    private boolean edited;
    @JsonProperty("timeOfPublication")
    private LocalDateTime timeOfPublication;
    @JsonProperty("restaurant")
    private Restaurant restaurant;
    @JsonProperty("user")
    private User user;

    public Comment() {
    }

    public Comment(int idComment, String text, boolean edited, LocalDateTime timeOfPublication, Restaurant restaurant, User user) {
        super();
        this.idComment = idComment;
        this.text = text;
        this.edited = edited;
        this.timeOfPublication = timeOfPublication;
        this.restaurant = restaurant;
        this.user = user;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
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
        return "Comment{" +
                "idComment=" + idComment +
                ", text='" + text + '\'' +
                ", edited=" + edited +
                ", timeOfPublication=" + timeOfPublication +
                ", restaurant=" + restaurant +
                ", user=" + user +
                '}';
    }
}
