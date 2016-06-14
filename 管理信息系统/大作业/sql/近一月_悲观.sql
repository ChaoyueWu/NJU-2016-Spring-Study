select d.did,d.name, ifnull(d1.amount,0),d.price from dessert d left join 
(select od1.did as did,sum(od1.amount) as amount  from `order` o1 join orderdetail od1 on o1.oid = od1.oid,
	(SELECT DATE_FORMAT(o.orderTime,'%y-%m-%d') as dt FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid
	where MONTH(o.orderTime)=5 and WEEKDAY(o.orderTime)=3 and o.sid = 6 
	group by DATE_FORMAT(o.orderTime,'%y-%m-%d') 
	order by sum(o.realTotal) asc limit 1) dtt
	where DATE_FORMAT(o1.orderTime,'%y-%m-%d')=dtt.dt
    group by od1.did) d1 on d.did=d1.did