# Tables creation 
create table ratings ( 
   userid int, 
   itemid int, 
   rating int, 
   timestamp int, 
   primary key (userid, itemid)); 

create table items ( 
   itemid int primary key, 
   title text, #title和年份没有分开
   videodate text, 
   imdb text, 
   action boolean, 
   adventure boolean, 
   animation boolean, 
   childrens boolean, 
   comedy boolean, 
   crime boolean, 
   documentary boolean, 
   drama boolean, 
   fantasy boolean, 
   noir boolean, 
   horror boolean, 
   musical boolean, 
   mystery boolean, 
   romance boolean, 
   scifi boolean, 
   thriller boolean, 
   war boolean, 
   western boolean); 
 
create table users ( 
   userid int primary key, 
   age int, 
   gender char, 
   occupation text, 
   zip varchar); 
 
# Indexes creation 
create index usersdata_index on ratings (userid); 
create index itemsdata_index on ratings (itemid);

#如果是以\t分隔数据的话，可以用下面的命令导入数据库
#load data infile 'E:\\DevProj\\workspace\\ml\\data\\ml-100k\\u.item' into table item