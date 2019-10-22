package person.liming.test.test25;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author liuliming
 * @Description ʹ��javaMailдһ�����򣬿��Է���һ���ʼ���һ���˺ţ�Ҫ������Զ����ʼ�����
 */
public class Test25 {
	
	static String sendMail = "liuliming155@163.com";
	static String sendMailName = "liuliming";
	static String sendMailPassword = "liu13691705227";
	static String sendMailHost = "smtp.163.com";
	
	static String reciptMail = "876475897@qq.com";
	static String reciptMailName = "small_liuliming";
	
	public static void main(String[] args) {
		//����session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", sendMailHost);
        props.setProperty("mail.smtp.starttls.enable","true"); 
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		try {
			System.out.println(session.getProvider("pop3").toString());
			System.out.println(session.getProvider("smtp").toString());
		} catch (NoSuchProviderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//����message
		MimeMessage message = new MimeMessage(session);
		try {
			//����message����
			message.setFrom(new InternetAddress(sendMail, sendMailName, "utf-8"));
			message.setRecipient(MimeMessage.RecipientType.TO
					, new InternetAddress(reciptMail, reciptMailName, "utf-8"));
			message.setSubject("�����ʼ�����", "utf-8");
			message.setContent("Test/�����ʼ�������", "text/html;charset=UTF-8");
			message.setSentDate(new Date());
			message.saveChanges();
//			OutputStream out = new FileOutputStream("src/file/myEmail.eml");
//			message.writeTo(out);
//			out.flush();
//			out.close();
			
			Transport transport = session.getTransport();
			transport.connect(sendMail, sendMailPassword);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
