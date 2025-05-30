# Write your MySQL query statement below
select 
    Employee.name, Bonus.bonus
FROM
    Employee left join Bonus
ON
    Employee.empId  = Bonus.empId
WHERE
    Bonus.bonus < 1000 OR Bonus.empId IS NULL;