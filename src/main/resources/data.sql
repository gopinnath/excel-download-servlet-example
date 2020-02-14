DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  employee_id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  desingation VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO employee (first_name, last_name, desingation) VALUES
  ('Ram', 'Sharma', 'Manager'),
  ('Shyam', 'Sunder', 'Associate'),
  ('Krishna', 'Ahuja', 'Executive');