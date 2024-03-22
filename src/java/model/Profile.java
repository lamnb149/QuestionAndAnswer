
package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Profile {
    private int id;
    private Timestamp createDate;
    private String displayName;
    private Timestamp lastAccessDate;
    private String location;
    private String profileImage;
    private String aboutMe;
    private String websiteUrl;
    private boolean gender;
    private Timestamp dob;
    private String fullName;
    private String phoneNumber;
    private int groupId;
    private String username;
    private String password;
    private int role;
    private String background;
    private Boolean isBaned;

    public Profile() {
    }

    public Profile(int id, Timestamp createDate, String displayName, Timestamp lastAccessDate, String location, String profileImage, String aboutMe, String websiteUrl, boolean gender, Timestamp dob, String fullName, String phoneNumber, int groupId, String username, String password, int role, String background, Boolean isBaned) {
        this.id = id;
        this.createDate = createDate;
        this.displayName = displayName;
        this.lastAccessDate = lastAccessDate;
        this.location = location;
        this.profileImage = profileImage;
        this.aboutMe = aboutMe;
        this.websiteUrl = websiteUrl;
        this.gender = gender;
        this.dob = dob;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.groupId = groupId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.background = background;
        this.isBaned = isBaned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Timestamp getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Timestamp lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Boolean getIsBaned() {
        return isBaned;
    }

    public void setIsBaned(Boolean isBaned) {
        this.isBaned = isBaned;
    }

    

    @Override
    public String toString() {
        return "Profile{" + "displayName=" + displayName + ", profileImage=" + profileImage + ", aboutMe=" + aboutMe + ", fullName=" + fullName + ", username=" + username + ", password=" + password + '}';
    }
    
}
