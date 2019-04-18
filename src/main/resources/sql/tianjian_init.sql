insert into user(id, user, name, phone, password, role) values(1, 'admin', 'admin', '', 'password', 'admin');
insert into area(id, area, superior) values(1, '北京', '');
insert into area(id, area, superior) values(2, '上海', '');
insert into area(id, area, superior) values(3, '广州', '');
insert into area(id, area, superior) values(4, '河南', '');
insert into area(id, area, superior) values(5, '郑州', '河南');
insert into area(id, area, superior) values(6, '洛阳', '河南');
insert into base_charge(id, area_id, charge) values(1, 1, '1.01');
insert into base_charge(id, area_id, charge) values(2, 2, '1.02');
insert into base_charge(id, area_id, charge) values(3, 3, '1.03');
insert into base_charge(id, area_id, charge) values(4, 4, '1.04');
insert into base_charge(id, area_id, charge) values(5, 5, '1.05');
insert into base_charge(id, area_id, charge) values(6, 6, '1.06');
insert into charge_type(id, type, charge, remark) values(1, '1', '50', '');
insert into charge_type(id, type, charge, remark) values(2, '2', '10', '');
insert into charge_type(id, type, charge, remark) values(3, '3', '20', '3');


