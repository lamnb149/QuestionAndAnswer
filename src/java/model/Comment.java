
package model;

import java.sql.Timestamp;

public class Comment {
    private int id;
    private int postId;
    private String text;
    private Timestamp creationDate;
    private int userId;
    private int parentId;

    public Comment() {
    }

    public Comment(int id, int postId, String text, Timestamp creationDate, int userId, int parentId) {
        this.id = id;
        this.postId = postId;
        this.text = text;
        this.creationDate = creationDate;
        this.userId = userId;
        this.parentId = parentId;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", postId=" + postId + ", text=" + text + ", userId=" + userId + ", parentId=" + parentId + '}';
    }

}
