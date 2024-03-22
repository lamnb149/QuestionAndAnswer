
package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Post {
    private int id;
    private int postTypeId;
    private int acceptedAnswerId;
    private Timestamp creationDate;
    private Timestamp deletionDate;
    private String body;
    private int ownerUserId;
    private Timestamp lastEditDate;
    private String title;
    private String tags;
    private int commentCount;
    private Timestamp closedDate;
    private int parentId;
    private int groupId;

    public Post() {
    }

    public Post(int id, int postTypeId, int acceptedAnswerId, Timestamp creationDate, Timestamp deletionDate, String body, int ownerUserId, Timestamp lastEditDate, String title, String tags, int commentCount, Timestamp closedDate, int parentId, int groupId) {
        this.id = id;
        this.postTypeId = postTypeId;
        this.acceptedAnswerId = acceptedAnswerId;
        this.creationDate = creationDate;
        this.deletionDate = deletionDate;
        this.body = body;
        this.ownerUserId = ownerUserId;
        this.lastEditDate = lastEditDate;
        this.title = title;
        this.tags = tags;
        this.commentCount = commentCount;
        this.closedDate = closedDate;
        this.parentId = parentId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(int postTypeId) {
        this.postTypeId = postTypeId;
    }

    public int getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(int acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(Timestamp deletionDate) {
        this.deletionDate = deletionDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(int ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Timestamp lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Timestamp getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Timestamp closedDate) {
        this.closedDate = closedDate;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    
    
}
