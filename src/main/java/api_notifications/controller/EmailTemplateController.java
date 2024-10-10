package api_notifications.controller;

import api_notifications.dtos.SendHtmlRequest;
import api_notifications.service.imp.EmailTemplateServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class EmailTemplateController {

  private final EmailTemplateServiceImp emailTemplateServiceImp;

  @PostMapping("/sends")
  public String sendEmail(@Valid @RequestBody SendHtmlRequest sendHtmlRequest) {
    return emailTemplateServiceImp.sendEmail(sendHtmlRequest);
  }

}
