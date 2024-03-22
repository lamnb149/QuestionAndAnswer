/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class Vote {
    private int id;
    private int postId;
    private int voteTypeId;
    private int userId;
    private Timestamp creationDate;

    public Vote() {
    }

    public Vote(int id, int postId, int voteTypeId, int userId, Timestamp creationDate) {
        this.id = id;
        this.postId = postId;
        this.voteTypeId = voteTypeId;
        this.userId = userId;
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

    public int getVoteTypeId() {
        return voteTypeId;
    }

    public void setVoteTypeId(int voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    
    
}
