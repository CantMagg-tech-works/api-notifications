package api_notifications.utils;

import java.util.Map;
import lombok.Getter;

@Getter
public class ReplacePlaceholderUtil {

  private ReplacePlaceholderUtil() {

  }

  public static String replacePlaceholders(String template, Map<String, String> placeholders) {

    String processedTemplate = template;
    for (Map.Entry<String, String> entry : placeholders.entrySet()) {
      processedTemplate = processedTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
    }
    return processedTemplate;
  }

}
