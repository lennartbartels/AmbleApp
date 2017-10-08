package amble.service;

import amble.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hintzl on 07.10.2017.
 */

public interface UserClient {

    @POST("/register")
    Call<User> createAccount(@Body User user);
}
