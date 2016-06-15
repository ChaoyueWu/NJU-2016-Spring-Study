select DATE_FORMAT(o.orderTime,'%Y-%m'),count(o.oid),sum(o.realTotal)
from `order` o join member m on m.cid = o.cid
where m.level = 1
group by DATE_FORMAT(o.orderTime,'%Y-%m')