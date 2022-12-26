--Список вопросов с правильными ответами
select q.id query_id, q.query, a.id answer_id,a.answer,
	case when q.valid_option = a.id then 1 else null end valid_answer 
	from questions q
		left join answer_options a on a.question_id = q.id 
;	