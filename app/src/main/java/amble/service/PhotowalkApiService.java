package amble.service;

import java.util.List;

import amble.model.Photowalk;
import amble.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by hintzl on 08.10.2017.
 */

public interface PhotowalkApiService {
    @GET("photowalks/{name}")
    Call<Photowalk> getPhotoWalkByName(@Path("name")String name);

    @POST("photowalks")
    Call<Void> createPhotoWalk(@Body Photowalk photowalk);

    @GET("photowalks")
    Call<List<Photowalk>> getPhotoWalks();

    @GET("photowalks/{name}/applicants")
    Call<List<Photowalk>> getApplicants(@Path("name")String name);

    @POST("photowalks/{name}/applicants")
    Call<Void> addApplicant(@Path("name")String name);
}
