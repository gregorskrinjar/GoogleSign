package um.retrofit;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import um.retrofit.interfaces.RestaurantAPI;
import um.retrofit.interfaces.UserAPI;
import um.vao.jackson.Restaurant;
import um.vao.jackson.User;

public class TestRetrofit {

    public static void main(String[] args) {
        System.out.println("Call a method");
        getAllRestaurants();
    }

    @SuppressWarnings("unused")
    private static void addNewUser() {
        User user = new User("googleId", "Timotej", "Cerar", null, null, "timi.cerar@gmail.com", "photoUrl");

        UserAPI userAPI = ClientAPI.getClient().create(UserAPI.class);
        Call<User> call = userAPI.addNewUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                User newUser = response.body();

                if (newUser != null) {
                    System.out.println(newUser.getName() + " " + newUser.getSurname());
                }

                System.out.println("Success");
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                System.out.println("Failure");
                call.cancel();
            }
        });
    }

    @SuppressWarnings("unused")
    private static void updateUser() {
        User user = new User("googleId", "Gregor", "Škrinjar", null, null, "timi.cerar@gmail.com", "photoUrl");

        UserAPI userAPI = ClientAPI.getClient().create(UserAPI.class);
        Call<User> call = userAPI.updateUser(user, 0);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                User newUser = response.body();

                if (newUser != null)
                    System.out.println(newUser.getName() + " " + newUser.getSurname());

                System.out.println("Success");
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                System.out.println("Failure");
                call.cancel();
            }
        });
    }

    @SuppressWarnings("unused")
    private static void deleteUser() {
        UserAPI userAPI = ClientAPI.getClient().create(UserAPI.class);
        Call<Boolean> call = userAPI.deleteUserById(0);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                System.out.println("Response : " + response.body());
                System.out.println("Success");
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable t) {
                System.out.println("Failure");
                call.cancel();
            }
        });
    }

    @SuppressWarnings("unused")
    private static void getAllRestaurants() {
        RestaurantAPI restaurantAPI = ClientAPI.getClient().create(RestaurantAPI.class);

        Call<List<Restaurant>> call = restaurantAPI.getAllRestaurants();

        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(@NonNull Call<List<Restaurant>> call, @NonNull Response<List<Restaurant>> response) {
                List<Restaurant> restaurants = response.body();

                if (restaurants != null) {
                    for (Restaurant restaurant : restaurants) {
                        System.out.println("Name : " + restaurant.getName());
                    }
                }

                System.out.println("Success");
            }

            @Override
            public void onFailure(@NonNull Call<List<Restaurant>> call, @NonNull Throwable t) {
                System.out.println("Failure");
                call.cancel();
            }
        });
    }
}
