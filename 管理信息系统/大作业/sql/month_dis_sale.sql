select * from 
(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total,
format(sum(realTotal),2)as realTatol
FROM desserthouse.`order` o 
where isValid = 1
group by DATE_FORMAT(orderTime,'%Y-%m')) as m 
left join 
(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date, count(isOnline)as notMemberDeal,sum(total) as notMemberSum
FROM desserthouse.`order` o
where isValid = 1 and cid=0 
group by DATE_FORMAT(orderTime,'%Y-%m')) as nm 
on m.date=nm.date