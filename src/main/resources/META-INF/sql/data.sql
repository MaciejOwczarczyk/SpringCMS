use CMS;

insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');
insert into authors (firstName, lastName) VALUES ('firstName', 'lastName');

insert into articles (content, createdOn, draft, title, author_id) VALUES ('kskksksakskskakakakakakaks', 20180101, false, 'title', 1);
insert into articles (content, createdOn, draft, title, author_id) VALUES ('kskksksakskskakakakakakaks', 20170101, false, 'title1', 2);
insert into articles (content, createdOn, draft, title, author_id) VALUES ('kskksksakskskakakakkakaks', 20190101, false, 'title2', 3);
insert into articles (content, createdOn, draft, title, author_id) VALUES ('kskksksskskakakakakakaks', 20120101, false, 'title3', 3);
insert into articles (content, createdOn, draft, title, author_id) VALUES ('kskksksakskskaakakakaks', 20181201, false, 'title4', 4);
insert into articles (content, createdOn, draft, title, author_id) VALUES ('kskksksakskskakakakakakaks', 20171101, false, 'title5', 5);


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