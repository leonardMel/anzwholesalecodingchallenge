CREATE TABLE account(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number INTEGER NOT NULL UNIQUE,
    account_name VARCHAR(255) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL,
    balance_date DATE NOT NULL,
    currency VARCHAR(255) NOT NULL
);

CREATE TABLE account_transaction(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number INTEGER NOT NULL,
    account_name VARCHAR(255) NOT NULL,
    value_date DATE NOT NULL,
    currency VARCHAR(255) NOT NULL,
    debit_amount DOUBLE DEFAULT 0,
    credit_amount DOUBLE DEFAULT 0,
    transaction_type VARCHAR(255) NOT NULL,
    transaction_narrative VARCHAR(255) DEFAULT ''
);