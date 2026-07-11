DELETE FROM country;

INSERT INTO country (co_code, co_name) VALUES ('AF', 'Afghanistan');
INSERT INTO country (co_code, co_name) VALUES ('AL', 'Albania');
INSERT INTO country (co_code, co_name) VALUES ('CN', 'China');
INSERT INTO country (co_code, co_name) VALUES ('GB', 'United Kingdom');
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('JP', 'Japan');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States');

DELETE FROM stock;

INSERT INTO stock (id, code, date, open, close, volume) VALUES (1, 'FB', '2020-09-01', 270.00, 275.00, 850000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (2, 'FB', '2020-09-10', 276.00, 278.50, 920000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (3, 'FB', '2020-09-22', 279.00, 281.20, 910000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (4, 'GOOGL', '2020-09-02', 1248.00, 1260.00, 1250000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (5, 'GOOGL', '2020-09-15', 1251.00, 1275.00, 1180000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (6, 'GOOGL', '2020-09-28', 1240.00, 1248.00, 990000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (7, 'NFLX', '2020-09-03', 470.00, 472.00, 780000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (8, 'NFLX', '2020-09-14', 480.00, 490.00, 760000);
INSERT INTO stock (id, code, date, open, close, volume) VALUES (9, 'NFLX', '2020-09-21', 495.00, 505.00, 740000);

DELETE FROM employee_skill;
DELETE FROM employee;
DELETE FROM skill;
DELETE FROM department;

INSERT INTO department (dp_id, dp_name) VALUES (1, 'Engineering');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Operations');

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'SQL');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'Spring Boot');

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (1, 'Anita', 60000.00, 1, '1992-03-10', 1);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3);