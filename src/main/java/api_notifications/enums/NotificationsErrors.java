package api_notifications.enums;

import lombok.Getter;

@Getter
public enum NotificationsErrors {

  NOTI_ERROR_0001("Template not found.", "The requested template is not found or does not exist."),
  NOTI_ERROR_0002("Failure to send email.",
      "The email delivery could not be processed at this time.");

  private final String useCase;
  private final String description;

  NotificationsErrors(String useCase, String description) {
    this.useCase = useCase;
    this.description = description;
  }
}
