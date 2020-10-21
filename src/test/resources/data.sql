DROP TABLE IF EXISTS user;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:testdata/visa_app_data.csv');

DROP TABLE IF EXISTS demo;
CREATE TABLE demo AS SELECT * FROM CSVREAD('classpath:testdata/demo_app_data.csv');