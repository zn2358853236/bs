package wm.com.ctbbs.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	 public static  String HOST ;  
	    public static  String PROTOCOL;     
	    public static  int PORT ;  
	    public static  String FROM ;//发件人的email  
	    public static  String PWD ;//发件人密码  
	      
	    /** 
	     * 获取Session 
	     * @return 
	     * @throws IOException 
	     */  
	    private static Session getSession() {  
	        Properties props = new Properties();
	        InputStream in=SendEmail.class.getClassLoader().getResourceAsStream("email.properties");
	        try {
				props.load(in);
				HOST=props.getProperty("email.host");
				PROTOCOL=props.getProperty("email.protocol");
				PORT=Integer.parseInt(props.getProperty("email.port"));
				FROM=props.getProperty("email.from");
				PWD=props.getProperty("email.pwd");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        
	        props.put("mail.smtp.host", HOST);//设置服务器地址  
	        props.put("mail.store.protocol" , PROTOCOL);//设置协议  
	        props.put("mail.smtp.port", PORT);//设置端口 
	        props.put("mail.smtp.auth" , true);  
	          
	        Authenticator authenticator = new Authenticator() {  
	  
	            @Override  
	            protected PasswordAuthentication getPasswordAuthentication() {  
	                return new PasswordAuthentication(FROM, PWD);  
	            }  
	              
	        };  
	        Session session = Session.getDefaultInstance(props , authenticator);  
	          
	        return session;  
	    }  
	      
	    public static void send(String toEmail , String content) {  
	        Session session = getSession();  
	        try {  
	         /*   System.out.println("--send--"+content);  */
	            // Instantiate a message  
	            Message msg = new MimeMessage(session);  
	   
	            //Set message attributes  
	            msg.setFrom(new InternetAddress(FROM));  
	            InternetAddress[] address = {new InternetAddress(toEmail)};  
	            msg.setRecipients(Message.RecipientType.TO, address);  
	            msg.setSubject("账号激活邮件");  
	            msg.setSentDate(new Date());  
	            msg.setContent(content , "text/html;charset=utf-8");  
	   
	            //Send the message  
	            Transport.send(msg);  
	        }  
	        catch (MessagingException mex) {  
	            mex.printStackTrace();  
	        }  
	    }  
}
