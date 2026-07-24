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
delimiter //
create function ComputerOrderTotal(p_order_id int)
returns decimal(10,2)
deterministic
begin
	declare v_total decimal(10,2);
    select sum(quantity * price) into v_total
    from lineitem
    where order_id = p_order_id;
    
    return coalesce(v_total, 0);
end //
delimiter ;


-- 5 Add a customer into the database, you must use a Stored Procedure. 
delimiter //
create procedure AddCustomer(in p_customer_name varchar(255))
begin
	insert into customer(customer_name)
    values (p_customer_name);
end // 
delimiter ;

-- 6 Delete a customer from the database, make sure to also delete Orders and LineItem for the deleted customer. You must use a Stored Procedure. 
delimiter //
create procedure DeleteCustomer(in p_customer_id int)
begin
	declare exit handler for sqlexception
	begin
		rollback ;
	end ;

	start transaction ;

	delete lineitem from lineitem li
    inner join  orders o on li.order_id = o.order_id
    where o.customer_id = p_customer_id;
    
    delete from orders
	where customer_id = p_customer_id;
    
    delete from customer
    where customer_id = p_customer_id;

	commit ;
end //
delimiter ;

-- 7 Update a customer in the database, you must use a Stored Procedure. 
delimiter //
create procedure UpdateCustomer(
	in p_customer_id int,
    in p_new_name varchar(255)
)
begin
	update customer
    set customer_name = p_new_name
    where customer_id = p_customer_id;
end //
delimiter ;

-- 8 Create an order into the database. 
insert into Orders (order_date, customer_id, employee_id, total) 
values (NOW(), 1, 1, 0.00);

-- 9 Create a LineItem into the database. 
insert into LineItem (order_id, product_id, quantity, price) 
values (1, 1, 2, 150.50);

-- 10 Update an order total into the database.
delimiter //
create trigger After_Isert_LineItem
after insert on lineitem
for each row
begin
	update orders
    set total = ComputerOrderTotal(new.order_id)
    where order_id = new.order_id;
end //
delimiter ;






