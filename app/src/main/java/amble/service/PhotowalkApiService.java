package amble.service;

import java.util.List;

import amble.model.Photowalk;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by hintzl on 08.10.2017.
 */

public interface PhotowalkApiService {
    @GET("photowalks")
    Call<List<Photowalk>> getPhotowalks( @Header("token")String token);

   /* @GET("/api/photowalks/")
    Call<List<Photowalk>> getPhotowalks();*/

    @GET("/api/photowalks/")
    Call<Photowalk> getSinglePW(String name,@Header("token")String token);

    @POST("photowalks/")
    Call<Void> createWalk(@Body Photowalk photowalk,@Header("token")String token );
   // RequestBody photowalk = RequestBody.create(MediaType.parse("/createwalk"), photowalk.toString());

}
