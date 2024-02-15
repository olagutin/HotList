CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL    NOT NULL,
    username varchar   NOT NULL,
    password varchar   NOT NULL,
    created  timestamp NULL,

    CONSTRAINT users_pk PRIMARY KEY (id),
    CONSTRAINT nickname_unique UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS notes
(
    id          SERIAL    NOT NULL,
    title       varchar   NOT NULL,
    description varchar   NOT NULL,
    completed   boolean   NOT NULL,
    created     timestamp NULL,

    CONSTRAINT notes_pk PRIMARY KEY (id)
);
