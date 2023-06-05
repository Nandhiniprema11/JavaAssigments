CREATE TABLE orders (
    ordernumber  NUMBER(5) NOT NULL,
    paymentstate VARCHAR(12),
    creationtime DATE,
    totalamount  NUMBER(5),
    PRIMARY KEY ( ordernumber )
);

CREATE TABLE customers (
    custid NUMBER(5) NOT NULL,
    cname  VARCHAR(20),
    phone  VARCHAR(20),
    PRIMARY KEY ( custid )
);

desc Customers;

ALTER TABLE orders
    ADD CONSTRAINT fk_cust_orders FOREIGN KEY ( custid )
        REFERENCES customers ( custid );

CREATE TABLE products (
    prodid NUMBER(5) NOT NULL,
    pname  VARCHAR(20),
    price  NUMBER(5),
    PRIMARY KEY ( prodid )
);

CREATE TABLE customers (
    custid NUMBER(5) NOT NULL,
    cname  VARCHAR(20),
    phone  VARCHAR(20),
    PRIMARY KEY ( custid )
);

CREATE TABLE products (
    prodid NUMBER(5) NOT NULL,
    pname  VARCHAR(20),
    price  NUMBER(5),
    PRIMARY KEY ( prodid )
);

CREATE TABLE orderdetail (
    ordernumber NUMBER(5) NOT NULL,
    prodid      NUMBER(5) NOT NULL,
    FOREIGN KEY ( ordernumber )
        REFERENCES orders ( ordernumber ),
    FOREIGN KEY ( prodid )
        REFERENCES products ( prodid )
);
   alter table Orders add custId number(5) NOT NULL;
alter table Orders add constraint fk_cust_orders FOREIGN KEY(custId) REFERENCES Customer(custId);

insert into Orders values(1,'Success','15-05-2022',2000,11);
insert into Orders values(2,'Success','15-01-2023',40000,11);
insert into Orders values(3,'Failed','11-07-2022',5000,12);
insert into Orders values(4,'Failed','07-09-2021',6000,14);
insert into Orders values(5,'Success','21-03-2021',4000,15);  

Commit;
Alter table orders drop column custid;           
            
 insert into OrderDetail values(1,101);
insert into OrderDetail values(1,102);
insert into OrderDetail values(2,101);
insert into OrderDetail values(3,102);
insert into OrderDetail values(4,104);
insert into OrderDetail values(5,105);           
            
insert into Products values(101,'Watch',2000);
insert into Products values(102,'Laptop',40000);
insert into Products values(103,'Mobile',8000);
insert into Products values(104,'Teddy',1000);
insert into Products values(105,'Dress',1500);       

select * from Products;
      
  SELECT * FROM Orders NATURAL JOIN Products NATURAL JOIN Customers;
SELECT custId, orderNumber FROM Customers INNER JOIN Orders USING (custID);
SELECT c.custId,cname, orderNumber FROM Customers c INNER JOIN Orders o ON c.custId = o.custId;
SELECT c.custId,cname, orderNumber,paymentState FROM Customers c LEFT OUTER JOIN Orders o 
   ON c.custId = o.custId where c.custId=13;   
   
   SELECT Orders.*, Products.*
FROM Orders 
JOIN OrderDetail
ON Orders.orderNumber = OrderDetail.orderNumber
JOIN Products
ON OrderDetail.prodId = Products.prodId;

SELECT DISTINCT c.cname AS "Customers who like Laptop"
FROM Customers  c JOIN Orders  o
ON c.custId = o.custId
JOIN OrderDetail  od
ON o.orderNumber = od.orderNumber
JOIN Products  p
ON od.prodId = p.prodId
WHERE p.pname = 'Laptop';

SELECT DISTINCT c.cname,p.pname
FROM OrderDetail o1
JOIN OrderDetail o2 ON o1.orderNumber = o2.orderNumber AND o1.prodId<> o2.prodId
JOIN Orders as o ON o.custId=c.custId
JOIN Products as p ON p.prodId=o2.prodId
JOIN customers as c ON c.custId = o.custId
WHERE o.custId = 12;
            
            