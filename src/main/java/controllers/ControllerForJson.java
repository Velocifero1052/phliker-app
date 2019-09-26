package controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerForJson {

    private int mPageNumber = 2;
    private String searched = new String();

    @RequestMapping(value = "/nextPage")
    public String nextPageReturn(){
        return new String(String.format("{\"page\":%d}", mPageNumber));
    }

    @RequestMapping(value = "/ajax")
    public String ajaxReturn(@RequestParam(value = "text", required = false) String text){
        if(!searched.equals(text)) {
            mPageNumber = 2;
            searched = text;
        }
        String searchUrl = new String(String.format("https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=8c3a08d2ae655faaaa9e19146ec0985d&text={SEARCH_TEXT}&format=json&page=%d", mPageNumber));
        mPageNumber++;
        searchUrl = searchUrl.replace("{SEARCH_TEXT}", text);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(searchUrl, String.class);

        response = response.substring(14, response.length() - 1);

        return response;
    }
}
