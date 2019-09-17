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

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String searchSubmit(Model model){
        model.addAttribute("searchText", new SearchText());

        return "home";
    }
    @RequestMapping(value = "/jquery", method = RequestMethod.GET)
    public String fuckYou(){
        return "index";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home(@ModelAttribute SearchText searchText, Model model) throws Exception{

        RestTemplate restTemplate = new RestTemplate();
        String text = searchText.getText();
        text = text.replace(' ', '+');

        String searchUrl = new String("https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=8c3a08d2ae655faaaa9e19146ec0985d&text={SEARCH_TEXT}&format=json&perpage=24");
        searchUrl = searchUrl.replace("{SEARCH_TEXT}", text);

        String response = restTemplate.getForObject(searchUrl, String.class);

        response = response.substring(14, response.length() - 1);

        JSONObject jsonObject = new JSONObject(response);
        Resp resp = new Resp(jsonObject);
        model.addAttribute("total", resp.getPhotos().getTotal());

        Photos photos = resp.getPhotos();
        ArrayList<Photo> photoArray = photos.getData();
        List<String> urls = new ArrayList<String>(100);
        String imageUrl = new String("https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg");

        for(int i = 0; i < photoArray.size(); i++) {
            urls.add(imageUrl.replace("{farm-id}", Integer.toString(photoArray.get(i).getFarm()))
                    .replace("{server-id}",photoArray.get(i).getServer())
                    .replace("{id}", photoArray.get(i).getId())
                    .replace("{secret}", photoArray.get(i).getSecret()));
        }

        ArrayList<ArrayList<String>> issued = new ArrayList<ArrayList<String>>(13); // 100 / 8

        for(int i = 0; i < urls.size();){
            issued.add(new ArrayList<String>(urls.subList(i, Math.min(i + 8, urls.size()))));
            i = Math.min(i + 9, urls.size());
        }


        model.addAttribute("photoList",issued);


        return "home";

    }

}
