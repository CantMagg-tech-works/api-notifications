package api_notifications.repository;

import api_notifications.model.EmailTemplateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplateModel, Integer> {

}
