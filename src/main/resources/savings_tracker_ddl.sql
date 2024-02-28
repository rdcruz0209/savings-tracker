use savings_tracker_dev;

CREATE TABLE transaction
(
    id                   VARCHAR(20)  NOT NULL,
    amount               DECIMAL      NULL,
    type                 VARCHAR(255) NULL,
    `description`        VARCHAR(255) NULL,
    transaction_date     datetime     NULL,
    transaction_category VARCHAR(255) NOT NULL,
    user_id              VARCHAR(255) NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);
    
CREATE TABLE user
(
    user_id    VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    user_name  VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);
    