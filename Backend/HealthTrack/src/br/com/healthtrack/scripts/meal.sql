--- DROP TABLE T_HT_MEAL_TYPE  CASCADE CONSTRAINTS;
--- DROP SEQUENCE SQ_HT_MEAL_TYPE;

CREATE TABLE T_HT_MEAL_TYPE(
	meal_type_id NUMBER       NOT NULL,
	name         VARCHAR2(25) NOT NULL,
	description  VARCHAR2(50) DEFAULT NULL
);

CREATE SEQUENCE SQ_HT_MEAL_TYPE INCREMENT BY 1 START WITH 1;

ALTER TABLE T_HT_MEAL_TYPE ADD CONSTRAINT PK_HT_MEAL_TYPE PRIMARY KEY (meal_type_id);
ALTER TABLE T_HT_MEAL_TYPE ADD CONSTRAINT UN_HT_MEAL_TYPE_NAME UNIQUE (name);

INSERT INTO T_HT_MEAL_TYPE (meal_type_id, name) VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, 'café da manhã');
INSERT INTO T_HT_MEAL_TYPE (meal_type_id, name) VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, 'almoço');
INSERT INTO T_HT_MEAL_TYPE (meal_type_id, name) VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, 'jantar');
INSERT INTO T_HT_MEAL_TYPE (meal_type_id, name) VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, 'lanche');

---

--- DROP TABLE T_HT_MEASUREMENT_UNIT CASCADE CONSTRAINTS;

CREATE TABLE T_HT_MEASUREMENT_UNIT(
	unit_prefix VARCHAR2(5)  NOT NULL,
	name        VARCHAR2(25) NOT NULL,
	description VARCHAR2(50) DEFAULT NULL
);

ALTER TABLE T_HT_MEASUREMENT_UNIT ADD CONSTRAINT PK_HT_MEASUREMENT_UNIT PRIMARY KEY (unit_prefix);
ALTER TABLE T_HT_MEASUREMENT_UNIT ADD CONSTRAINT UN_HT_MEASUREMENT_UNIT_NAME UNIQUE (name);

INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('kg', 'kilograma');
INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('g', 'grama');
INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('ml', 'mililitro');
INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('l', 'litro');
INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('kcal', 'kilocaloria');
INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('cal', 'caloria');
INSERT INTO T_HT_MEASUREMENT_UNIT (unit_prefix, name) VALUES ('m', 'metro');

---

--- DROP TABLE T_HT_FOOD CASCADE CONSTRAINTS;
--- DROP SEQUENCE SQ_HT_FOOD;

CREATE TABLE T_HT_FOOD(
	food_id     NUMBER       NOT NULL,
	unit_prefix VARCHAR2(5)  NOT NULL,
  amount      NUMBER(7,2)  NOT NULL,
  calories    NUMBER(7,2)  NOT NULL,
	name        VARCHAR2(100) NOT NULL,
	description VARCHAR2(255) DEFAULT NULL
);

CREATE SEQUENCE SQ_HT_FOOD INCREMENT BY 1 START WITH 1;

ALTER TABLE T_HT_FOOD ADD CONSTRAINT PK_HT_FOOD PRIMARY KEY (food_id);
ALTER TABLE T_HT_FOOD ADD CONSTRAINT UN_HT_FOOD_NAME UNIQUE (name);
ALTER TABLE T_HT_FOOD ADD CONSTRAINT FK_HT_FOOD_AND_MEASUREMENT_UNIT
  FOREIGN KEY (unit_prefix) REFERENCES T_HT_MEASUREMENT_UNIT (unit_prefix)
  ON UPDATE CASCADE ON DELETE RESTRICT;

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 30, 198, 'Bacon frito', '2 cubos.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 100, 287, 'Picanha', '1 fatia.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
 VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 50, 371, 'Bolo de cenoura com cobertura de chocolate', '1 fatia.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
 VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 200, 1074, 'Chocolate meio-amargo', '1 unidade');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 100, 68, 'Gelatina', '1 porção.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 350, 230, 'Manga', '1 unidade.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 20, 4, 'Alface', '2 folhas.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 100, 139, 'Lasanha', '1 porção.');

INSERT INTO T_HT_FOOD (food_id, unit_prefix, amount, calories, name, description)
  VALUES (SQ_HT_FOOD.NEXTVAL, 'g', 140, 304, 'Pizza de mussarela', '1 fatia.');
