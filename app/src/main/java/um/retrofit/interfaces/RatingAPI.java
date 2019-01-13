package um.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import um.vao.jackson.Rating;

public interface RatingAPI {

    @GET("/rating/all")
    Call<List<Rating>> getAllRatings();

    @GET("/rating/{idRating}")
    Call<Rating> getRatingById(@Path("idRating") int idRating);

    @GET("/rating/restaurant/{idRestaurant}")
    Call<List<Rating>> getRatingsByRestaurantId(@Path("idRestaurant") int idRestaurant);

    @GET("/rating/user/{idUser}")
    Call<List<Rating>> getRatingsByUserId(@Path("idUser") int idUser);

    @POST("/rating/add")
    Call<Rating> addNewRating(@Body Rating rating);

    @PUT("/rating/update/{idRating}")
    Call<Rating> updateRating(@Body Rating rating, @Path("idRating") int idRating);

    @DELETE("/rating/delete/{idRating}")
    Call<Boolean> deleteComment(@Path("idRating") int idRating);

}
