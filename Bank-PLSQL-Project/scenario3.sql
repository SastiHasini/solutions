BEGIN
    FOR l IN (
        SELECT L.LOAN_ID, L.CUSTOMER_ID, C.NAME, L.DUE_DATE
        FROM LOANS L
        JOIN CUSTOMERS C ON L.CUSTOMER_ID = C.CUSTOMER_ID
        WHERE L.DUE_DATE BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ' || l.LOAN_ID ||
            ' for customer ' || l.NAME ||
            ' is due on ' || l.DUE_DATE
        );
    END LOOP;
END;
/