create table books (id INTEGER PRIMARY KEY, name VARCHAR(50), author VARCHAR(50), subject VARCHAR(50), price FLOAT, isbn VARCHAR(50));

create table copies (id INTEGER PRIMARY KEY, rack INTEGER, status VARCHAR(50), bookid INTEGER, FOREIGN KEY(bookid) REFERENCES books(id));

create table users (id INTEGER PRIMARY KEY, name VARCHAR(50), email VARCHAR(50), phone VARCHAR(50), password VARCHAR(50), role VARCHAR(50));

create table payments (id INTEGER PRIMARY KEY, amount FLOAT, type VARCHAR(50), transaction_time VARCHAR(50), nextpayment_duedate VARCHAR(50), userid INTEGER, FOREIGN KEY(userid) REFERENCES users(id));

create table issuerecord (id INTEGER PRIMARY KEY, copyid INTEGER, FOREIGN KEY(copyid) REFERENCES copies(id), memberid INTEGER, FOREIGN KEY(memberid) REFERENCES users(id), issuedate VARCHAR(50), return_duedate VARCHAR(50), return_date VARCHAR(50), fine_amount FLOAT );