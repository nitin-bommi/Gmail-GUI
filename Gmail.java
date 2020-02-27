package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Gmail implements ActionListener {

        Label l1, l2, l3;
        TextField tf1, tf2, tf3, tf4;
        Button b1;
        String password;

        //Constructor
        public Gmail(  ) {

                Scanner sc = new Scanner(System.in);
                password = "ybwvuboviykuzcmy";

                //Frame
                Frame f = new Frame ( "Gmail" );
                f.setSize ( 800,500 );
                f.setLayout ( null );
                f.setVisible ( true );

                //Closing
                f.addWindowListener ( new WindowAdapter ( ) {
                        @Override
                        public void windowClosing ( WindowEvent e ) {
                                System.exit ( 0 );
                        }
                } );

                //Labels
                l1 = new Label ( "From" );
                l1.setBounds ( 50,50,100,25);
                l2 = new Label ( "To" );
                l2.setBounds ( 50,120,100,25 );
                l3 = new Label ( "Subject" );
                l3.setBounds ( 50,190,100,25 );

                //Text-Fields
                tf1 = new TextField (  );
                tf1.setBounds ( 150,50,600,25 );
                tf2 = new TextField (  );
                tf2.setBounds ( 150,120,600,25 );
                tf3 = new TextField (  );
                tf3.setBounds ( 150,190,600,25 );
                tf4 = new TextField (  );
                tf4.setBounds ( 50,260,700,150 );

                //Button
                b1 = new Button ( "Send" );
                b1.setBounds ( 375,430,50, 20);

                f.add ( l1 ); f.add ( l2 ); f.add ( l3 );
                f.add ( tf1 ); f.add ( tf2 ); f.add ( tf3 ); f.add ( tf4 );
                f.add ( b1 );

                b1.addActionListener ( this );

        }

        public static void main ( String[] args ) {
                new Gmail();
        }

        @Override
        public void actionPerformed ( ActionEvent e ) {

                String _from = tf1.getText ();
                String _to = tf2.getText ();
                String host = "https://mail.google.com/mail/u/0";
                Mailer.send(_from, password, _to, tf3.getText (), tf4.getText ());

        }

}

class Mailer{

        public static void send(String from, String password, String to, String sub, String msg){

                //Get properties object
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class",
                                "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                //Get Session
                Session session = Session.getDefaultInstance(props,
                                new javax.mail.Authenticator() {
                                        protected PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication(from,password);
                                        }
                                });

                //Compose message
                try {
                        MimeMessage message = new MimeMessage(session);
                        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                        message.setSubject(sub);
                        message.setText(msg);
                        //send message
                        Transport.send(message);
                        System.out.println("message sent successfully");
                } catch (MessagingException e) {throw new RuntimeException(e);}

        }

}
