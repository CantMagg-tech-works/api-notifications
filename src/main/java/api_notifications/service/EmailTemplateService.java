package api_notifications.service;

import api_notifications.dtos.SendHtmlRequest;
import jakarta.mail.MessagingException;

public interface EmailTemplateService {

  String sendEmail(SendHtmlRequest sendHtmlRequest) throws MessagingException;

}
