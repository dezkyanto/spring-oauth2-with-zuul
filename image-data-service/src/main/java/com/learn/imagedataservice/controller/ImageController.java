package com.learn.imagedataservice.controller;

import com.learn.imagedataservice.entities.Image;
import com.learn.imagedataservice.repositories.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chillyb on 16/01/19.
 */
@RestController
@RequestMapping("/imageData")
public class ImageController {
    private LoggerFactory logInfo;
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageRepository imageRepo;

    @GetMapping("/")
    private String sayHelloFromServer(){
        return "Hello you are accessing to image data server";
    }

    @RequestMapping("/images")
    private List getImages(){
        logger.info("Getting Data from Database");
        List img = new ArrayList<>();
        Iterator imgIter = imageRepo.findAll().iterator();
        while(imgIter.hasNext()){
            img.add(imgIter.next());
        }
        return img;
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    private Image saveImage(@RequestBody Image image){
        logger.info("Saving image Data");
        Image saveImage = imageRepo.save(image);
        return saveImage;
    }

    @RequestMapping(path = "/del/{id}", method = RequestMethod.DELETE)
    private void delImage(@PathVariable("id") Long id){
        imageRepo.deleteById(id);
    }



}
