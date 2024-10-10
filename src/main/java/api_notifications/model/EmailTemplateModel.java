package api_notifications.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "email_template")
public class EmailTemplateModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "template_name")
  private String templateName;
  @Column(name = "subject")
  private String subject;
  @Column(name = "body")
  private String body;
  @Column(name = "creation_date")
  private Date creationDate;
  @Column(name = "deleted_at")
  private Date deletedAt;

}
