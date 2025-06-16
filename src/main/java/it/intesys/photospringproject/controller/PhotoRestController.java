package it.intesys.photospringproject.controller;

import it.intesys.photospringproject.model.Photo;
import it.intesys.photospringproject.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoRestController {

    private PhotoService photoService;

    public PhotoRestController() {
        PhotoService photoService = new PhotoService();
    }
    @RequestMapping("api/photos")
    public Iterable<Photo> getAll() {

        return photoService.getAll();
    }
    @GetMapping("/api/photos/{id}")
    public Photo getById(@PathVariable int id) {
        return photoService.getById(id);
    }}