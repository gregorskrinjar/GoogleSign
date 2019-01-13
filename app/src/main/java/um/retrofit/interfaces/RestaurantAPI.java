package um.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import um.vao.jackson.Restaurant;

public interface RestaurantAPI {

    @GET("/restaurant/all")
    Call<List<Restaurant>> getAllRestaurants();

    @GET("/restaurant/{idRestaurant}")
    Call<Restaurant> getRestaurantById(@Path("idRestaurant") int idRestaurant);

    @POST("/restaurant/add")
    Call<Restaurant> addNewRestaurant(@Body Restaurant restaurant);

    @PUT("/restaurant/update/{idRestaurant}")
    Call<Restaurant> updateRestaurant(@Body Restaurant restaurant, @Path("idRestaurant") int idRestaurant);

    @DELETE("/restaurant/delete/{idRestaurant}")
    Call<Boolean> deleteRestaurant(@Path("idRestaurant") int idRestaurant);

}
