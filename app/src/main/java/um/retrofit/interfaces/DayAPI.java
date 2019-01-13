package um.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import um.vao.jackson.Day;

public interface DayAPI {

    @GET("/day/all")
    Call<List<Day>> getAllDays();

    @GET("/day/{idDay}")
    Call<Day> getDayById(@Path("idDay") int idDay);

    @POST("/day/add")
    Call<Day> addNewDay(@Body Day day);

    @PUT("/day/update/{idDay}")
    Call<Day> updateDay(@Body Day day, @Path("idDay") int idDay);

    @DELETE("/day/delete/{idDay}")
    Call<Boolean> deleteDayById(@Path("idDay") int idDay);
}
