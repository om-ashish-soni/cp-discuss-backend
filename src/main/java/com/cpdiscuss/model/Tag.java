package com.cpdiscuss.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tags")
@Entity(name = "Tag")
public class Tag {
    @Id
    private String tagId;
    private String tagName;
    // private String tagUrl;
    public String getTagName(){
        return this.tagName;
    }
    public void setTagName(String tagName){
        this.tagName=tagName;
    }
    // public String getTagUrl(){
    //     return this.tagUrl;
    // }
    // public void setTagUrl(String tagUrl){
    //     this.tagUrl=tagUrl;
    // }
}
