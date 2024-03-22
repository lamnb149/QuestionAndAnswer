
package model;

import java.sql.Timestamp;


public class PostFeedBack {
    private int id;
    private int postId;
    private boolean isAnonymous;
    private String feedBack;
    private Timestamp creationDate;

    public PostFeedBack() {
    }

    public PostFeedBack(int id, int postId, boolean isAnonymous, String feedBack, Timestamp creationDate) {
        this.id = id;
        this.postId = postId;
        this.isAnonymous = isAnonymous;
        this.feedBack = feedBack;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public boolean isIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
    
    
}
