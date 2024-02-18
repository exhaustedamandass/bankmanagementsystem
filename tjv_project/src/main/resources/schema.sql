create table if not exists persons(
                                      personId bigserial not null primary key,
                                      lastName varchar(180),
    firstName varchar(180),
    dateOfBirth timestamp,
    email varchar(180),
    phoneNumber varchar(180),
    address varchar(180),
    taxIdentifier varchar(180)
    );

create table if not exists customers(
                                        customerId bigserial primary key,
                                        customerType varchar(180),
    personHolder bigint references persons
    );

create table if not exists accounts(
                                       accountId bigserial primary key,
                                       accountNumber varchar(180),
    accountType varchar(180),
    currentBalance float,
    dateOpened timestamp,
    dateClosed timestamp,
    accountStatus varchar(180),
    accountHolders bigint references customers
    );

create table if not exists transactions(
                                           transactionId bigserial primary key,
                                           transactionType varchar(180),
    amount float,
    transactionDate timestamp,
    client_id bigint references accounts
    );

create table if not exists accounts_holded(
                                              customer_id bigint references customers,
                                              account_id bigint references accounts
);

CREATE SEQUENCE if not exists accounts_seq START 1;

