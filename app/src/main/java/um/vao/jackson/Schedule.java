package um.vao.jackson;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idSchedule",
        "orderBy",
        "startTime",
        "endTime",
        "day",
        "restaurant"
})
public class Schedule {

    @JsonProperty("idSchedule")
    private int idSchedule;
    @JsonProperty("orderBy")
    private int orderBy;
    @JsonProperty("startTime")
    private LocalTime startTime;
    @JsonProperty("endTime")
    private LocalTime endTime;
    @JsonProperty("day")
    private Day day;
    @JsonProperty("restaurant")
    private Restaurant restaurant;

    public Schedule() {
    }

    public Schedule(int idSchedule, int orderBy, LocalTime startTime, LocalTime endTime, Day day, Restaurant restaurant) {
        super();
        this.idSchedule = idSchedule;
        this.orderBy = orderBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.restaurant = restaurant;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @NonNull
    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + idSchedule +
                ", orderBy=" + orderBy +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", day=" + day +
                ", restaurant=" + restaurant +
                '}';
    }
}