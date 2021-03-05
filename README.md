Basic

Question 1
select moviename, movietype from movie where movietype like 'drama%';

Question 2
select moviename from movie where heroname="Ayushmann";

Question 3
select count(moviename) from movie where length>18;

Question 4
select moviename from movie having min(length);

Question 5
select * from movie where language like't%';

Question 6
select moviename, heroname, heroine from movie where length=(select max(length) from movie);

Question 7
select moviename, heroname, heroine from movie where releasedate>"2018-03-15";

Question 8
select count(moviename) from movie where movietype="thriller";

Question 9
select moviename, heroname, heroine from movie where releasedate<"2018-03-15";

Question 10
select releasedate from movie where moviename="Zero";


Question 11
select heroname from movie where heroine="Amy";

Question 12
select count(moviename) from movie where month(releasedate)="10";

Question 13





Advance 

Question 1
select p.productionsid , p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionsid = m.productionid group by p.productionsid;

Question 2  
select p.ownername, p.productionsid , p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionsid = m.productionid group by p.productionsid having count(moviename)>=2;

Question 3 
select p.productionsid ,p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionsid = m.productionid group by p.productionsid ORDER BY `productionsid` DESC LIMIT 1;

Question 4
select p.productionname ,m.heroname, m.moviename from productions as p left join movie as m ON p.productionsid = m.productionid where ownername="Subaskaran";

Question 5
select m.heroname, m.moviename from productions as p left join movie as m ON p.productionsid = m.productionid where mod(p.productionsid,100)=82 ;
      
Question 6
select p.Ownername ,p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionsid = m.productionid group by p.productionsid Having count(m.moviename)=0 ; 
       
Question 7
select p.Ownername , p.Productionname from  movie as m right join productions as p ON  m.productionid =p.productionsid where m.Language!="Hindi" ;

Question 8


Question 9
select m.heroname from movie as m left join productions as p ON p.productionsid = m.productionid group by m.language DESC LIMIT 1;

Question 10




Question 11
select p.productionname, p.ownername from productions as p left join movie as m on p.productionsid = m.productionid group by p.productionsid having count(m.moviename)=0;
