--2--
create table Customer(
CustomerId int primary key,
Name nvarchar(50) not null,
City nvarchar(50) not null,
Country nvarchar(50) not null,
Phone nvarchar(15) not null,
Email nvarchar(50) not null,
);
create table CustomerAccount(
AccountNumber char(9) primary key,
CustomerId int foreign key references Customer(CustomerId),
Balance money,
MinAccount money not null,
);
create table CustomerTransaction(
TransactionId int primary key,
AccountNumber char(9) not null foreign key references CustomerAccount(AccountNumber),
TranssactionDate smalldatetime not null,
Amount money not null,
DepositorWithdraw bit not null,
);

--3--

insert into Customer(CustomerId,Name,City,Country,Phone,Email) values
(1,'Nguyen Thi Nu','Da Nang','Viet Nam','098329572042','zxcvbnm@gmail.com'),
(2,'Trinh Cong Son','LonDon','England','089287547856','abcxyz@gmail.com'),
(3,'Do Thi Lan','Ha Noi','Viet Nam','03797284629','nguyena1@gmail.com');

insert into CustomerAccount(AccountNumber,CustomerId,Balance,MinAccount) values
('752892749',1,3000000,50),
('749274932',2,1000000,100),
('729928492',3,500000,50);

insert into CustomerTransaction(TransactionId,AccountNumber,TranssactionDate,Amount,DepositorWithdraw) values
(1,'752892749','2019-10-11',2000,1),
(2,'749274932','2022-01-30',30000,0),
(3,'729928492','2023-09-24',400000,1);
--4--

select * from Customer where City = 'Ha Noi';

--5--

select A.Name,A.Phone,A.Email,B.AccountNumber,B.Balance from 
Customer A left join CustomerAccount B on A.CustomerId=B.CustomerId;

--6--

alter table CustomerTransaction add check (Amount  <= 1000000 and Amount > 0);

