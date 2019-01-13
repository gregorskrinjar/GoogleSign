package um.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import um.vao.jackson.User;

public interface UserAPI {

    @GET("/user/all")
    Call<List<User>> getAllUsers();

    @GET("/user/{idUser}")
    Call<User> getUserById(@Path("idUser") int idUser);

    @GET("/user/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    @GET("/user/googleId/{googleUserId}")
    Call<User> getUserByGoogleId(@Path("googleUserId") String googleUserId);

    @GET("/user/email/{email}/googleId/{googleUserId}")
    Call<User> getUserByEmailOrGoogleId(@Path("email") String email, @Path("googleUserId") String googleUserId);

    @POST("/user/add")
    Call<User> addNewUser(@Body User user);

    @PUT("/user/update/{idUser}")
    Call<User> updateUser(@Body User user, @Path("idUser") int idUser);

    @DELETE("/user/delete/{idUser}")
    Call<Boolean> deleteUserById(@Path("idUser") int idUser);

}
