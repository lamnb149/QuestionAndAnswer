
package model;

public class ProfileGroup {
    private int userId;
    private int groupId;
    private boolean isOwnerUser;

    public ProfileGroup() {
    }

    public ProfileGroup(int userId, int groupId, boolean isOwnerUser) {
        this.userId = userId;
        this.groupId = groupId;
        this.isOwnerUser = isOwnerUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean getIsOwnerUser() {
        return isOwnerUser;
    }

    public void setIsOwnerUser(boolean isOwnerUser) {
        this.isOwnerUser = isOwnerUser;
    }
    
    
}
