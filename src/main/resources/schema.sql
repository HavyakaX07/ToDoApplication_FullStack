CREATE SEQUENCE user_id_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE todo_id_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
    user_id bigint DEFAULT NEXTVAL('user_id_sequence') PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    salt VARCHAR(255)
);

CREATE TABLE todos (
    todo_id bigint DEFAULT NEXTVAL('todo_id_sequence') PRIMARY KEY,
    todo_name VARCHAR(255),
    todo_desc TEXT,
    todo_end_date DATE,
    todo_done BOOLEAN,
    user_id bigint,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

--Only for dev
insert into users(username,password,salt)
values ('Hegde','1234','qwerty');

