DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE restaurants
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    restaurant_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE dishes
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date_time     TIMESTAMP    NOT NULL,
    restaurant_id INTEGER      NOT NULL,
    description   VARCHAR(100) NOT NULL,
    price         MONEY        NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR(100)                      NOT NULL,
    email      VARCHAR(100)        DEFAULT NULL,
    password   VARCHAR(100)                      NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE votes
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id        INTEGER   NOT NULL,
    restaurant_id  INTEGER   NOT NULL,
    vote_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
--CREATE UNIQUE INDEX votes_unique_id_vote_date ON votes (user_id, vote_date);