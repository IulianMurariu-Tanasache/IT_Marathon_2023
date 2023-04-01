package com.it.marathon.service.impl;

import com.it.marathon.entity.ReportAssignedEntity;
import com.it.marathon.entity.ReportSubmittedEntity;
import com.it.marathon.service.EmailAlerter;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailAlerterImpl implements EmailAlerter {
    private final JavaMailSender emailSender;
    @Override
    public void sendEmailAlert(ReportAssignedEntity reportAssignedEntity, ReportSubmittedEntity reportSubmitted) {
        if(reportAssignedEntity.getContacts() != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("alert.report.it.marathon@gmail.com");
            message.setTo(reportAssignedEntity.getContacts().getEmail());
            message.setSubject("Your report has been addressed");
            message.setText("Your report you sent on " + reportAssignedEntity.getTimestamp() + " was addressed by an operator.\nThe steps set to be taken are:\n" + reportSubmitted.getActions() + ".");
            emailSender.send(message);
        }
    }
}
