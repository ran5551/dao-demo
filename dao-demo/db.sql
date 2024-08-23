drop table if exists books;
create table books(
                      id int primary key auto_increment,
                      title varchar(20),
                      price decimal(5,2),
                      quantity int
);
insert into books (title, price, quantity) values ("book1",10.00, 100);
insert into books (title, price, quantity) values ("book2",20.00, 200);
insert into books (title, price, quantity) values ("book3",30.00, 300);