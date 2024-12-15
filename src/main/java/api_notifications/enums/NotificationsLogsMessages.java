package api_notifications.enums;

import lombok.Getter;

@Getter
public enum NotificationsLogsMessages {

  MESSAGE_RECEIVED("Message received from Kafka: {}"),
  EMAIL_SENT_SUCCESS("Email successfully sent to: {}"),
  EMAIL_SEND_ERROR("Error sending email: {}"),
  BUILDING_EMAIL_REQUEST("Building email request for email: {}");

  private final String message;

  NotificationsLogsMessages(String message) {
    this.message = message;
  }
}
