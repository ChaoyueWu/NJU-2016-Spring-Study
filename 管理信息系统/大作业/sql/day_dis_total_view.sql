SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total,
format(sum(realTotal),2)as realTatol
FROM desserthouse.`order` o join shop s on o.sid = s.sid
where isValid = 1 and s.disid = 8
group by DATE_FORMAT(orderTime,'%Y-%m-%d')