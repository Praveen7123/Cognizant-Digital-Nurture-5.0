-- Exercise 3: Stored Procedures (uses the official schema)
-- Run 00-schema.sql first.
SET SERVEROUTPUT ON;

-- Scenario 1: add 1% monthly interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to savings accounts');
END;
/

-- Scenario 2: add a bonus % to salary of employees in a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;
    DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || dept_name);
END;
/

-- Scenario 3: transfer funds between accounts if balance is enough
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
)
IS
    current_balance NUMBER;
BEGIN
    SELECT Balance INTO current_balance
    FROM Accounts
    WHERE AccountID = from_account;

    IF current_balance >= amount THEN
        UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_account;
        UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_account;
        DBMS_OUTPUT.PUT_LINE('Transfer successful from Account ' || from_account || ' to Account ' || to_account);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in Account ' || from_account);
    END IF;
END;
/

-- testing the procedures
BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 10);
    TransferFunds(1, 2, 500);
END;
/
SELECT AccountID, AccountType, Balance FROM Accounts;
SELECT Name, Department, Salary FROM Employees;
