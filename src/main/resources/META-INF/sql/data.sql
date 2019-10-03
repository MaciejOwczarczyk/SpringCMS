use CMS;

insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');

insert into articles (content, createdOn, title, author_id) VALUES ('content', 20190101,'title', 1);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20180101,'title', 2);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20150101,'title', 3);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20140101,'title', 3);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20130101,'title', 4);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20110101,'title', 5);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20110101,'title', 5);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20110101,'title', 5);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20100101,'title', 5);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20110101,'title', 5);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20110101,'title', 5);
insert into articles (content, createdOn, title, author_id) VALUES ('content', 20110101,'title', 5);


insert into categories (description, name) values ('thriller', 'rodzaj')
insert into categories (description, name) values ('Thriller', 'Rodzaj');
insert into categories (description, name) values ('Thriller', 'Rodzaj');
insert into categories (description, name) values ('Thriller', 'Rodzaj');
insert into categories (description, name) values ('Thriller', 'Rodzaj');

insert into articles_categories (Article_id, categories_id) values (1,2);
insert into articles_categories (Article_id, categories_id) values (1,3);
insert into articles_categories (Article_id, categories_id) values (1,4);
insert into articles_categories (Article_id, categories_id) values (2,2);
insert into articles_categories (Article_id, categories_id) values (4,2);
insert into articles_categories (Article_id, categories_id) values (4,2);