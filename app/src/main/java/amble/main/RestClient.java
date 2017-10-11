package amble.main;

import amble.model.Photowalk;
import amble.model.User;
import amble.service.PhotowalkApiService;
import amble.service.UserClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hintzl on 08.10.2017.
 */

public class RestClient {
    private static String baseUrl = "http://10.0.2.2:8080/api/";
    private static UserClient userClient;
    private static PhotowalkApiService photoWalk;
    private static User currentUser;
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

        userClient = restAdapter.create(UserClient.class);
        photoWalk = restAdapter.create(PhotowalkApiService.class);

    }

    public static UserClient getUserClient() {
        return userClient;
    }

    public static void setCurrentUser(User usr) {currentUser = usr;}

    public static User getCurrentUser(){return currentUser;}

    public static PhotowalkApiService getPhotoWalk(){ return photoWalk;}

    public static void setCurrentPhotowalk(Photowalk phtwlk) {currentPhotowalk = phtwlk;}

}
