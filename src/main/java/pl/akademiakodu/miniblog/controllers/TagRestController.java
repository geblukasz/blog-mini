package pl.akademiakodu.miniblog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.miniblog.model.entities.Tag;

@RestController
public class TagRestController {

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseEntity<Tag> createTag(@RequestParam String tagName){
        Tag tag = new Tag();
        tag.setTagName(tagName);

    }
}
