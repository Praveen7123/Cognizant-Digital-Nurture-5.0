
SET SERVEROUTPUT ON;

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
