package it.intesys.photospringproject.controller;

import it.intesys.photospringproject.model.Photo;
import it.intesys.photospringproject.service.PhotoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhotoRestController {

    private final PhotoService photoService;


    public PhotoRestController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/api/photos")
    public Iterable<Photo> getAll() {
        return photoService.getAll();
    }

    @GetMapping("/api/photos/{id}")
    public Photo getById(@PathVariable int id) {
        return photoService.getById(id);
    }
}
