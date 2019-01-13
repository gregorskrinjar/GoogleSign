package um.vao.jackson;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idDay",
        "name"
})
public class Day {

    @JsonProperty("idDay")
    private int idDay;
    @JsonProperty("name")
    private String name;

    public Day() {
    }

    public Day(int idDay, String name) {
        super();
        this.idDay = idDay;
        this.name = name;
    }

    public int getIdDay() {
        return idDay;
    }

    public void setIdDay(int idDay) {
        this.idDay = idDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Day{" +
                "idDay=" + idDay +
                ", name='" + name + '\'' +
                '}';
    }
}
