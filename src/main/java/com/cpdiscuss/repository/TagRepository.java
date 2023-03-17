package com.cpdiscuss.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpdiscuss.model.Tag;
@Repository
public interface TagRepository extends MongoRepository<Tag,String>{
    @Query("{ 'tagName' : ?0 }")    
    Tag findByTagName(String tagName);
}
