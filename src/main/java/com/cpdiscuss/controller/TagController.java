package com.cpdiscuss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpdiscuss.model.Tag;
import com.cpdiscuss.repository.TagRepository;

@RestController()
@CrossOrigin(origins = "*")
public class TagController {
    @Autowired
    private TagRepository tagRepository;
    
    @GetMapping("/tags")
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    @PostMapping("/tags/create")
    public void addTag(@RequestBody Tag tag){
        if(tag.getClass() == null) return;
        Tag existingTag=tagRepository.findByTagName(tag.getTagName());
        if(existingTag != null){
            
        }else{
            tagRepository.save(tag);
        }
    }
}
