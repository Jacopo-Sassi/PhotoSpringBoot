package it.intesys.photospringproject.controller;

import it.intesys.photospringproject.model.Photo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotoRestController {
    @RequestMapping("/photos")
    public Iterable<Photo> getAll() {
        List <Photo> list = new ArrayList<Photo>();
        list.add(new Photo(1,"./img/27.png"));
        list.add(new Photo(2,"./img/26.png"));
        list.add(new Photo(3,"./img/25.png"));
        return list;
    }
}
