package api_notifications.handlers;


import api_commons.response.ErrorCommons;


import api_notifications.enums.NotificationsErrors;
import api_notifications.exceptions.TemplateNotFoundException;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalHandlers {

  @ExceptionHandler(TemplateNotFoundException.class)
  public ResponseEntity<ErrorCommons> templateNotFoundExceptionHandler(
      TemplateNotFoundException e) {
    log.error(NotificationsErrors.NOTI_ERROR_0001.getUseCase(), e);

    ErrorCommons error = ErrorCommons
        .builder()
        .code(NotificationsErrors.NOTI_ERROR_0001.name())
        .message(NotificationsErrors.NOTI_ERROR_0001.getDescription())
        .status(HttpStatus.BAD_REQUEST.value())
        .build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(MessagingException.class)
  public ResponseEntity<ErrorCommons> messagingExceptionHandler(MessagingException e) {
    log.error(NotificationsErrors.NOTI_ERROR_0002.getUseCase(), e);

    ErrorCommons error = ErrorCommons
        .builder()
        .code(NotificationsErrors.NOTI_ERROR_0002.name())
        .message(NotificationsErrors.NOTI_ERROR_0002.getDescription())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build();

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

}
