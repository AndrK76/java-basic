insert into questions (query) values 
	('В файл с каким расширением компилируется java-файл?'),
	('С помощью какой команды git можно получить полную копию удаленного репозитория?'),
	('Какой применяется цикл, когда не известно количество итераций?')
;

select * from questions q 
;

insert into answer_options(question_id, answer) values
	(1, 'cs'),	(1,'java'),	(1, 'class'),(1,'exe'),
	(2,'commit'), (2,'push'), (2, 'clone'), (2, 'copy'),
	(3,'while'), (3,'for'), (3, 'loop')
;	

select q.*,a.id,a.answer
from questions q
	left join answer_options a on q.id = a.question_id
;

update questions set valid_option=3 where id=1
;
update questions set valid_option=7 where id=2
;
update questions set valid_option=9 where id=3
;
commit
;
