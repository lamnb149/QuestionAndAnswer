
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import model.Comment;
import model.Follower;
import model.Group;
import model.Post;
import model.PostFeedBack;
import model.PostTag;
import model.Profile;
import model.ProfileGroup;
import model.Tag;
import model.Vote;

public class DAO {
    public static DAO INSTANCE = new DAO();
    private Connection con;
    private String status;
    private List<Post> postList;
    private List<Comment> commentList;
    private List<Profile> profileList;
    private List<Follower> followerList;
    private List<Vote> voteList;
    private List<Tag> tagList;
    private List<PostTag> postTagList;
    private List<Group> groupList;
    private List<ProfileGroup> profileGroupList;
    private List<PostFeedBack> postFeedBackList;
    
    private DAO() {
        if (INSTANCE == null) {
            try {
                con = new DBContext().getConnection();
            } catch (Exception e) {
                status = "Error at connection" + e.getMessage();
            }
        } 
    }
    
    public void getAll() {
        String sql = "SELECT * FROM Posts_HE170781 ORDER BY CreationDate DESC";
        postList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                postList.add(new Post(
                        rs.getInt(1), // id
                        rs.getInt(2), // postTypeId
                        rs.getInt(3), // acceptedAnswerId
                        rs.getTimestamp(4), // creationDate
                        rs.getTimestamp(5), // deletionDate
                        rs.getString(6), // body
                        rs.getInt(7), // ownerUserId
                        rs.getTimestamp(8), // lastEditDate
                        rs.getString(9), // title
                        rs.getString(10), // tags
                        rs.getInt(11), // commentCount
                        rs.getTimestamp(12), // closedDate
                        rs.getInt(13), // parentId
                        rs.getInt(14) // groupId     
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Post" + e.getMessage();
        }
        sql = "SELECT * FROM Comments_HE170781";
        commentList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                commentList.add(new Comment(
                        rs.getInt(1), // id
                        rs.getInt(2), // postId
                        rs.getString(3), // text
                        rs.getTimestamp(4), // creationDate
                        rs.getInt(5), // userId
                        rs.getInt(6) // parentId
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Comment" + e.getMessage();
        }

        sql = "SELECT * FROM Profiles_HE170781";
        profileList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                profileList.add(new Profile(
                        rs.getInt(1), // id
                        rs.getTimestamp(2), // create
                        rs.getString(3), // displayname
                        rs.getTimestamp(4), // last access
                        rs.getString(5), // location
                        rs.getString(6), // profileimg
                        rs.getString(7), // about me
                        rs.getString(8), // website url
                        rs.getBoolean(9), // gender
                        rs.getTimestamp(10), // dob
                        rs.getString(11), // full name
                        rs.getString(12), // phone number
                        rs.getInt(13), // groupid
                        rs.getString(14), //username 
                        rs.getString(15),  // password
                        rs.getInt(16), // role
                        rs.getString(17), // background
                        rs.getBoolean(18)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Profile User";
        }
        
        sql = "SELECT * FROM Followers_HE170781";
        followerList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                followerList.add(new Follower(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getTimestamp(3)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Follower";
        }
        
        sql = "SELECT * FROM Votes_HE170781";
        voteList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                voteList.add(new Vote(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getTimestamp(5)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Votes";
        }
        
        sql = "SELECT * FROM Tags_HE170781";
        tagList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tagList.add(new Tag(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Tag " + e.getMessage();
        }
        
        sql = "SELECT * FROM PostTags_HE170781";
        postTagList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                postTagList.add(new PostTag(
                        rs.getInt(1),
                        rs.getInt(2)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Post Tag " + e.getMessage();
        }
        
        sql = "SELECT * FROM Groups_HE170781";
        groupList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                groupList.add(new Group(
                        rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Group List " + e.getMessage();
        }
        
        sql = "SELECT * FROM ProfileGroups_HE170781";
        profileGroupList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                profileGroupList.add(new ProfileGroup(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getBoolean(3)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Profile Group List " + e.getMessage();
        }
        
        sql = "SELECT * FROM PostFeedBacks_HE170781";
        postFeedBackList = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                postFeedBackList.add(new PostFeedBack(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getTimestamp(5)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at load Post Feedback List " + e.getMessage();
        }
    }
    
    public Profile getProfileById(int id) {
        for (Profile p : profileList) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    
    public Post getPostById(int id) {
        for (Post po : postList) {
            if (po.getId() == id) return po;
        }
        return null;
    }
    
    public void addProfile(String fullname, boolean gender, String username, String password, int role) {
        String sql = "INSERT INTO [dbo].[Profiles_HE170781]\n"
                + "           ([CreateDate]\n"
                + "           ,[Gender]\n"
                + "           ,[FullName]\n"
                + "           ,[Username]\n"
                + "           ,[Password]\n"
                + "           ,[Role]\n"
                + "           ,[isBaned])\n"
                + "     VALUES\n"
                + "           (GETDATE(), ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, gender);
            ps.setString(2, fullname);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setInt(5, role);
            ps.setBoolean(6, false);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at add Profile" + e.getMessage();
        }
        System.out.println("status = " + status);
    }
    
    public void addPost(int postType, String body, int ownerUserId, String title, int parentId, int groupId) {
        String sql = "INSERT INTO [dbo].[Posts_HE170781]\n"
                + "           ([PostTypeId]\n"
                + "           ,[CreationDate]\n"
                + "           ,[Body]\n"
                + "           ,[OwnerUserId]\n"
                + "           ,[Title]\n"
                + "           ,[ParentId]\n"
                + "           ,[GroupId])\n"
                + "     VALUES\n"
                + "           (?, GETDATE(), ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postType);
            ps.setString(2, body);
            ps.setInt(3, ownerUserId);
            ps.setString(4, title);
            ps.setInt(5, parentId);
            ps.setInt(6, groupId);
            ps.executeQuery();
        } catch (Exception e) {
            status = "Error at insert post" + e.getMessage();
        }
        System.out.println(status);
    }
    
    public void addComment(int postId, String text, int userId, int parentId) {
        String sql = "INSERT INTO [dbo].[Comments_HE170781]\n"
                + "           ([PostId]\n"
                + "           ,[Text]\n"
                + "           ,[CreationDate]\n"
                + "           ,[UserId]\n"
                + "           ,[ParentId])\n"
                + "     VALUES\n"
                + "           (?, ?, GETDATE(), ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postId);
            ps.setString(2, text);
            ps.setInt(3, userId);
            ps.setInt(4, parentId);
            ps.executeQuery();
        } catch (Exception e) {
            status = "Error at add comment" + e.getMessage();
        }
    }
    
    public void updateProfile(int id, String displayName, String location, String aboutMe, boolean gender, String dob, String phoneNumber, String fullName) {
        String sql = "UPDATE [dbo].[Profiles_HE170781]\n"
                + "   SET \n"
                + "      [DisplayName] = ?\n"
                + "      ,[Location] = ?\n"
                + "      ,[AboutMe] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[DoB] = ?\n"
                + "      ,[FullName] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, displayName);
            ps.setString(2, location);
            ps.setString(3, aboutMe);
            ps.setBoolean(4, gender);
            ps.setString(5, dob);
            ps.setString(6, phoneNumber);
            ps.setString(7, fullName);
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Erorr at update profile " + e.getMessage();
        }
    }
    
    public void updateProfileImg(int id, String urlImg, boolean flag) {
        String sql = "";
        if (flag) {
            sql = "UPDATE [dbo].[Profiles_HE170781]\n"
                    + "   SET \n"
                    + "      [ProfileImageUrl] = ?\n"
                    + " WHERE id = ?";
        } else {
            sql = "UPDATE [dbo].[Profiles]\n"
                    + "   SET \n"
                    + "      [Background] = ?\n"
                    + " WHERE id = ?";
        }
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, urlImg);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at update Img " + e.getMessage();
        }

    }
    
    public void updatePost(int postId, String title, String body) {
        String sql = "UPDATE [dbo].[Posts_HE170781]\n"
                + "   SET \n"
                + "      [Body] = ?\n"
                + "      ,[Title] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, body);
            ps.setString(2, title);
            ps.setInt(3, postId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at update post" + e.getMessage();
        }
    }
    
    public void updateAField(int postId, String nameField, int value) {
        String sql = "UPDATE [dbo].[Posts_HE170781]\n"
                + "SET " + nameField + " = ?"
                + " WHERE id = ?";
        LocalDateTime currentTime = LocalDateTime.now(); 
        Timestamp currentTimestamp = Timestamp.valueOf(currentTime);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            if (nameField.equals("DeletionDate")) {
                ps.setTimestamp(1, currentTimestamp);
            }
            if (nameField.equals("AcceptedAnswerId")) {
                ps.setInt(1, value);
            } 
            if (nameField.equals("LastEditDate")) {
                ps.setTimestamp(1, currentTimestamp);
            }
            if (nameField.equals("CommentCount")) {
                ps.setInt(1, value);
            } 
            if (nameField.equals("ClosedDate")) {
                ps.setTimestamp(1, currentTimestamp);
            }
            ps.setInt(2, postId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at update A Field" + e.getMessage();
        }
        System.out.println(status);
    }
    
    public void deleteComment(int cmtId) {
        String sql = "DELETE FROM [dbo].[Comments_HE170781]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cmtId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at delete " + e.getMessage();
        }
    }

    public void addVote(int postId, int voteTypeId, int userId) {
        String sql = "INSERT INTO [dbo].[Votes_HE170781]\n"
                + "           ([PostId]\n"
                + "           ,[VoteTypeId]\n"
                + "           ,[UserId]\n"
                + "           ,[CreationDate])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, GETDATE())";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, postId);
            ps.setInt(2, voteTypeId);
            ps.setInt(3, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Erorr at insert vote" + e.getMessage();
        }
    }
    
    public void deleteVote(int idVote, int voteTypeId, int userId) {
        String sql = "DELETE FROM [dbo].[Votes_HE170781]\n"
                + "      WHERE id = ? AND voteTypeId = ? AND userId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVote);
            ps.setInt(2, voteTypeId);
            ps.setInt(3, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at delete vote" + e.getMessage();
        }
    }
    
    public boolean isVote(int userVote, int postVote, int voteType) {
        for (Vote v : voteList) {
            if (v.getUserId() == userVote && v.getPostId() == postVote && v.getVoteTypeId() == voteType) {
                return true;
            }
        }
        return false;
    }
    
    public Vote getVoteByAll(int userVote, int postVote, int voteType) {
        for (Vote v : voteList) {
            if (v.getUserId() == userVote && v.getPostId() == postVote && v.getVoteTypeId() == voteType) {
                return v;
            }
        }
        return null;
    }
    
    
    public int getActionVoteUser(int userVote, int postVote) {
        int action = 0;
        for (Vote v : voteList) {
            if (v.getUserId() == userVote && v.getPostId() == postVote && v.getVoteTypeId() == 1) {
                action = 1;
                break;
            } else if (v.getUserId() == userVote && v.getPostId() == postVote && v.getVoteTypeId() == 2) {
                action = 2;
                break;
            }
        }
        return action;
    }
    
    public List<Post> searchPost(String text) {
        List<Post> listPostSearch = new Vector<>();
        for (Post post : postList) {
            if (post.getTitle().toLowerCase().contains(text.toLowerCase())) {
                listPostSearch.add(post);
            }
        }
        return listPostSearch;
    }
    
    public List<Profile> searchProfile(String text) {
        List<Profile> listProfileSearch = new Vector<>();
        for (Profile profile : profileList) {
            if (profile.getDisplayName().toLowerCase().contains(text.toLowerCase())) {
                listProfileSearch.add(profile);
            }
        }
        return listProfileSearch;
    }
    
    // search group
    
    public String getNameTagById(int id) {
        for (Tag tag : tagList) {
            if (tag.getId() == id) {
                return tag.getTagName();
            }
        }
        return null;
    }
    
    public void addTag(int postId, int tagId) {
        String sql = "INSERT INTO [dbo].[PostTags_HE170781]\n"
                + "           ([PostId]\n"
                + "           ,[TagId])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postId);
            ps.setInt(2, tagId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at add tag" + e.getMessage() ;
        }
    }
    
    public void removePostTag(int postId, int tagId) {
        String sql = "DELETE FROM [dbo].[PostTags_HE170781]\n"
                + "      WHERE postId = ? AND tagId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postId);
            ps.setInt(2, tagId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at remove tag" + e.getMessage();
        }
    }

    // make commment
    // BUILD NESTED COMMENT
    public String[] getNestedComment(Profile userCur, int parentId) {
        String[] nestedComment = new String[10000];
        for (Post p : DAO.INSTANCE.getPostList()) {
            if ((p.getPostTypeId() == 3 || p.getPostTypeId() == 2) && p.getParentId() == parentId && p.getGroupId() == 1) {
                List<Comment> cmtPostId = DAO.INSTANCE.commentOfPostId(p.getId());
                nestedComment[p.getId()] = DAO.INSTANCE.makeComment(0, cmtPostId, userCur);
            }
        }
        return nestedComment;
    }
    
    public String makeComment(int pid, List<Comment> cmtPostId, Profile userCur) {
        int count = 0;
        
        for (Comment cmt : cmtPostId) {
            if (pid == cmt.getParentId()) {
                count++;
            }
        }
        
        if (count == 0) return "";
        String s = "<ul>";
        for (Comment cmt : cmtPostId) {
            if (cmt.getParentId() == pid) {
                s += "<li class='comment-under-post'>";
                s += "<form action='/SocialNetwork/Home?cmtId=" + cmt.getId() + "' method='post' class='editComment'><input type='submit' name='btnDelCmt' value='DELETE'></form>";
                s += "<form action='/SocialNetwork/Home?cmtId=" + cmt.getId() + "' method='post' class='editComment'><input type='submit' name='btnUpCmt' value='UPDATE' onclick='showUpdateCmt(" + (cmt.getId()) + ")' class='btnUpdateCmt'></form>";
                s += "<div class='avt-comment' id='avt-comment'>"
                        + "<a href='/SocialNetwork/Profile?userId=" + (cmt.getUserId()) + "'>"
                        + "<img src='"+ (DAO.INSTANCE.getProfileById(cmt.getUserId()).getProfileImage()) +"' class='img-avt img-post'>"
                        + "</a>"
                        + "</div>";
                s += "<div class='content-comment'>";
                s += "<div class='name-comment'>" + DAO.INSTANCE.getProfileById(cmt.getUserId()).getDisplayName() + "</div>";
//                s += "<div class='badge-owner'>" + DAO.INSTANCE.getProfileById(cmt.getUserId()).get + "</div>";
                s += "<div class='body-comment'>" + cmt.getText() + "</div>";
                s += "<div class='react-comment'>";
//                s += "<div class='like-comment'>" + "LIKE" + "</div>";
//                s += "<div class='dislike-comment'>" + "DISLIKE" + "</div>";
                s += "<div class='reply-comment' id='replyClick' onclick='showComment(" + cmt.getId() + ")'><button>REPLY</button></div>";
                s += "<ul id='main-form-"+ (cmt.getId()) +"' style='display: none;'>\n"
                        + "    <li>\n"
                        + "        <div class=\"my-comment-content\">\n"
                        + "<img src='"+ userCur.getProfileImage() +"'>"
                        + "            <form action=\"Home\" method=\"post\" class=\"commentFormDif\">\n"
                        + "                <textarea id=\"commentText\" name=\"myCmt-text-main\" required></textarea>\n"
                        + "                <input type = 'text' name = 'myCmt-userId-second' class='myCmt-userId-second' hidden>\n"
                        + "                <input type = 'text' name = 'myCmt-postId-second' class='myCmt-postId-second' hidden>\n"
                        + "                <input type = 'text' name = 'myCmt-parenId-second' class='myCmt-parenId-second' "
                        + "value="+(cmt.getId())+" hidden>\n"
                        + "                <input type=\"submit\" name=\"myCmt-submit-main\" value=\"Comment\" class=\"submit-cmt\">\n"
                        + "            </form>\n"
                        + "        </div>\n"
                        + "    </li>\n"
                        + "</ul>";
                s += "<div class='time-comment'>" + "TIME" + "</div>";
                s += "</div>";
                s += "</div>";
                s += makeComment(cmt.getId(), cmtPostId, userCur);
                s += "</li>";
            }
        }
        s += "</ul>";
        return s;
    }
    
    public List<Comment> commentOfPostId(int postId) {
        List<Comment> cmtPostId = new Vector<>();
        for (Comment c : DAO.INSTANCE.getCommentList()) {
            if (c.getPostId() == postId) {
                cmtPostId.add(c);
            }
        }
        return cmtPostId;
    }
    
    public int getLikeCount(int postId) {
        int count = 0;
        for (Vote v : voteList) {
            if (v.getPostId() == postId && v.getVoteTypeId() == 1) {
                count++;
            }
        }
        return count;
    }
    
    public int getDislikeCount(int postId) {
        int count = 0;
        for (Vote v : voteList) {
            if (v.getPostId() == postId && v.getVoteTypeId() == 2) {
                count++;
            }
        }
        return count;
    }
    
    public List<Integer> getPopularTag() {
        String sql = "SELECT TOP(5) tagId, COUNT(tagId) AS tagCount\n"
                + "FROM PostTags_HE170781\n"
                + "GROUP BY tagId \n"
                + "ORDER BY tagCount DESC";
        List<Integer> listPopularTag = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                listPopularTag.add(rs.getInt(2));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            status = "Error at get popular tag" + e.getMessage();
        }
        return listPopularTag;
    }
    
    public void updateBan(int userId, boolean state) {
        String sql = "";
        try {
            if (state) {
                sql = "UPDATE [dbo].[Profiles_HE170781]\n"
                        + "   SET [isBaned] = 1\n"
                        + " WHERE Id = ?";
            } else {
                sql = "UPDATE [dbo].[Profiles_HE170781]\n"
                        + "   SET [isBaned] = 0\n"
                        + " WHERE Id = ?";
            }
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at update BAN" + e.getMessage();
        }
        System.out.println(status);
    }
    
    public void addFeedBack(int postId, String feedback) {
        String sql = "INSERT INTO [dbo].[PostFeedBacks_HE170781]\n"
                + "           ([PostId]\n"
                + "           ,[FeedBack]\n"
                + "           ,[CreationDate])\n"
                + "     VALUES\n"
                + "           (?, ?, GETDATE())";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postId);
            ps.setString(2, feedback);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at insert feedback" + e.getMessage();
        }
    }
    
    public void changePassword(String username, String password) {
        String sql = "UPDATE [dbo].[Profiles_HE170781]\n"
                + "SET [Password] = ?\n"
                + "WHERE [Username] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at change password " + e.getMessage();
        }
        System.out.println("status = " + status);
    }
    //**************************************************
    
    public int calcTime(Timestamp timePost) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        long timeDifferenceMillis = currentTime.getTime() - timePost.getTime();
        int timeDifferenceMinutes = (int) (timeDifferenceMillis / (60 * 1000));
        return timeDifferenceMinutes;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public List<Follower> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<Follower> followerList) {
        this.followerList = followerList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<PostTag> getPostTagList() {
        return postTagList;
    }

    public void setPostTagList(List<PostTag> postTagList) {
        this.postTagList = postTagList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<ProfileGroup> getProfileGroupList() {
        return profileGroupList;
    }

    public void setProfileGroupList(List<ProfileGroup> profileGroupList) {
        this.profileGroupList = profileGroupList;
    }

    public List<PostFeedBack> getPostFeedBackList() {
        return postFeedBackList;
    }

    public void setPostFeedBackList(List<PostFeedBack> postFeedBackList) {
        this.postFeedBackList = postFeedBackList;
    }

    
    
}

