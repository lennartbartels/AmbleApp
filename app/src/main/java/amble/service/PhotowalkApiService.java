package amble.service;

import java.util.List;

import amble.model.Photowalk;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by hintzl on 08.10.2017.
 */

public interface PhotowalkApiService {
    @GET("/walks/")
    Call<List<Photowalk>> getPhotowalks(@Body Photowalk photowalk);

    Call<List<Photowalk>> getPhotowalks();
}
