package com.cpdiscuss.controller;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpdiscuss.model.Article;
import com.cpdiscuss.model.Comment;
import com.cpdiscuss.repository.CommentRepository;

@RestController()
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired ArticleController articleController;
    public CommentController(){
        
    }
    
    @PostMapping("/comments/ofarticle/create/{articleName}")
    public Article commentOnArticle(@PathVariable String articleName,@RequestBody Comment comment) {
        commentRepository.save(comment);
        return articleController.commentArticle(articleName,comment);
    }
    @PostMapping("/comments/ofcomment/create/{commentId}")
    public Comment commentOnComment(@PathVariable String commentId,@RequestBody Comment comment) {
        
        Optional<Comment> parentCommentWrapper=commentRepository.findById(commentId);
        if(parentCommentWrapper.isEmpty()){
            return parentCommentWrapper.get();
        }
        Comment parentComment=parentCommentWrapper.get();
        commentRepository.save(comment);
        parentComment.addComment(comment);
        commentRepository.save(parentComment);
        return parentComment;
    }
    @GetMapping("/comments/get/{commentId}")
    public Comment getComment(@PathVariable String commentId){
        return commentRepository.findById(commentId).get();
    }
}
