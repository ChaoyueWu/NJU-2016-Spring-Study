SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date, count(isOnline)as totalDeal,sum(total) as totalSum
FROM desserthouse.`order` 
where isValid = 1 and cid=0
group by DATE_FORMAT(orderTime,'%Y-%m-%d')