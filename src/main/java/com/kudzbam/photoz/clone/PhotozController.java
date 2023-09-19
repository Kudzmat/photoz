package com.kudzbam.photoz.clone;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotozController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hell0() {
        return "Hello World";
    }

    // url for getting photos in database
    @GetMapping("/photoz")
    public Collection<Photo> get() {
        // return photos
        return db.values();
    }

    // url for getting a photo by id
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);
        // return photos

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    // url for deleting a photo
    @DeleteMapping("/del-photoz/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = db.remove(id);

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // url for adding a photo, no path variable
    // front end will send a json which will be converted to a photo object
    @PostMapping("/add-photoz/")
    public void add(Photo photo) {
        photo.setFileName();
        db.put(photo.getId(), photo);

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
