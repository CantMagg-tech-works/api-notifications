package api_notifications.service.imp;

import api_notifications.dtos.SendHtmlRequest;
import api_notifications.enums.NotificationsMessages;
import api_notifications.exceptions.TemplateNotFoundException;
import api_notifications.model.EmailTemplateModel;
import api_notifications.repository.EmailTemplateRepository;
import api_notifications.service.EmailTemplateService;
import api_notifications.utils.ReplacePlaceholderUtil;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailTemplateServiceImp implements EmailTemplateService {

  private final JavaMailSender javaMailSender;
  private final EmailTemplateRepository emailTemplateRepository;




  @Override
  @SneakyThrows
  public String sendEmail(SendHtmlRequest sendHtmlRequest) {
    EmailTemplateModel emailTemplateModel = emailTemplateRepository.findById(
        sendHtmlRequest.getId()).orElseThrow(TemplateNotFoundException::build);

    String processedBody = ReplacePlaceholderUtil.replacePlaceholders(emailTemplateModel.getBody(),
        sendHtmlRequest.getVariables());

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
    helper.setTo(sendHtmlRequest.getEmail());
    helper.setSubject(sendHtmlRequest.getSubject());
    helper.setText(processedBody, true);
    javaMailSender.send(mimeMessage);

    return NotificationsMessages.NOTI_MESS_0001.getDescription();
  }
}
