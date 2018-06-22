create table product_category
(
   id integer not null,
   description varchar(255) not null,
   display_name varchar(255) not null,  
   primary key(id)
);
alter table product_category alter id integer not null auto_increment;

create table product_subcategory
(
   id integer not null,
   description varchar(255) not null,
   display_name varchar(255) not null,
   product_cat_id integer not null,
   primary key(id),
   foreign key (product_cat_id) references product_category(id)
);
alter table product_subcategory alter id integer not null auto_increment;


create table product
(
   id integer not null,
   description varchar(255) not null,
   display_name varchar(255) not null,
   sku varchar(255) not null,
   product_subcat_id integer not null,
   primary key(id),
   foreign key (product_subcat_id) references product_subcategory(id)
);
alter table product alter id integer not null auto_increment;