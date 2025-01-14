create table account_report_types
(
    id          BIGSERIAL PRIMARY KEY,
    name        TEXT NOT NULL UNIQUE,
    description TEXT NOT NULL
);

create table account_reports
(
    id                     BIGSERIAL PRIMARY KEY,
    account_report_type_id BIGINT                   NOT NULL,
    cash_account_id        BIGINT                   NOT NULL,
    report_date            TIMESTAMP WITH TIME ZONE NOT NULL,
    report_name            TEXT                     NOT NULL UNIQUE
);

create table account_transactions
(
    id                          BIGSERIAL PRIMARY KEY,
    amount_of_cryptocurrency    DECIMAL                  NOT NULL CHECK (amount_of_cryptocurrency >= 0),
    currency_rate               DECIMAL                  NOT NULL CHECK (currency_rate >= 0),
    cash_account_id             BIGINT                   NOT NULL,
    date_of_account_transaction TIMESTAMP WITH TIME ZONE NOT NULL,
    currency_id                 TEXT                     NOT NULL,
    type                        TEXT                     NOT NULL
);

create table cash_accounts
(
    id          BIGSERIAL PRIMARY KEY,
    balance     DECIMAL NOT NULL CHECK (balance >= 0),
    status      BOOLEAN NOT NULL DEFAULT FALSE,
    user_id     BIGINT UNIQUE,
    currency_id TEXT    NOT NULL
);

create table cryptocurrency_actives
(
    id                       BIGSERIAL PRIMARY KEY,
    balance                  DECIMAL NOT NULL CHECK (balance >= 0),
    cryptocurrency_wallet_id BIGINT  NOT NULL,
    cryptocurrency_id        TEXT    NOT NULL
);

create table cryptocurrency_report_types
(
    id          BIGSERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    name        TEXT NOT NULL
);

create table cryptocurrency_reports
(
    id                            BIGSERIAL PRIMARY KEY,
    cryptocurrency_report_type_id BIGINT                   NOT NULL,
    report_date                   TIMESTAMP WITH TIME ZONE NOT NULL,
    user_id                       BIGINT                   NOT NULL,
    cryptocurrency_id             TEXT                     NOT NULL,
    report_name                   TEXT                     NOT NULL UNIQUE
);

create table cryptocurrency_wallets
(
    id                  BIGSERIAL PRIMARY KEY,
    auto_trading_status BOOLEAN NOT NULL DEFAULT FALSE,
    status              BOOLEAN NOT NULL DEFAULT FALSE,
    user_id             BIGINT UNIQUE,
    currency_id         TEXT    NOT NULL
);

create table favorite_cryptocurrencies
(
    id                BIGSERIAL PRIMARY KEY,
    user_id           BIGINT NOT NULL,
    cryptocurrency_id TEXT   NOT NULL
);

create table news_sources
(
    id          BIGSERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    domen       TEXT NOT NULL UNIQUE,
    name        TEXT NOT NULL UNIQUE
);

create table news_subscriptions
(
    id                        BIGSERIAL PRIMARY KEY,
    date_of_news_subscription DATE,
    news_source_id            BIGINT NOT NULL,
    user_id                   BIGINT NOT NULL
);

create table passport_data
(
    id                    BIGSERIAL PRIMARY KEY,
    date_of_issue         DATE NOT NULL,
    validity_period       DATE NOT NULL,
    country               TEXT NOT NULL,
    identification_number TEXT NOT NULL UNIQUE
);

create table persons
(
    id               BIGSERIAL PRIMARY KEY,
    passport_data_id BIGINT UNIQUE,
    email            TEXT NOT NULL UNIQUE,
    name             TEXT NOT NULL,
    sur_name         TEXT NOT NULL
);

create table roles
(
    id   BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

create table users
(
    id        BIGSERIAL PRIMARY KEY,
    status    BOOLEAN NOT NULL DEFAULT FALSE,
    person_id BIGINT UNIQUE,
    role_id   BIGINT,
    login     TEXT    NOT NULL,
    password  TEXT    NOT NULL
);

create table wallet_transactions
(
    id                       BIGSERIAL PRIMARY KEY,
    amount_of_cryptocurrency DECIMAL NOT NULL CHECK (amount_of_cryptocurrency >= 0),
    cryptocurrency_rate      DECIMAL NOT NULL CHECK (cryptocurrency_rate >= 0),
    cryptocurrency_wallet_id BIGINT,
    date_of_transaction      TIMESTAMP WITH TIME ZONE,
    cryptocurrency_id        TEXT    NOT NULL,
    type                     TEXT    NOT NULL
);

alter table if exists account_reports
    add constraint FKlmp3f6764l8x04hwlg9eu8pf1 foreign key (account_report_type_id) references account_report_types (id);

alter table if exists account_reports
    add constraint FK2e2pudq1cbs8h3hytlo78xvha foreign key (cash_account_id) references cash_accounts (id);

alter table if exists account_transactions
    add constraint FKn66rjri1xnxjrlrtb57hhmwks foreign key (cash_account_id) references cash_accounts (id);

alter table if exists cash_accounts
    add constraint FKhvyhepdyuj8yy9iffuhbjncp5 foreign key (user_id) references users (id);

alter table if exists cryptocurrency_actives
    add constraint FKqq3kwky2si1xb8y6fe55n7q1p foreign key (cryptocurrency_wallet_id) references cryptocurrency_wallets (id);

alter table if exists cryptocurrency_reports
    add constraint FK38bectmmk9lyrf0l2yof3gn19 foreign key (cryptocurrency_report_type_id) references cryptocurrency_report_types (id);

alter table if exists cryptocurrency_reports
    add constraint FKpn80q7grcp1b4usvrgxxxx2ok foreign key (user_id) references users (id);

alter table if exists cryptocurrency_wallets
    add constraint FK887yj5hn29sif51gecxi1tfnm foreign key (user_id) references users (id);

alter table if exists favorite_cryptocurrencies
    add constraint FK7801jwhmrcyd06wv94heffdba foreign key (user_id) references users (id);

alter table if exists news_subscriptions
    add constraint FKmvtdaqeq0ei57x1abb23d4k9x foreign key (news_source_id) references news_sources (id);

alter table if exists news_subscriptions
    add constraint FKkuueeqsjmaew0vgkca9vf611f foreign key (user_id) references users (id);

alter table if exists persons
    add constraint FKg946k1l7c8vjl8nh9vbdaaxjy foreign key (passport_data_id) references passport_data (id);

alter table if exists users
    add constraint FKmvbq8q4vpi6csivw9wcnq6ho5 foreign key (person_id) references persons (id);

alter table if exists users
    add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id);

alter table if exists wallet_transactions
    add constraint FKg4pbh2ibsyqos6565ckpkt7kr foreign key (cryptocurrency_wallet_id) references cryptocurrency_wallets (id);

