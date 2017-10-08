package amble.service;

import amble.model.Photowalk;
import amble.model.PhotowalkResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hintzl on 08.10.2017.
 */

public interface PhotowalkApiService {
    @GET("/walks/")
    Call<PhotowalkResponse>
}
