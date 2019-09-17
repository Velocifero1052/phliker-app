package com.example.demo;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.IFlickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.Response;
import com.flickr4java.flickr.galleries.GalleriesInterface;
import com.flickr4java.flickr.photos.Photocount;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;

import org.json.XML;
import org.json.JSONObject;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
class Some{

}



@SpringBootApplication
@ComponentScan({"controllers"})
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class);




        //log.info(quote.toString());
    }

}

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.client.RestTemplate;
//
//
//
//public class DemoApplication{
//    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
//
//    public static void main(String args[]) {
//        RestTemplate restTemplate = new RestTemplate();
//        Quote quote = restTemplate.getForObject(
//                "https://gturnquist-quoters.cfapps.io/api/random"
//                , Quote.class);
//        log.info(quote.toString());
//
//
//    }
//}