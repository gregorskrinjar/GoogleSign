package um.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import um.vao.jackson.Schedule;

public interface ScheduleAPI {

    @GET("/schedule/all")
    Call<List<Schedule>> getAllSchedules();

    @GET("/schedule/restaurant/{idRestaurant}")
    Call<List<Schedule>> getSchedulesByRestaurantId(@Path("idRestaurant") int idRestaurant);

    @POST("/schedule/add")
    Call<Schedule> addNewSchedule(@Body Schedule schedule);

    @PUT("/schedule/update/{idSchedule}")
    Call<Schedule> updateSchedule(@Body Schedule schedule, @Path("idSchedule") int idSchedule);

    @DELETE("/schedule/delete/{idSchedule}")
    Call<Boolean> deleteScheduleById(@Path("idSchedule") int idSchedule);

}
