package models;

import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONArray;

public class Photos {
    Integer page;
    Integer pages;
    Integer perPage;
    String total;
    ArrayList<Photo> data = new ArrayList<Photo>();

    Photos(JSONObject jsonObject){
        page = (Integer)jsonObject.get("page");
        perPage = (Integer)jsonObject.get("perpage");
        pages = (Integer)jsonObject.get("pages");
        total = (String)jsonObject.get("total");
        JSONArray jsonArray = jsonObject.getJSONArray("photo");
        for(Object object: jsonArray){
            data.add(new Photo((JSONObject) object));
        }
    }

    @Override
    public String toString() {
        return "Photos{" +
                "page=" + page +
                ", pages=" + pages +
                ", perPage=" + perPage +
                ", total='" + total + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public ArrayList<Photo> getData() {
        return data;
    }

    public void setData(ArrayList<Photo> data) {
        this.data = data;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPages() {
        return pages;
    }

    public String getTotal() {
        return total;
    }
}
