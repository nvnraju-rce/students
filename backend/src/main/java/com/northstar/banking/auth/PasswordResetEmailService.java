package com.northstar.banking.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetEmailService {
    private final JavaMailSender mailSender;
    private final String fromAddress;

    public PasswordResetEmailService(JavaMailSender mailSender,
            @Value("${app.mail.from:${spring.mail.username:}}") String fromAddress) {
        this.mailSender = mailSender;
        this.fromAddress = fromAddress;
    }

    public void sendResetCode(String email, String name, String code) {
        if (fromAddress == null || fromAddress.isBlank()) {
            throw new MailDeliveryFailure("Email sending is not configured. Set MAIL_FROM and SMTP settings.");
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);
        message.setTo(email);
        message.setSubject("ByteBharat password reset code");
        message.setText("Hello " + (name == null || name.isBlank() ? "there" : name) + ",\n\n"
                + "Your ByteBharat password reset code is: " + code + "\n\n"
                + "This code expires in 10 minutes. If you did not request a password reset, you can ignore this email.\n\n"
                + "ByteBharat Support");
        try {
            mailSender.send(message);
        } catch (MailException exception) {
            throw new MailDeliveryFailure("We couldn't send the reset email. Please try again later.", exception);
        }
    }

    public static class MailDeliveryFailure extends RuntimeException {
        public MailDeliveryFailure(String message) { super(message); }
        public MailDeliveryFailure(String message, Throwable cause) { super(message, cause); }
    }
}
