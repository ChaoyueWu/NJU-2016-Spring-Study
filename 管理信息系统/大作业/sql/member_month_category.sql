select v1.cid,ifnull(v1.deal,0),ifnull(v1.total,0),ifnull(v2.deal,0),ifnull(v2.total,0) from 
(SELECT m.cid, o1.deal,o1.total 
from desserthouse.member m left join 
(SELECT o.cid,count(*) as deal,sum(o.realTotal) as total FROM desserthouse.`order` o where o.isValid=1 and MONTH(orderTime)=5 and o.cid!=0
group by o.cid) o1 on o1.cid = m.cid
where m.level = 3) as v1
join 
(SELECT m.cid, o1.deal,o1.total 
from desserthouse.member m left join 
(SELECT o.cid,count(*) as deal,sum(o.realTotal) as total FROM desserthouse.`order` o where o.isValid=1 and MONTH(orderTime)=3 and o.cid!=0
group by o.cid) o1 on o1.cid = m.cid
where m.level = 3) as v2
on v1.cid = v2.cid