SET search_path TO api_notifications;

CREATE TABLE IF NOT EXISTS email_template (
    id SERIAL PRIMARY KEY,
    template_name VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    creation_date DATE NOT NULL,
    deleted_at DATE
);

