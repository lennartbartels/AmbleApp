package amble.main;

import amble.service.UserClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hintzl on 08.10.2017.
 */

public class RestClient {
    private final String baseUrl;
    private UserClient userClient;

    public RestClient(String baseUrl) {
        this.baseUrl = baseUrl;
/*
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();
*/

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        userClient = restAdapter.create(UserClient.class);
    }

    public UserClient getUserClient() {
        return userClient;
    }

    }
