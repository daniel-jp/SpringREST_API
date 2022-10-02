create table delivery (
    id	 bigint not null auto_increment,
    end_date	datetime,
    order_date	datetime not null,
    rate	decimal(10,2) not null,
    recipient_apartment varchar(255) not null,
    recipient_district	varchar(30) not null,
    recipient_name	varchar(50) not null,
    recipient_nomber	varchar(30) not null,
    recipient_street varchar(50) not null,
    client_id bigint not null,

	primary Key (id)
);
alter table delivery add constraint fk_delivery_client
foreign key (client_id) references client (id)