SHOW DATABASES;
CREATE DATABASE simplesearch;
USE simplesearch;

CREATE TABLE pages(
   pageTitle VARCHAR(200),
   pageLink TEXT,
   pageText MEDIUMTEXT
);


SELECT * FROM pages;

SELECT pageTitle,pageLink,(LENGTH(LOWER(pageText))-LENGTH(REPLACE(LOWER(pageText),'java','')))/LENGTH('java') AS count_occurence 
FROM pages ORDER BY 
count_occurence DESC LIMIT 30;

CREATE TABLE `history`(
   keyword TEXT,
   link TEXT
);

SELECT * FROM `history`;
SHOW TABLES;




