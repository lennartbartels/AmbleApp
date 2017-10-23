package amble.main;

import amble.model.User;
import amble.model.Photowalk;
import amble.service.PhotowalkApiService;
import amble.service.SessionClient;
import amble.service.UserClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hintzl on 08.10.2017.
 */

public class RestClient {
    private static String baseUrl = "http://10.0.2.2:8080/api/";
    private static UserClient userClient;
    private static SessionClient sessionClient;
    private static PhotowalkApiService photoWalk;
    private static PhotowalkApiService photowalkApiService;
    private static User currentUser;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        RestClient.token = token;
    }

    private static String token;

    private static Photowalk currentPhotowalk;


    public static void init() {

/*
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();
*/

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        sessionClient = restAdapter.create(SessionClient.class);
        userClient = restAdapter.create(UserClient.class);
        photoWalk = restAdapter.create(PhotowalkApiService.class);

    }


    public static UserClient getUserClient() {
        return userClient;
    }

    public static void setCurrentUser(User usr) {currentUser = usr;}

    public static User getCurrentUser(){return currentUser;}

    public static PhotowalkApiService getPhotoWalk(){ return photoWalk;}

    public static SessionClient getSessionClient() {
        return sessionClient;
    }


    public static PhotowalkApiService getPhotowalkApiService() {
        return photowalkApiService;
    }
}
