package group1.habitAnalysis.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail( String to) {
        String subject = "Hi from New Work Academy - Your Journey Begins Here!✨🚀";
        String body = "We are thrilled to welcome you to New Work Academy! \uD83C\uDF89\n" +
                "\n" +
                "Congratulations on taking the first step towards an incredible journey with us. We're excited to have you on board and can't wait to see all the amazing things you'll achieve as a part of our community.";
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);


            javaMailSender.send(mimeMessage);

            return "Mail send";

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
