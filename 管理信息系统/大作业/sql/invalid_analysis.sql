SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o 
where o.isValid = 0