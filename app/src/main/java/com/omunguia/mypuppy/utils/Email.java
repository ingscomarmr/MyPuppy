package com.omunguia.mypuppy.utils;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import android.util.Log;

/**
 * Created by omunguia on 22/05/2016.
 */
public class Email {

    public static void sendEmail(String toStr, String subjectStr, String messageStr) throws AddressException, MessagingException {
        String host = "smtp.gmail.com";
        final String address = "test.omar.mr@gmail.com";
        String from = "test.omar.mr@gmail.com";
        final String pass = "android.1988";
        String port = "587"; // default smtp port
        String sport = "465"; // default socketfactory port

        Multipart multiPart;
        String finalString = "";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", address);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.socketFactory.port", sport);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getInstance(props);
       /* Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(address, pass);
                    }
                });*/

        session.setDebug(true);
        DataHandler handler = new DataHandler(new ByteArrayDataSource(finalString.getBytes(), "text/plain"));
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setDataHandler(handler);
        multiPart = new MimeMultipart();
        InternetAddress toAddress;
        toAddress = new InternetAddress(toStr);
        message.addRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject(subjectStr);
        message.setContent(multiPart);
        message.setText(messageStr);
        Transport transport = session.getTransport("smtps");
        transport.connect(host, address, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }


}
