select  DATE_FORMAT(orderTime,'%Y-%m-%d') as date,sum(amount) as amount,format(sum(realTotal),2) as total
from desserthouse.`order` as o join orderdetail as od on o.oid = od.oid
where od.did = 1 and o.isValid = 1
group by DATE_FORMAT(orderTime,'%Y-%m-%d')