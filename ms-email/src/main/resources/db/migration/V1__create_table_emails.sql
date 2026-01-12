CREATE TABLE emails (
    email_id UUID PRIMARY KEY,
    user_id UUID,
    email_from VARCHAR(255),
    email_to VARCHAR(255),
    subject VARCHAR(255),
    text TEXT,
    send_date_email TIMESTAMP,
    status_email VARCHAR(20)
);

ALTER TABLE emails ADD CONSTRAINT check_status
CHECK (status_email IN ('SUCCESS', 'ERROR'));