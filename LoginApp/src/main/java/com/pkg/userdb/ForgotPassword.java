package com.pkg.userdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pkg.Connection.ConnectionManager;
import com.pkg.userbeans.UserBeans;

public class ForgotPassword {
	 /**
     * Send the email via SMTP using StartTLS and SSL
	 * @return 
     */
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static String sql="Select userid,password from sys.userdb where email=?";
	private static String pass=null;
	private static String userid=null;
    public static Boolean sendEmail(UserBeans userBeans) {
  
    	boolean flag=false;
    	String email=userBeans.getEmail_id();
    	
    	try{
    		con=ConnectionManager.getConnection();
    		ps=con.prepareStatement(sql);
    		ps.setString(1, email);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			userid=rs.getString(1);
    			pass=rs.getString(2);
    		}
    		
    		
    	}
    	catch(SQLException se)
    	{
    		se.printStackTrace();
    	}
    	
        // Create all the needed properties
        Properties connectionProperties = new Properties();
        // SMTP host
        connectionProperties.put("mail.smtp.host", "smtp.gmail.com");
        // Is authentication enabled
        connectionProperties.put("mail.smtp.auth", "true");
        // Is StartTLS enabled
        connectionProperties.put("mail.smtp.starttls.enable", "true");
        // SSL Port
        connectionProperties.put("mail.smtp.socketFactory.port", "465");
        // SSL Socket Factory class
        connectionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // SMTP port, the same as SSL port :)
        connectionProperties.put("mail.smtp.port", "465");
         
        System.out.print("Creating the session...");
         
        // Create the session
        Session session = Session.getDefaultInstance(connectionProperties,
                new javax.mail.Authenticator() {    // Define the authenticator
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("srireddy110@gmail.com","9701469923");
                    }
                });
         
        System.out.println("done!");
        if(pass!=null){
        // Create and send the message
        try {
            // Create the message 
            Message message = new MimeMessage(session);
            // Set sender
            message.setFrom(new InternetAddress("srireddy110@gmail.com"));
            // Set the recipients
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            // Set message subject
            message.setSubject("Getting Forgot password");
            // Set message text
            
            message.setText("Hi user....\n"
            		+"Your User ID is"+userid
            		
            		+ "\nYour Password is"+pass);
            
            System.out.print("Sending message...");
            // Send the message
            Transport.send(message);
             
            System.out.println("done!");
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
        }
        else
		return false;
         
    }
}
