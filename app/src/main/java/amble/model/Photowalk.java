package amble.model;
import android.app.Activity;

import java.util.Date;

import com.google.gson.annotations.SerializedName;


/**
 * Created by hintzl on 08.10.2017.
 */

public class Photowalk {

    private Integer photowalkId;
    private String name;
    private Integer duration;
  //  private Date date;
    private String description;
    private String startpoint;
    private String endpoint;


      public Photowalk(String name, Integer duration, String description, String startpoint, String endpoint) {
        this.name = name;
        this.duration = duration;
        //this.date = date;
        this.description = description;
        this.startpoint = startpoint;
        this.endpoint = endpoint;

    }


    public String getPhotoWalk() {
        return name;}

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

   // public Date getDate() {return date;    }

    //public void setDate(Date date) {this.date = date;    }

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

    //public User getOwner() {return owner;   }

    //public void setOwner(User owner) {this.owner = owner;
    }

