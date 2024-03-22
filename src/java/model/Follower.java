
package model;

import java.sql.Timestamp;

public class Follower {
    private int userId;
    private int followerId;
    private Timestamp createDate;

    public Follower() {
    }

    public Follower(int userId, int followerId, Timestamp createDate) {
        this.userId = userId;
        this.followerId = followerId;
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    

    
    
    
}
