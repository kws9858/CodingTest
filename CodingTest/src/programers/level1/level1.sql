--모든 레코드 조회하기
SELECT * from animal_ins order by animal_id;

--최댓값 구하기
SELECT max(datetime) "시간" from animal_ins;

--이름이 없는 동물의 아이디
SELECT animal_id from animal_ins where name is null order by animal_id asc;

--역순 정렬하기
SELECT name, datetime from animal_ins order by animal_id desc;

--이름이 있는 동물의 아이디
SELECT animal_id from animal_ins where name is not null order by animal_id asc;

--아픈 동물 찾기
SELECT animal_id, name 
from animal_ins 
where intake_condition = 'Sick'
order by animal_id;

--어린 동물 찾기
SELECT animal_id, name FROM animal_ins where intake_condition != 'Aged';

--동물의 아이디와 이름
SELECT animal_id, name
from animal_ins
order by animal_id;

--여러 기준으로 정렬하기
SELECT animal_id, name, datetime
from animal_ins
order by name, datetime desc;

--상위 n개 레코드
SELECT name
from animal_ins
where datetime = (select min(datetime) from animal_ins);
