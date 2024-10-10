package api_notifications.enums;

import lombok.Getter;

@Getter
public enum NotificationsMessages {

  NOTI_MESS_0001("Successful email sending.", "The email was sent successfully.");

  private final String useCase;
  private final String description;

  NotificationsMessages(String useCase, String description) {
    this.useCase = useCase;
    this.description = description;
  }
}
