package amble.service;

import java.util.List;

import amble.model.Photowalk;
import amble.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by hintzl on 08.10.2017.
 */

public interface PhotowalkApiService {
    @GET("walks/{name}")
    Call<List<Photowalk>> getPhotoWalkByName(@Path("name")String name);

    @POST("walks")
    Call<Void> createPhotoWalk(@Body Photowalk photowalk);


}
