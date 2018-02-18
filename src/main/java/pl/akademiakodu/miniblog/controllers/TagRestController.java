package pl.akademiakodu.miniblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.miniblog.model.entities.Tag;
import pl.akademiakodu.miniblog.model.repositories.TagRepository;

@RestController
public class TagRestController {

    @Autowired
    TagRepository tagRepository;


    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseEntity<Tag> createTag(@RequestParam String tagName){
        Tag tag = new Tag();
        tag.setTagName(tagName);

        tagRepository.save(tag);

        return ResponseEntity
                .ok()
                .body(tag);
    }
}
