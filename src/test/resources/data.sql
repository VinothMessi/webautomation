DROP TABLE IF EXISTS user;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:testdata/testdata.csv');