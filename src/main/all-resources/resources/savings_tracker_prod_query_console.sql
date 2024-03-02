USE savings_tracker;
SELECT * FROM transaction;

SELECT * FROM transaction WHERE user_id = '99db18bf-e566-468b-9630-912bc484935f';

DELETE FROM transaction WHERE description = 'test';

SELECT * FROM user;

UPDATE transaction set transaction_category = 'HOUSE_FUND' WHERE id !=' ';

ALTER TABLE transaction;

UPDATE transaction SET user_id = 'Claire' WHERE id != '87654321-4321-4321-4321-cba987654321';

-- INSERT INTO transaction (type, amount, transaction_date, id, description, user_id) 
-- VALUES 
-- ('CREDIT', 1050, '2024-02-11 10:30:00', '12345678-1234-1234-1234-123456789abc', 'Purchase of groceries', 'user123'),
-- ('DEBIT', 505, '2024-02-10 15:45:00', '87654321-4321-4321-4321-cba987654321', 'Payment received', 'user456');

ALTER TABLE transaction
ADD COLUMN user_id VARCHAR(255);

ALTER TABLE transaction
ADD column transaction_category VARCHAR(255) NOT NULL;

CREATE TABLE user
(
    user_id    VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    user_name  VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);
    
    