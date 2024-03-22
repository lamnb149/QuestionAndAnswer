
import dal.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.*;
import java.util.*;

public class MainApp {

    public static String makeComment(int pid, List<Comment> cmtPostId) {
        int count = 0;
        for (Comment cmt : cmtPostId) {
            if (pid == cmt.getParentId()) {
                count++;
            }
        }

        if (count == 0) {
            return "";
        }
        String s = "<ul>";
        for (Comment cmt : cmtPostId) {
            if (cmt.getParentId() == pid) {
                s += "<li>" + cmt.getText();
//                System.out.println("cmt = " + cmt);
                s += makeComment(cmt.getId(), cmtPostId);
                s += "</li>";
            }
        }
        s += "</ul>";
        return s;
    }

    public static List<Comment> commentOfPostId(int postId) {
        List<Comment> cmtPostId = new Vector<>();
        for (Comment c : DAO.INSTANCE.getCommentList()) {
            if (c.getPostId() == postId) {
                cmtPostId.add(c);
            }
        }
        return cmtPostId;
    }

    public static void main(String[] args) {
        
    }
}
