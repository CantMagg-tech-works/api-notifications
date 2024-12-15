package api_notifications.infrastructure;

import api_notifications.dtos.SendHtmlRequest;
import api_notifications.enums.NotificationsLogsMessages;
import api_notifications.service.EmailTemplateService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailEventConsumer {

  private final EmailTemplateService emailTemplateService;

  @KafkaListener(topics = "send-otp", groupId = "api-notifications-group")
  public void processEmailEvent(Map<String, String> payload) {
    log.info(NotificationsLogsMessages.MESSAGE_RECEIVED.getMessage(), payload);

    SendHtmlRequest sendHtmlRequest = buildSendHtmlRequest(payload);

    try {
      emailTemplateService.sendEmail(sendHtmlRequest);
      log.info(NotificationsLogsMessages.EMAIL_SENT_SUCCESS.getMessage(), payload.get("email"));
    } catch (Exception e) {
      log.error(NotificationsLogsMessages.EMAIL_SEND_ERROR.getMessage(), e.getMessage(), e);
    }
  }

  private SendHtmlRequest buildSendHtmlRequest(Map<String, String> payload) {

    Map<String, String> variables = payload.entrySet().stream()
        .filter(
            entry -> !List.of("email", "subject", "templateName", "id").contains(entry.getKey()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    return SendHtmlRequest.builder()
        .email(payload.get("email"))
        .subject(payload.get("subject"))
        .id(Integer.valueOf(payload.get("id")))
        .templateName(payload.get("templateName"))
        .variables(variables)
        .build();
  }
}
