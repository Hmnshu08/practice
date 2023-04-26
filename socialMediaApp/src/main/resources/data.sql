insert into user_details (id,birthdate,name) 
values(1001,current_date(),'Himanshu');

insert into user_details (id,birthdate,name) 
values(1002,current_date(),'Mahesh');

insert into user_details (id,birthdate,name) 
values(1003,current_date(),'Varun');

insert into post(id,description, user_id)
values (12001,'I want to break free..', 1001);

insert into post(id,description, user_id)
values (12002,'Summer of 2005', 1002);

insert into post(id,description, user_id)
values (12003,'Somewhere I belong', 1001);

insert into post(id,description, user_id)
values (12004,'Breaking the Habit', 1003);