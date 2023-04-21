DROP TABLE IF EXISTS cars, users;

CREATE TABLE IF NOT EXISTS users
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY,
    name         VARCHAR,
    email        VARCHAR NOT NULL UNIQUE,
    phone_number VARCHAR NOT NULL,
    created      TIMESTAMP,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cars
(
    id              BIGINT GENERATED ALWAYS AS IDENTITY,
    stamp           VARCHAR     NOT NULL,
    model           VARCHAR     NOT NULL,
    year            INT         NOT NULL,
    transmission    VARCHAR(14) NOT NULL,
    car_body        VARCHAR(10) NOT NULL,
    car_color_body  VARCHAR(10) NOT NULL,
    engine_capacity VARCHAR(3)  NOT NULL,
    fuel_type       VARCHAR(13) NOT NULL,
    drive           VARCHAR(15) NOT NULL,
    wheel           VARCHAR(6)  NOT NULL,
    state_number    VARCHAR(9)  NOT NULL,
    owner           BIGINT      NOT NULL,
    date_added      TIMESTAMP,
    CONSTRAINT pk_cars PRIMARY KEY (id),
    CONSTRAINT fk_owner FOREIGN KEY (owner) REFERENCES users (id) ON DELETE CASCADE
)
