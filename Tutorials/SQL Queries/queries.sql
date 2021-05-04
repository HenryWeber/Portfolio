use university;

select dept_name, avg(salary) as avg_salary
from instructor
group by dept_name
having avg(salary) > 4200;

select course_id, semester, year, sec_id, avg(tot_cred)
from takes natural join student
where year=2009
group by course_id, semester, year, sec_id
having count(ID) >= 2;

select dept_name, avg_salary
from (select dept_name, avg(salary)
		from instructor
        group by dept_name)
        as dept_avg (dept_name, avg_salary)
        where avg_salary > 42000;
        

select distinct course_id
from section
where semester='Fall' and year=2009 and
course_id not in (select course_id
				  from section
                  where semester='Spring' and year=2010);
                  
select *
from student join takes using(ID);

select *
from student inner join takes using(ID);

create view departments_total_salary(dept_name, total_salary) as
select dept_name, sum(salary)
from instructor
group by dept_name;

select T.name, S.course_id
from instructor as T, teaches as S
where T.ID = S.ID;

select dept_name
from department
where building like '%Watson%';

select dept_name, count(distinct ID) as instr_count
from instructor natural join teaches
where semester='Spring' and year=2010
group by dept_name;

select dept_name
from instructor
group by dept_name
having avg(salary) >= all (select avg(salary)
							from instructor
                            group by dept_name);



                 

                  