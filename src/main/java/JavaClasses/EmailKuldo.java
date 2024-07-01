//package JavaClasses;
//
//
//import jakarta.mail.Session;
//import java.util.Properties;
//
//
//
//public class EmailKuldo {
//
//    public static void emailKuld(String cimzett, String targy, String szoveg) {
//        final String felhasznalonev = "youremail@example.com";
//        final String jelszo = "yourpassword";
//
//        Properties tulajdonsagok = new Properties();
//        tulajdonsagok.put("mail.smtp.auth", "true");
//        tulajdonsagok.put("mail.smtp.starttls.enable", "true");
//        tulajdonsagok.put("mail.smtp.host", "smtp.example.com");
//        tulajdonsagok.put("mail.smtp.port", "587");
//
//        Session munkamenet = Session.getInstance(tulajdonsagok,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(felhasznalonev, jelszo);
//                    }
//                });
//
//        try {
//
//            Message uzenet = new MimeMessage(munkamenet);
//            uzenet.setFrom(new InternetAddress("from-email@example.com"));
//            uzenet.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(cimzett));
//            uzenet.setSubject(targy);
//            uzenet.setText(szoveg);
//
//            Transport.send(uzenet);
//
//            System.out.println("Email sikeresen elküldve");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
