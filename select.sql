-- SALES

-- 1 To return all columns and rows 
select * from customers;

-- 2 Select all the different countries from the "Customers" table
select distinct country
from customers;

-- 3 Select all customers from VN 
select *
from customers
where country = 'VN';

-- 4  Lists the number of customers in each country
select country, count(customer_id) as NumberOfCustomers
from customers
group by country;

-- 5 Lists the number of customers in each country. Only include countries with more than 1 customer 
select country, count(customer_id) as NumberOfCustomers
from customers
group by country
having NumberOfCustomers > 1;

-- 6 Sort the customers alphabetical by CustomerName 
select customer_id, customer_name, country
from customers
order by customer_name;


-- BIKESTORES

-- 1 Retrieve the first name, last name, and email of all customers
select first_name, last_name, email
from customers;

select *from customers;
-- 2 Returns the customers located in California (state is CA)
select *
from customers
where state ='CA';

-- 3 Sorts the customers by their first names in ascending order
select *
from customers
order by first_name;

-- 4 Returns all the cities of customers located in California and the number of customers in each city 
select city, count(customer_id) AS customer_count
from customers
where state = 'CA'
group by city;

-- 5 Return the city in California which has more than ten customers
select city
from customers
where state = 'CA'
group by city
having count(customer_id) > 10;

select * from products;
-- 6 Retrieve the product name and model year from the "products" table where the list price is from 1000 to 2000
select product_name, model_year
from products
where list_price between 1000 and 2000;
 
select * from staffs;
-- 7 Retrieve the first name and email from the "staffs" table where the active status is 1
select first_name, email
from staffs
where active = 1;

-- 8 Retrieve the product name and brand ID from the "products" table where the model year is 2016 and the list price is greater than 1000
select product_name, brand_id
from products
where model_year = 2016 and list_price > 1000;

select * from orders;
-- 9 Retrieve the order ID and customer ID from the "orders" table where the shipped date is not null 
select order_id, customer_id
from orders
where shipped_date > 0;

select * from order_items;
-- 10 Retrieve the product ID, list price and quantity from the "order_items" table where the discount is greater than 0 and quantity equal 2
select product_id, list_price, quantity
from order_items
where discount > 0 and quantity = 2;

select * from stocks; 
-- 11 Find Stores with more than 5 Products in Stock and ordered by the number of products 
select store_id, count(product_id) as product_count
from stocks
group by store_id
having product_count > 5
order by product_count;

-- 12 This query retrieves customers whose email address ends with "@yahoo.com" and orders the result by customer name
select concat(first_name, ' ', last_name) as customer_name, email
from customers
where email like '%@yahoo.com'
order by customer_name;

select * from products;
-- 13 This query calculates the average list price of products for each category and includes only categories with an average price greater than 500, ordered by the average price in descending order.
select category_id, avg(list_price) as avg_price
from products
group by category_id
having avg_price > 500
order by avg_price desc;

-- 14 This query counts the total number of products for each brand and includes only brands that have more than 2 products, ordering the result by the total number of products in descending order.
select brand_id, count(product_id) as total_product
from products
group by brand_id
having total_product > 2
order by total_product desc;










