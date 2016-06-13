SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total,
format(sum(realTotal),2)as realTatol
FROM desserthouse.`order`
where isValid = 1 
group by DATE_FORMAT(orderTime,'%Y-%m-%d')