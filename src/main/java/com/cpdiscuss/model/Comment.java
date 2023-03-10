package com.cpdiscuss.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Entity(name = "Comment")
public class Comment {
    @Id
    private String commentId;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private String creatorName;
    private Long likes;

    private List<Comment> comments;
    private void init(){
        this.createdAt=new Date();
        this.updatedAt=new Date();
        this.likes=0L;
        this.comments=new ArrayList<Comment>();
    }
    public Comment(){
        this.init();
    }
    public Comment(String content) {
        this.content=content;
        this.init();
    }
    public String getCommentId(){
        return this.commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId=commentId;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content=content;
    }
    public List<Comment> getComments(){
        return this.comments;
    }
    public void addComment(Comment subComment){
        this.comments.add(subComment);
    }
    public Long getLikes(){
        return this.likes;
    }
    public void setLikes(Long likes){
        this.likes=likes;
    }
    public Date getCreatedAt(){
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt=createdAt;
    }
    public Date getUpdatedAt(){
        return this.updatedAt;
    }
    public void setUpdatedAt(Date updatedAt){
        this.updatedAt=updatedAt;
    }
    public void setCreatorName(String creatorName){
        this.creatorName=creatorName;
    }
    public String getCreatorName(){
        return this.creatorName;
    }
}
