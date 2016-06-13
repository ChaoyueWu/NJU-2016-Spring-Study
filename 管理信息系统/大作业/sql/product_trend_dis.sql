select  DATE_FORMAT(orderTime,'%Y-%m-%d') as date,sum(amount) as amount,format(sum(realTotal),2) as total
from desserthouse.`order` as o join orderdetail as od on o.oid = od.oid join shop s on s.sid = o.sid
where od.did = 1 and o.isValid = 1 and s.disid = 8
group by DATE_FORMAT(orderTime,'%Y-%m-%d')