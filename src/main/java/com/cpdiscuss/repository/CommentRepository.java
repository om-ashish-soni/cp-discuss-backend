package com.cpdiscuss.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.cpdiscuss.model.Comment;
@Repository
public interface CommentRepository extends MongoRepository<Comment,String>{
    
}
