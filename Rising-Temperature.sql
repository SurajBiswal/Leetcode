# Write your MySQL query statement below
select A.id 
from Weather as A inner join Weather as B
on A.recordDate = B.recordDate +  INTERVAL 1 DAY and A.temperature  >B.temperature;