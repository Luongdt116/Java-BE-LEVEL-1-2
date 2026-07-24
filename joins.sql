-- SALES
-- 
update orders set customer_id = 2 where order_id = 1;

-- 1 Liệt kê danh sách các đơn hàng kèm theo mã số và tên của khách hàng đã đặt đơn đó.
select order_id, customers.customer_id, customer_name
from customers inner join orders
on customers.customer_id = orders.customer_id;

-- 2 Liệt kê danh sách tất cả các khách hàng kèm theo mã đơn hàng của họ.
select customers.customer_id, customer_name, orders.order_id
from customers LEFT JOIN orders
on orders.customer_id = customers.customer_id;

-- 3 Hiển thị danh sách nhân viên (gồm Mã nhân viên, Tên nhân viên) đi kèm với thông tin của người quản lý trực tiếp của nhân viên đó (Mã quản lý, Tên quản lý).
SELECT a.employee_id ,CONCAT(a.last_name,' ', a.first_name) as 'Employee Name'
	,b.employee_id AS 'Supervisor ID'
	,CONCAT(b.last_name,' ', b.first_name) AS 'Supervisor Name'
FROM employees a inner join employees b
on a.supervisor_id = b.employee_id; 

-- 4 Tìm và trả về danh sách các khách hàng đến từ cùng một quốc gia. Truy vấn này tiếp tục dùng kỹ thuật kết nối bảng với chính nó (Self Join bảng customers) để ghép nối những người có chung dữ liệu ở cột country
SELECT A.customer_id, A.customer_name, A.country
FROM customers A inner join customers B
on A.customer_id <> B.customer_id
Where A.country = B.country;

-- 5  Lấy báo cáo thông tin tổng hợp của các giao dịch, bao gồm: Mã đơn hàng, Tên khách hàng đặt mua, Tên nhân viên phụ trách bán hàng đó, và Thời gian đặt hàng.  
select
	order_id, customer_name,
	CONCAT(first_name, ' ', last_name) EmployeeName,
	order_date
from employees E INNER join orders O
on E.employee_id = O.employee_id
INNER JOIN customers C
on C.customer_id = O.customer_id;


-- BIKESTORES
-- 1 Retrieve the product name and list price from the "products" table along with the corresponding brand name from the "brands" table. Only include products with a list price greater than $1000.
select p.product_name, p.list_price, b.brand_name
from products p inner join brands b on p.brand_id = b.brand_id
where p.list_price > 1000; 

-- 2 Retrieve all customers from the "customers" table along with their corresponding orders from the "orders" table. Include only customers who have placed orders with an order status of “Completed" (order_status = 4)
select c.customer_id, c.first_name, c.last_name, o.order_id, o.order_status
from customers c inner join orders o on c.customer_id = o.customer_id
where o.order_status = 4;

-- 3 Retrieve the first and last names of employees along with the first and last names of their respective managers. Assume the "staffs" table contains a column "manager_id" that references another row in the same "staffs" table.
select a.first_name as employee_fname, a.last_name as employee_lname, a.email as employee_email,
	b.first_name as manager_fname, b.last_name as manager_lname, b.email as manager_email
from staffs a left join staffs b on a.manager_id = b.staff_id;

-- 4 Retrieve all products from the "products" table along with their corresponding brand names from the "brands" table. Include products even if they don't have a matching brand
select p.product_name, b.brand_name
from products p left join brands b on p.brand_id = b.brand_id;

-- 5 Retrieve the product name and model year from the "products" table along with the corresponding brand name from the "brands" table. Only include products with a model year of 2016 and above.
select p.product_name, p.model_year, b.brand_name
from products p inner join brands b on p.product_id = b.brand_id
where p.model_year >= 2016;

-- 6  Retrieve the order ID, product name, and quantity from the "order_items" table along with the corresponding product information from the "products" table.
select oi.order_id, p.product_name, oi.quantity
from order_items oi inner join products p on oi.product_id = p.product_id;

-- 7 Retrieve all products from the "products" table along with their corresponding category names from the "categories" table. Include all products, but limit the results to products in the 'Mountain Bikes' category.
select p.product_name, c.category_name
from products p inner join categories c on p.category_id = c.category_id
where c.category_name = 'Mountain Bikes';

-- 8 Retrieve the product name, list price, and category name from the "products" table along with the corresponding brand name from the "brands" table. Only include products where the list price is greater than $500 and the category name is 'Electric Bikes'
select p.product_name, p.list_price, c.category_name, b.brand_name
from products p 
inner join categories c on p.category_id = c.category_id
inner join brands b on p.brand_id = b.brand_id
where p.list_price > 500 and c.category_name = 'Electric Bikes';

-- 9 Retrieve all customers from the "customers" table along with their corresponding orders from the "orders" table. Include all customers, but only include orders where the shipped date is null.
select c.customer_id, c.first_name, c.last_name, o.order_id, o.shipped_date
from customers c left join orders o on c.customer_id = o.customer_id and o.shipped_date IS NULL;

-- 10 Retrieve the store name from the "stores" table along with the count of orders placed from each store. Include all stores, even if they haven't received any orders.
select s.store_name, count(o.order_id) as order_count
from stores s left join orders o on s.store_id = o.store_id
group by s.store_name;

-- 11 This query retrieves all orders for a specific store (store ID = 1) along with the staff who processed them
select o.order_id, s.first_name, s.last_name, o.order_date
from orders o inner join staffs s on o.staff_id = s.staff_id and o.store_id = 1;

-- 12 This query retrieves all customers who have placed orders in the year 2016
select concat(c.first_name, ' ',c.last_name) as customer_name, o.order_id, o.order_date
from customers c inner join orders o on c.customer_id = o.customer_id and o.order_date like '%2016%' ;


-- 13 This query retrieves employees and their corresponding orders, but only for orders placed within the last twelve months
select s.first_name, s.last_name, o.order_id, o.order_date
from staffs s inner join orders o on s.staff_id = o.staff_id 
where o.order_date >= (SELECT DATE_SUB(MAX(order_date), INTERVAL 12 MONTH) FROM orders);











