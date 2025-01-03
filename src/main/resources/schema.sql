CREATE TABLE users (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    age INT
);