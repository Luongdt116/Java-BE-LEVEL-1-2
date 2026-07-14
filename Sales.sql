CREATE DATABASE Sales;
use Sales;
create table employees (
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(10) NOT NULL,
    birth_date DATE,
    supervisor_id INT
);

create table orders (
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT, 
    employee_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

create table customers(
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    contact_name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(10),
    country VARCHAR(50)
);

Insert into customers (customer_name, contact_name, address, city, postal_code, country) values 
('Trần Bình', 'Trọng', 'Quận 8', 'HCM', 70000, 'VN'),
('Tran Bao', 'An', 'Bình Thạnh', 'HCM', 70000, 'VN'),
('Tasty', 'Finn', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK');

INSERT INTO employees (employee_id, last_name, first_name, birth_date, supervisor_id) VALUES
(1, 'Nguyễn Trần Văn', 'An', '1990-01-01', NULL),
(2, 'Tran Bao', 'An', '1995-05-05', 1);

INSERT INTO orders (order_id, customer_id, employee_id, order_date) VALUES
(1, 2, 1, '2024-06-10 06:51:59');