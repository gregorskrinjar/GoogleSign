package um.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import um.vao.jackson.Comment;

public interface CommentAPI {

    @GET("/comment/all")
    Call<List<Comment>> getAllComments();

    @GET("/comment/{idComment}")
    Call<Comment> getCommentById(@Path("idComment") int idComment);

    @GET("/comment/restaurant/{idRestaurant}")
    Call<List<Comment>> getCommentsByRestaurantId(@Path("idRestaurant") int idRestaurant);

    @GET("/comment/user/{idUser}")
    Call<List<Comment>> getCommentsByUserId(@Path("idUser") int idUser);

    @POST("/comment/add")
    Call<Comment> addNewComment(@Body Comment comment);

    @PUT("/comment/update/{idComment}")
    Call<Comment> updateComment(@Body Comment comment, @Path("idComment") int idComment);

    @DELETE("/comment/delete/{idComment}")
    Call<Boolean> deleteComment(@Path("idComment") int idComment);

}
