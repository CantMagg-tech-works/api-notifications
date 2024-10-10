package api_notifications.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendHtmlRequest implements Serializable {

  @NotEmpty
  private Integer id;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String templateName;
  @NotBlank
  private String subject;
  @NotEmpty
  private Map<String, String> variables;

}
