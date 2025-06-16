package it.intesys.photospringproject.controller;

import it.intesys.photospringproject.model.Photo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminPhotoController {

    private List<Photo> list;


    public AdminPhotoController() {
        list = new ArrayList<Photo>();
        list.add(new Photo(1,"./img/01.png"));
        list.add(new Photo(2,"./img/02.png"));
        list.add(new Photo(3,"./img/03.png"));

    }
    @RequestMapping("admin/api/photos")
    public Iterable<Photo> getAll() {

        return list;
    }
    @RequestMapping("admin/api/photos/{id}")
    public Photo getById(@PathVariable int id) {

        Optional<Photo> photo = list.stream().filter(p -> p.getId() == id).findFirst();
        return photo.orElseThrow(() -> new RuntimeException("Photo not found with id: " + id));
    }
    @PostMapping("admin/api/photos")
    public Photo addPhoto(Photo photo) {
        if (photo.getId() == 0) {
            photo.setId(list.size() + 1);
        }
        list.add(photo);
        return photo;
    }
}
