package amble.service;

import amble.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by hintzl on 07.10.2017.
 */

public interface UserClient {

    @POST("users")
    Call<Void> createAccount(@Body User user);

    @GET("users/{username}")
    Call<User> getUserByUsername(@Path("username" )String name );
}
