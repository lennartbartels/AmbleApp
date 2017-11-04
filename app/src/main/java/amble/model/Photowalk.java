package amble.model;
import android.app.Activity;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import okhttp3.Route;


/**
 * Created by hintzl on 08.10.2017.
 */

public class Photowalk extends Activity{
    @SerializedName("photowalkId")
    private Integer photowalkId;
    @SerializedName("name")
    private String name;
    @SerializedName("duration")
    private Integer duration;
    @SerializedName("date")
    private String date;
    @SerializedName("description")
    private String description;
    @SerializedName("startpoint")
    private String startpoint;
    @SerializedName("endpoint")
    private String endpoint;
    @SerializedName("owner")
    private User owner;
    @SerializedName("route")
    private Route route;

    public Photowalk(String name, /*String date,*/ String startpoint, String endpoint, Integer duration, String description) {
        this.name = name;
       // this.date = date;
        this.startpoint = startpoint;
        this.endpoint = endpoint;
        this.duration = duration;
        this.description = description;

    }

    public Integer getPhotowalkId() {
        return photowalkId;
    }

    public void setPhotowalkId(Integer photowalkId) {
        this.photowalkId = photowalkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
