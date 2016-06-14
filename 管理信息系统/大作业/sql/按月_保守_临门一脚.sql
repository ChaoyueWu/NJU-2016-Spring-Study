select v.did,CAST( avg(v.amount) AS signed) as amount from 
(SELECT DATE_FORMAT(o.orderTime,'%y-%m-%d') as dt,od.did as did,sum(od.amount) as amount FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid
where MONTH(o.orderTime)=5 and WEEKDAY(o.orderTime)=3 and o.sid = 6 
group by DATE_FORMAT(o.orderTime,'%y-%m-%d'), od.did) as v
group by v.did