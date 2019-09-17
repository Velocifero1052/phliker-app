package models;
import org.json.JSONObject;

public class Photo {
    String id;
    String owner;
    String secret;
    String server;
    Integer farm;
    String title;
    Integer isPublic;
    Integer isFriend;
    Integer isFamily;

    Photo(JSONObject jsonObject){
        id = (String)jsonObject.get("id");
        owner = (String)jsonObject.get("owner");
        secret = (String)jsonObject.get("secret");
        server = (String)jsonObject.get("server");
        farm = (Integer)jsonObject.get("farm");
        title = (String)jsonObject.get("title");
        isPublic = (Integer)jsonObject.get("ispublic");
        isFriend = (Integer)jsonObject.get("isfriend");
        isFamily = (Integer)jsonObject.get("isfamily");
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", secret='" + secret + '\'' +
                ", server='" + server + '\'' +
                ", farm=" + farm +
                ", title='" + title + '\'' +
                ", isPublic=" + isPublic +
                ", isFriend=" + isFriend +
                ", isFamily=" + isFamily +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublic() {
        return isPublic;
    }

    public void setPublic(Integer aPublic) {
        isPublic = aPublic;
    }

    public Integer getFriend() {
        return isFriend;
    }

    public void setFriend(Integer friend) {
        isFriend = friend;
    }

    public Integer getFamily() {
        return isFamily;
    }

    public void setFamily(Integer family) {
        isFamily = family;
    }
}
