create database sms;
use sms;

create table customer(
	customer_id int auto_increment primary key,
    customer_name varchar(255) not null
);

create table employee(
	employee_id int auto_increment primary key,
    employee_name varchar(255) not null,
    salary decimal(10,2) not null,
    supervisor_id int,
    foreign key (supervisor_id) references employee(employee_id)
);

create table product(
	product_id int auto_increment primary key,
    product_name varchar(255) not null,
    list_price decimal(10,2) not null
);

create table orders(
	order_id int auto_increment primary key,
    order_date datetime not null,
    customer_id int not null,
    employee_id int not null,
    total decimal(10,2),
    foreign key (customer_id) references customer(customer_id),
    foreign key (employee_id) references employee(employee_id)
);

create table lineItem(
	order_id int not null,
    product_id int not null,
    quantity int not null,
    price decimal(10,2),
    primary key(order_id, product_id),
	foreign key (order_id) references orders(order_id),
	foreign key (product_id) references product(product_id)
);

-- 1 List all customers consist of customer id, customer name in the database, returns a list with all customers in the order table. 
SELECT DISTINCT c.customer_id, c.customer_name 
FROM Customer c
INNER JOIN Orders o ON c.customer_id = o.customer_id;

-- 2 List all orders consist of order id, order date, customer id, employee id, total for a customer, returns a list with all the orders for a given customer id. 
select order_id, order_date, customer_id, employee_id, total 
from Orders 
where customer_id = 1;

-- 3 List all line items for an order, returns a list with all line items for a given order id. 
select * 
from LineItem 
where order_id = 1;

-- 4 Compute order total (quantity * price) from the line items for a given order id. You must use an User Define Function. 
DELIMITER //
CREATE FUNCTION ComputeOrderTotal(p_order_id INT) 
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE v_total DECIMAL(10,2);
    SELECT SUM(quantity * price) INTO v_total 
    FROM LineItem 
    WHERE order_id = p_order_id;
    
    RETURN COALESCE(v_total, 0);
END //
DELIMITER ;

-- 5 Add a customer into the database, you must use a Stored Procedure. 









