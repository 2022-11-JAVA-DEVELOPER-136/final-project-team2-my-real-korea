/**********************userinfo insert************************/

-- insert_user_info
insert into user_info(user_Id,password,name,nickname,phone,email,birth,address,gender,point,is_Admin) 
values('mrk111','mrk_1111','������','������','010-1111-1111','mrk111@korea.com','1999-11-11','����� ������ ���ﵿ',0,0,1);
insert into user_info(user_Id,password,name,nickname,phone,email,birth,address,gender,point,is_Admin) 
values('mrk222','mrk_2222','������','������','010-2222-2222','mrk222@korea.com','1998-12-12','�λ�� �ؿ�뱸',0,0,1);
insert into user_info(user_Id,password,name,nickname,phone,email,birth,address,gender,point,is_Admin) 
values('mrk333','mrk_3333','������','������','010-3333-3333','mrk333@korea.com','1997-10-10','���ֽ� ������',1,0,1);


-- insert_user_add_info

insert into user_add_info(introduce,alcohol,smoking,user_Id)
values('�ȳ��ϼ���. �������Դϴ�.',1,1,'mrk111')
insert into user_add_info(introduce,alcohol,smoking,user_Id)
values('�ȳ��ϼ���. �������Դϴ�.',0,1,'mrk222')
insert into user_add_info(introduce,alcohol,smoking,user_Id)
values('�ȳ��ϼ���. �������Դϴ�.',0,0,'mrk333')

-- insert_user_img

insert into user_img(user_img_no,user_img_url,user_id)
values(1,'img1.png','mrk111')
insert into user_img(user_img_no,user_img_url,user_id)
values(2,'img2.png','mrk222')
insert into user_img(user_img_no,user_img_url,user_id)
values(3,'img3.png','mrk333')