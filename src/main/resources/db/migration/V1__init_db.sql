CREATE TABLE client (
                        ID SERIAL PRIMARY KEY,
                        NAME VARCHAR(400) NOT NULL,
                        PASSWORD VARCHAR(1000) NOT NULL,
                        EMAIL VARCHAR(1000) NOT NULL,
                        CHECK (CHAR_LENGTH(NAME) >= 4)
);
