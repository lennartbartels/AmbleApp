package amble.service;



import amble.model.Credentials;
import amble.model.SessionDto;
import amble.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lilien on 22.10.2017.
 */

public interface SessionClient {



        @POST("sessions")
        Call <SessionDto> login (@Body Credentials credentials );

        @DELETE("sessions/{session}")
        Call <Void> logout (@Path("session")String session);
    }

