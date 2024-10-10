package api_notifications.exceptions;

import api_notifications.enums.NotificationsErrors;

public class TemplateNotFoundException extends RuntimeException {

  public TemplateNotFoundException(NotificationsErrors message) {
    super(message.getUseCase());
  }

  public static TemplateNotFoundException build() {
    return new TemplateNotFoundException(NotificationsErrors.NOTI_ERROR_0001);
  }

}
