--- DROP TABLE T_HT_MEAL_TYPE CASCADE CONSTRAINTS;
--- DROP SEQUENCE SQ_HT_MEAL_TYPE;

CREATE TABLE T_HT_MEAL_TYPE(
  meal_type_id NUMBER       NOT NULL,
  name         VARCHAR2(25) NOT NULL,
  description  VARCHAR2(50) DEFAULT NULL
);

CREATE SEQUENCE SQ_HT_MEAL_TYPE INCREMENT BY 1 START WITH 1;

ALTER TABLE T_HT_MEAL_TYPE ADD CONSTRAINT PK_HT_MEAL_TYPE PRIMARY KEY (meal_type_id);
ALTER TABLE T_HT_MEAL_TYPE ADD CONSTRAINT UN_HT_MEAL_TYPE_NAME UNIQUE (name);

---

--- DROP TABLE T_HT_MEASUREMENT_UNIT CASCADE CONSTRAINTS;

CREATE TABLE T_HT_MEASUREMENT_UNIT(
  unit_prefix VARCHAR2(5)  NOT NULL,
  name        VARCHAR2(25) NOT NULL,
  description VARCHAR2(50) DEFAULT NULL
);

ALTER TABLE T_HT_MEASUREMENT_UNIT ADD CONSTRAINT PK_HT_MEASUREMENT_UNIT PRIMARY KEY (unit_prefix);
ALTER TABLE T_HT_MEASUREMENT_UNIT ADD CONSTRAINT UN_HT_MEASUREMENT_UNIT_NAME UNIQUE (name);

---

--- DROP TABLE T_HT_FOOD CASCADE CONSTRAINTS;
--- DROP SEQUENCE SQ_HT_FOOD;

CREATE TABLE T_HT_FOOD(
  food_id     NUMBER        NOT NULL,
  unit_prefix VARCHAR2(5)   NOT NULL,
  amount      NUMBER(7,2)   NOT NULL,
  calories    NUMBER(7,2)   NOT NULL,
  name        VARCHAR2(100) NOT NULL,
  description VARCHAR2(255) DEFAULT NULL
);

CREATE SEQUENCE SQ_HT_FOOD INCREMENT BY 1 START WITH 1;

ALTER TABLE T_HT_FOOD ADD CONSTRAINT PK_HT_FOOD PRIMARY KEY (food_id);
ALTER TABLE T_HT_FOOD ADD CONSTRAINT UN_HT_FOOD_NAME UNIQUE (name);
ALTER TABLE T_HT_FOOD ADD CONSTRAINT FK_HT_FOOD_AND_MEASUREMENT_UNIT
  FOREIGN KEY (unit_prefix) REFERENCES T_HT_MEASUREMENT_UNIT (unit_prefix);

---

--- DROP TABLE T_HT_MEAL CASCADE CONSTRAINTS;
--- DROP SEQUENCE SQ_HT_MEAL;

CREATE TABLE T_HT_MEAL(
  meal_id      NUMBER    NOT NULL,
  user_id      NUMBER    NOT NULL,
  meal_type_id NUMBER    NOT NULL,
  date_time    TIMESTAMP NOT NULL
);

CREATE SEQUENCE SQ_HT_MEAL INCREMENT BY 1 START WITH 1;

ALTER TABLE T_HT_MEAL ADD CONSTRAINT PK_HT_MEAL PRIMARY KEY (meal_id);

ALTER TABLE T_HT_MEAL ADD CONSTRAINT FK_HT_MEAL_AND_MEAL_TYPE
  FOREIGN KEY (meal_type_id) REFERENCES T_HT_MEAL_TYPE (meal_type_id);

ALTER TABLE T_HT_MEAL ADD CONSTRAINT FK_HT_MEAL_AND_USER
  FOREIGN KEY (user_id) REFERENCES T_HT_USER (user_id) ON DELETE CASCADE;

---

--- DROP TABLE T_HT_FOOD_ITEM CASCADE CONSTRAINTS;
--- DROP SEQUENCE SQ_HT_FOOD_ITEM;

CREATE TABLE T_HT_FOOD_ITEM(
  food_id   NUMBER      NOT NULL,
  meal_id   NUMBER      NOT NULL,
  amount    NUMBER(7,2) NOT NULL,
  calories  NUMBER(7,2) NOT NULL
);

ALTER TABLE T_HT_FOOD_ITEM ADD CONSTRAINT PK_HT_FOOD_ITEM PRIMARY KEY (food_id, meal_id);

ALTER TABLE T_HT_FOOD_ITEM ADD CONSTRAINT FK_HT_FOOD_ITEM_AND_FOOD
  FOREIGN KEY (food_id) REFERENCES T_HT_FOOD (food_id);

ALTER TABLE T_HT_FOOD_ITEM ADD CONSTRAINT FK_HT_FOOD_ITEM_AND_MEAL
  FOREIGN KEY (meal_id) REFERENCES T_HT_MEAL (meal_id) ON DELETE CASCADE;

---

--- MODELO

INSERT INTO T_HT_MEAL (
  meal_id,
  user_id,
  meal_type_id,
  date_time
) VALUES (
  [IDENTIFICADOR DA REFEIÇÃO],
  [IDENTIFICADOR DO USUÁRIO],
  [IDENTIFICADOR DO TIPO DE REFEIÇÃO],
  '[DATA E HORA DA REFEIÇÃO]'
);

UPDATE T_HT_MEAL SET
  meal_type_id = [IDENTIFICADOR DO TIPO DE REFEIÇÃO],
  date_time = '[DATA E HORA DA REFEIÇÃO]'
WHERE user_id = [IDENTIFICADOR DO USUÁRIO]
  AND meal_id = [IDENTIFICADOR DA REFEIÇÃO];

INSERT INTO T_HT_FOOD_ITEM (
  food_id,
  meal_id,
  amount,
  calories
) VALUES (
  [IDENTIFICADOR DO ALIMENTO],
  [IDENTIFICADOR DA REFEIÇÃO],
  [QUANTIDADE DO ALIMENTO],
  [QUANTIDADE DE CALORIAS DO ALIMENTO]
);

UPDATE T_HT_FOOD_ITEM SET
  food_id = [IDENTIFICADOR DO ALIMENTO],
  amount = [QUANTIDADE DO ALIMENTO],
  calories = [QUANTIDADE DE CALORIAS DO ALIMENTO]
WHERE meal_id = [IDENTIFICADOR DA REFEIÇÃO];
