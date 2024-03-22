
package model;

import java.util.Date;
import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    //password: tsab gwoj eyjl mzig
    // email: ngobaolam149@gmail.com
    static final String from = "ngobaolam149@gmail.com";
    static final String password = "tsabgwojeyjlmzig";
    
    public static boolean sendEmail(String to, String title, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        
        // Create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        // Tao phien lam viec
        Session session = Session.getInstance(props, auth);
        
        // Thuc hien hanh dong gui email
        
        // tao 1 tin nhan
        MimeMessage msg = new MimeMessage(session);
        try {
            // Kieu noi dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            // Nguoi gui
            msg.setFrom(from);
            // Nguoi nhan
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // Tieu de email
            msg.setSubject(title);
            // Quy dinh ngay gui
            msg.setSentDate(new Date());
            // Quy dinh email nhan phan hoi
            // Noi dung
            msg.setContent(content, "text/html");
            // Gui email
            Transport.send(msg);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
