insert into user(id, user, name, phone, password, role) values(1, 'admin', 'admin', '', 'password', 'admin');
insert into area(id, province, city, area) values(1, '北京市', '北京市', '海淀区');
insert into area(id, province, city, area) values(2, '北京市', '北京市', '朝阳区');
insert into area(id, province, city, area) values(3, '上海市', '上海市', '');
insert into area(id, province, city, area) values(4, '广州市', '广州市', '');
insert into area(id, province, city, area) values(5, '河南省', '漯河市', '临颍县');
insert into area(id, province, city, area) values(6, '河南省', '郑州市', '');
insert into area(id, province, city, area) values(7, '河南省', '许昌市', '');
insert into base_charge(id, area_id, charge) values(1, 1, '1.01');
insert into base_charge(id, area_id, charge) values(2, 2, '1.02');
insert into base_charge(id, area_id, charge) values(3, 3, '1.03');
insert into base_charge(id, area_id, charge) values(4, 4, '1.04');
insert into base_charge(id, area_id, charge) values(5, 5, '1.05');
insert into base_charge(id, area_id, charge) values(6, 6, '1.06');
insert into charge_type(id, type, charge, remark) values(1, '1', '50', '');
insert into charge_type(id, type, charge, remark) values(2, '2', '10', '');
insert into charge_type(id, type, charge, remark) values(3, '3', '20', '3');


