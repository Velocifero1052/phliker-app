package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resp {
    String status;
    Photos photos;

    public Resp(JSONObject jsonObject){
        status = (String)jsonObject.get("stat");
        photos = new Photos((JSONObject) jsonObject.get("photos"));
    }


    public Photos getPhotos() {
        return photos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "status=" + status +
                ", photos=" + photos +
                '}';
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
