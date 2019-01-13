package um.vao.jackson;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idUser",
        "googleUserId",
        "name",
        "surname",
        "birthday",
        "gender",
        "email",
        "photoUrl"
})
public class User {

    @JsonProperty("idUser")
    private int idUser;
    @JsonProperty("googleUserId")
    private String googleUserId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("email")
    private String email;
    @JsonProperty("photoUrl")
    private String photoUrl;

    public User() {
    }

    public User(String googleUserId, String name, String surname, String birthday, String gender, String email, String photoUrl) {
        this.googleUserId = googleUserId;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.photoUrl = photoUrl;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        this.googleUserId = googleUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", googleUserId='" + googleUserId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
