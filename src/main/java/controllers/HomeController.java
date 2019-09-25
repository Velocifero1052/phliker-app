package controllers;


import models.SearchText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;;
import models.Resp;
import models.Photos;
import models.Photo;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Controller
public class HomeController {

    private int mPageNumber = 1;
    String searched = new String();
    List<String> urls = new ArrayList<String>(100);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchSubmit(@RequestParam(value = "text", required = false) String text, @RequestParam(value = "next", required = false) Boolean next, Model model) {
        model.addAttribute("searchText", new SearchText());
        model.addAttribute("curPage", mPageNumber);

        if (text == null) {
            return "home";
        }

        if(!searched.equals(text)){
            mPageNumber = 1;
            searched = text;
            urls.clear();
        }

        System.out.println(text);

        String searchUrl = new String(String.format("https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=8c3a08d2ae655faaaa9e19146ec0985d&text={SEARCH_TEXT}&format=json&page=%d", mPageNumber));
        mPageNumber++;
        searchUrl = searchUrl.replace("{SEARCH_TEXT}", text);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(searchUrl, String.class);

        model.addAttribute("searching", text);

        response = response.substring(14, response.length() - 1);

        JSONObject jsonObject = new JSONObject(response);
        Resp resp = new Resp(jsonObject);
        model.addAttribute("total", resp.getPhotos().getTotal());

        Photos photos = resp.getPhotos();
        ArrayList<Photo> photoArray = photos.getData();
        String imageUrl = new String("https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg");

        for (int i = 0; i < photoArray.size(); i++) {
            urls.add(imageUrl.replace("{farm-id}", Integer.toString(photoArray.get(i).getFarm()))
                    .replace("{server-id}", photoArray.get(i).getServer())
                    .replace("{id}", photoArray.get(i).getId())
                    .replace("{secret}", photoArray.get(i).getSecret()));
        }

        ArrayList<ArrayList<String>> issued = new ArrayList<ArrayList<String>>(13); // 100 / 8

        for (int i = 0; i < urls.size(); ) {
            issued.add(new ArrayList<String>(urls.subList(i, Math.min(i + 8, urls.size()))));
            i = Math.min(i + 9, urls.size());
        }

        model.addAttribute("photoList", issued);

        return "home";
    }


}
