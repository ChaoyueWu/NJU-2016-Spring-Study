SELECT DATE_FORMAT(o.orderTime,"%y-%m-%d") ,sum(o.realTotal) FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid
where MONTH(o.orderTime)=5 and WEEKDAY(o.orderTime)=3 and o.sid = 6
group by DATE_FORMAT(o.orderTime,"%y-%m-%d") 
order by sum(o.realTotal) asc limit 1