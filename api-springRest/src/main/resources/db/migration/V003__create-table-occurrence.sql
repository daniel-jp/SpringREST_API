create table Occurrence(
    id	 bigint not null auto_increment,
    delivery_id bigint not null,
	description text not null,
	createDate datetime,
	primary Key (id)
);
alter table Occurrence add constraint fk_occurrence_delivery
foreign key (delivery_id) references delivery (id)