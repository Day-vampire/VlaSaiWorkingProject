CREATE TABLE NewsSource (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    domen VARCHAR(255)
);

CREATE TABLE NewsSubscriptions (
    id BIGSERIAL PRIMARY KEY,
    news_source_id VARCHAR(255),
    news_subscription_date DATE,
    user_id VARCHAR(255)

);

CREATE TABLE Transactions (
    id BIGSERIAL PRIMARY KEY,
    wallet_id VARCHAR(255),
    type VARCHAR(255),
    cryptocurrency_id VARCHAR(255),
    amount_of_cryptocurrency NUMERIC,
    transaction_date DATE
);

CREATE TABLE Wallets (
    id BIGSERIAL PRIMARY KEY,
    currency_id VARCHAR(255),
    amount_of_cryptocurrency NUMERIC,
    user_id VARCHAR(255)
);

CREATE TABLE Users (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(255),
    password VARCHAR(255),
    role_id VARCHAR(255),
    status VARCHAR(255)
);

CREATE TABLE Roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE PassportData (
    id BIGSERIAL PRIMARY KEY,
    country VARCHAR(255),
    date_of_issue DATE,
    validity_period INTEGER,
    identification_number VARCHAR(255)
);

CREATE TABLE Persons (
    id BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    passport_data_id VARCHAR(255)
);

CREATE TABLE VirtualCashAccounts (
    id BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    currency_id VARCHAR(255)
);

CREATE TABLE FavoriteCryptocurrences (
    id BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    cryptocurrency_id VARCHAR(255)
);

CREATE TABLE CryptocurrencesReports (
    id BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    report_type_id VARCHAR(255),
    cryptocurrency_id VARCHAR(255),
    report_name VARCHAR(255),
    report_date DATE
);

CREATE TABLE CryptocurrencesReportTypes (
    id BIGSERIAL PRIMARY KEY,
    type_name VARCHAR(255),
    description TEXT
);

CREATE TABLE Currencies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    exchange_rate NUMERIC
);

CREATE TABLE AccountsReportTypes (
    id BIGSERIAL PRIMARY KEY,
    type_name VARCHAR(255),
    description TEXT
);

CREATE TABLE AccountsReports (
    id BIGSERIAL PRIMARY KEY,
    virtual_cash_account_id VARCHAR(255),
    report_type_id VARCHAR(255),
    report_name VARCHAR(255),
    report_date DATE
);