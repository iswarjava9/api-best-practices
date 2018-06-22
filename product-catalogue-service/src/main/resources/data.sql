insert into product_category (id,description,display_name)values(1,'Category for electronics products','Electronics');
insert into product_category (id,description,display_name)values(2,'Category for clothes','Clothes');
insert into product_category (id,description,display_name)values(3,'Category for Books','Books');

insert into product_subcategory (id,description,display_name,product_cat_id)values(1,'mobiles desc','mobiles',1);
insert into product_subcategory (id,description,display_name,product_cat_id)values(2,'laptops desc ','laptops',1);
insert into product_subcategory (id,description,display_name,product_cat_id)values(3,'fiction desc','fiction',3);
insert into product_subcategory (id,description,display_name,product_cat_id)values(4,'textbooks desc','textbooks',3);
insert into product_subcategory (id,description,display_name,product_cat_id)values(5,'shirts desc','shirts',2);
insert into product_subcategory (id,description,display_name,product_cat_id)values(6,'jeans desc','jeans',2);

insert into product (id,description,display_name,sku,product_subcat_id)values(1,'13+13MP dual back camera (f/2.0 dual LED flash) and 8MP front facing camera with flash ','Moto G5s Plus (Lunar Grey 64GB) ','sku001',1);
insert into product (id,description,display_name,sku,product_subcat_id)values(2,'HP 15-bs145tu 15.6-inch FHD Laptop (8th Gen Intel Core i5-8250U/8GB/1TB/Free DOS/Integrated Graphics)','HP 15-bs145tu','sku002',2);
insert into product (id,description,display_name,sku,product_subcat_id)values(3,'Harry Potter','Harry Potter','sku003',3);
insert into product (id,description,display_name,sku,product_subcat_id)values(4,'Global marketing','Global marketing','sku004',4);
insert into product (id,description,display_name,sku,product_subcat_id)values(5,'SDiverse Solid Slim Fit men Cotton Formal Shirt ','Diverse Solid Slim Fit men Cotton Formal Shirt ','sku005',5);
insert into product (id,description,display_name,sku,product_subcat_id)values(6,'United Colors of Benetton men Skinny Fit Jeans ','United Colors of Benetton men Skinny Fit Jeans ','sku006',6);


