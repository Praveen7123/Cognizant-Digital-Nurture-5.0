-- Exercise 1: Control Structures (uses the official schema)
-- Run 00-schema.sql first.
SET SERVEROUTPUT ON;

-- Scenario 1: customers above 60 get a 1% discount on their loan interest rate.
-- Age is worked out from DOB using MONTHS_BETWEEN.
BEGIN
   FOR rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
      IF MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12 > 60 THEN
         UPDATE Loans
         SET InterestRate = InterestRate - 1
         WHERE CustomerID = rec.CustomerID;
      END IF;
   END LOOP;
END;
/
SELECT * FROM Loans;

-- Scenario 2: set IsVIP = TRUE for customers with balance over 10000
BEGIN
   FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
      IF rec.Balance > 10000 THEN
         UPDATE Customers
         SET IsVIP = 'TRUE'
         WHERE CustomerID = rec.CustomerID;
      END IF;
   END LOOP;
END;
/
SELECT CustomerID, Name, Balance, IsVIP FROM Customers;

-- Scenario 3: print reminders for loans due within the next 30 days
-- (a loan's due date is its EndDate)
BEGIN
   FOR rec IN (
      SELECT l.LoanID, l.EndDate, c.Name
      FROM Loans l
      JOIN Customers c ON l.CustomerID = c.CustomerID
      WHERE l.EndDate <= SYSDATE + 30
   ) LOOP
      DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.Name ||
                           ', your loan (ID: ' || rec.LoanID ||
                           ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
   END LOOP;
END;
/
