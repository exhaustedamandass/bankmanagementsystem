-- Insert persons
INSERT INTO persons (lastName, firstName, dateOfBirth, email, phoneNumber, address, taxIdentifier)
VALUES
    ('Doe', 'John', '1990-01-01', 'john.doe@example.com', '123-456-7890', '123 Main St', 'ABC123456789'),
    ('Smith', 'Jane', '1985-05-15', 'jane.smith@example.com', '987-654-3210', '456 Oak St', 'XYZ987654321');

-- Insert customers
INSERT INTO customers (customerType, personHolder)
VALUES
    ('Individual', 1),
    ('Individual', 2);

-- Insert accounts
INSERT INTO accounts (accountNumber, accountType, currentBalance, dateOpened, dateClosed, accountStatus, accountHolders)
VALUES
    ('123456789', 'Savings', 1000.00, '2022-01-01', NULL, 'Active', 1),
    ('987654321', 'Checking', 500.00, '2022-02-15', NULL, 'Active', 2);

-- Insert transactions
INSERT INTO transactions (transactionType, amount, transactionDate, client_id)
VALUES
    ('Deposit', 500.00, '2022-01-05', 1),
    ('Withdrawal', 200.00, '2022-01-10', 1),
    ('Transfer', 100.00, '2022-02-20', 2);

-- Insert accounts_holded (linking customers to accounts)
INSERT INTO accounts_holded (customer_id, account_id)
VALUES
    (1, 1),
    (2, 2),
    (1, 2);
