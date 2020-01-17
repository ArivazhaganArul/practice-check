-- Include table data insertion, updation, deletion and select scripts

-- --------------------------------------------------------------------------
-- Insert Values in menu_item
-- --------------------------------------------------------------------------
insert into menu_item values(1,'Biriyani',99.0,'Yes','2017-03-15','Main Course','Yes'),
(2, 'Burger', 129.00, 'Yes', '2017-12-23','Main Course', 'No'),
(3, 'Pizza', 149.00, 'Yes', '2018-08-21','Main Course', 'No'),
(4, 'French Fries', 57.00, 'No', '2017-07-02','Starters', 'Yes'),
(5, 'Chocolate Brownie', 32.00, 'Yes', '2022-11-02','Dessert', 'Yes');

-- --------------------------------------------------------------------------
-- Display Admin menu_item
-- --------------------------------------------------------------------------

select*from menu_item;

-- --------------------------------------------------------------------------
-- To Update menu_item
-- --------------------------------------------------------------------------

UPDATE menu_item set me_name = 'Sandwich' where me_id=1;

-- --------------------------------------------------------------------------
-- Insert Values in user
-- --------------------------------------------------------------------------

INSERT INTO user(us_name) VALUES('Vinod'),('Vibu'); 

-- --------------------------------------------------------------------------
-- Display all Data from user
-- --------------------------------------------------------------------------

select*from user;

delete from user;

-- --------------------------------------------------------------------------
-- customer menu item list
-- --------------------------------------------------------------------------

select me_name, me_free_delivery, me_price, me_category from menu_item
where me_active ='yes' and me_date_of_launch <= (select(curdate()));


-- --------------------------------------------------------------------------
-- Insert Values in cart
-- --------------------------------------------------------------------------

insert into cart(ct_us_id,ct_pr_id) values (1,1);
insert into cart(ct_us_id,ct_pr_id) values (1,3);
insert into cart(ct_us_id,ct_pr_id) values (1,3);
insert into cart(ct_us_id,ct_pr_id) values (1,3);


-- --------------------------------------------------------------------------
-- View cart items
-- --------------------------------------------------------------------------

select me_name,me_free_delivery, me_price  from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;
	
-- --------------------------------------------------------------------------
-- View cart total
-- --------------------------------------------------------------------------

select sum(me_price) as Total from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- -----------------------------------------------------
-- view cart
-- ------------------------------------------------------

select * from cart;

-- -----------------------------------------------------
-- Delete Item From cart
-- ------------------------------------------------------

delete from cart where ct_us_id=1 and ct_pr_id=1 limit 1 ;

-- --------------------------------------------------------------------------
-- View cart items after delete
-- --------------------------------------------------------------------------

select me_name,me_free_delivery, me_price  from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- --------------------------------------------------------------------------
-- View total after delete
-- --------------------------------------------------------------------------

select sum(me_price) as Total from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- -----------------------------------------------------
-- Delete cart
-- ------------------------------------------------------

delete from cart;



