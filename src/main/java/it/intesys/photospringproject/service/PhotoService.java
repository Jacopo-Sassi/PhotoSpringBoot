package it.intesys.photospringproject.service;

import it.intesys.photospringproject.model.Photo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    private static List<Photo> list;


    public PhotoService() {
        list = new ArrayList<Photo>();
        list.add(new Photo(1,"./img/01.png"));
        list.add(new Photo(2,"./img/02.png"));
        list.add(new Photo(3,"./img/03.png"));

    }

    public Iterable<Photo> getAll() {

        return list;
    }

    public Photo getById( int id) {

        Optional<Photo> photo = list.stream().filter(p -> p.getId() == id).findFirst();
        return photo.orElseThrow(() -> new RuntimeException("Photo not found with id: " + id));
    }

    public Photo addPhoto(Photo photo) {
        if (photo.getId() == 0) {
            photo.setId(list.size() + 1);
        }
        list.add(photo);
        return photo;
    }
    public Photo updatePhoto(int id, Photo newPhoto) {
        Optional<Photo> existingPhoto = list.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (existingPhoto.isPresent()) {
            list.remove(existingPhoto.get());
            list.add(newPhoto);
            return newPhoto;
        } else {
            throw new RuntimeException("Photo not found with id: " + id);
        }
    }
    public Optional<Photo> deletePhoto(int id) {
        Optional<Photo> photo = list.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (photo.isPresent()) {
            list.remove(photo.get());
        }
        return photo;
    }
}
