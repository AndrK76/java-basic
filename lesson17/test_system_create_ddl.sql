create table QUESTIONS
(
ID SERIAL primary key,
QUERY VARCHAR(2000) not null,
VALID_OPTION INTEGER  
--Понимаю что неудобно инициализировать, но сточки зрения целостности без триггеров правильнее так
--для варианта с одним правильным ответом 
)
;

create table ANSWER_OPTIONS
(
ID SERIAL primary key,
QUESTION_ID integer not null,
ANSWER VARCHAR(2000) not null unique
--Как вариант здесь колонка с апризнаком правильного ответа, но тогда возможно будет установить её у нескольких записей
)
;

--Не знаю как в POSTGRE, но в Oracle FK без индекса потенциальная блокировка таблицы
--да и планы запросов здесь правильнее строить будет
create index ANSWER_OPTIONS_QUERY_IND on ANSWER_OPTIONS(QUESTION_ID) 
;

alter table ANSWER_OPTIONS add constraint ANSWER_OPTIONS_QUESTION_FK
	foreign key (QUESTION_ID) references QUESTIONS (ID) on delete cascade
;

create index QUESTIONS_OPTION_IND on QUESTIONS(VALID_OPTION);

alter table  QUESTIONS add constraint QUESTIONS_OPTION_FK
	foreign key (VALID_OPTION) references ANSWER_OPTIONS(ID) on delete set null
;	

commit;