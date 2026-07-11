DELETE FROM employee_skill;
DELETE FROM employee;
DELETE FROM skill;
DELETE FROM department;

INSERT INTO department (id, name) VALUES (1, 'Engineering');
INSERT INTO department (id, name) VALUES (2, 'Operations');
INSERT INTO department (id, name) VALUES (3, 'Human Resources');

INSERT INTO skill (id, name) VALUES (1, 'Java');
INSERT INTO skill (id, name) VALUES (2, 'SQL');
INSERT INTO skill (id, name) VALUES (3, 'Spring Boot');

INSERT INTO employee (id, name, salary, permanent, date_of_birth, em_dp_id) VALUES (1, 'Anita', 60000.00, true, '1992-03-10', 1);
INSERT INTO employee (id, name, salary, permanent, date_of_birth, em_dp_id) VALUES (2, 'Ravi', 72000.00, true, '1990-11-05', 1);
INSERT INTO employee (id, name, salary, permanent, date_of_birth, em_dp_id) VALUES (3, 'Meera', 50000.00, false, '1996-07-21', 2);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 2);