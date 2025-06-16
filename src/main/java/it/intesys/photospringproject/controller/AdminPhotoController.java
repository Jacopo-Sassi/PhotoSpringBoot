package it.intesys.photospringproject.controller;
import it.intesys.photospringproject.model.Photo;
import it.intesys.photospringproject.service.PhotoService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class AdminPhotoController {

    private final PhotoService photoService;


    public AdminPhotoController() {
       photoService = new PhotoService();
    }
    @RequestMapping("admin/api/photos")
    public Iterable<Photo> getAll() {

        return photoService.getAll();
    }
    @RequestMapping("admin/api/photos/{id}")
    public Photo getById(@PathVariable int id) {

        Optional<Photo> photo = Optional.ofNullable(photoService.getById(id));
        return photoService.getById(id);
    }
    @PostMapping("admin/api/photos")
    public Photo addPhoto(@RequestBody Photo photo) {
        return photoService.addPhoto(photo);
    }
    @PutMapping("admin/api/photos/{id}")
    public Photo updatePhoto(@PathVariable int id, @RequestBody Photo newPhoto) {
        Optional<Photo> updatedPhoto = Optional.ofNullable(photoService.updatePhoto(id, newPhoto));
        return updatedPhoto.get();
    }
    @DeleteMapping("admin/api/photos/{id}")
    public void deletePhoto(@PathVariable int id) {
        Optional<Photo> photo = photoService.deletePhoto(id);
        if (photo.isEmpty()) {
            throw new RuntimeException("Photo not found with id: " + id);
        }
    }
}
