package amble.service;

import java.util.List;

import amble.model.Photowalk;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by hintzl on 08.10.2017.
 */

public interface PhotowalkApiService {
    @GET("/walks/")
    Call<List<Photowalk>> getPhotowalks(@Body Photowalk photowalk, @Header("token")String token);

    @GET("/walks/")
    Call<Photowalk> getSinglePW(String name,@Header("token")String token);

    @POST("/createwalk/")
    Call<Void> createWalk(@Body Photowalk photowalk,@Header("token")String token );

}
