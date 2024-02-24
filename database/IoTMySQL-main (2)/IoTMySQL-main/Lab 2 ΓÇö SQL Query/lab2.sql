USE labor_sql;

-- 1 --
SELECT *
FROM outcome
WHERE point = 2 
ORDER BY outcome.out;

-- 2 --
SELECT * 
FROM ships 
WHERE name LIKE "%o";

-- 3 --
SELECT laptop.*, product.maker 
FROM laptop 
INNER JOIN product ON 
laptop.model = product.model 
WHERE speed < 500;

-- 4 --
SELECT distinct maker
FROM product 
WHERE type = 'PC' AND maker = ANY
(SELECT maker 
FROM product
WHERE type = "Laptop");

-- 5 --
SELECT maker, sp.model
(SELECT speed FROM laptop WHERE module = product.model LIMIT 1) AS sp,
FROM product
WHERE type = 'PC';

-- 6 --
SELECT DATE_FORMAT(battles.date, '%Y.%m.%d') AS Time
FROM battles

-- 7 --
SELECT battle, COUNT(ship)
FROM outcomes
WHERE battle = ALL(

-- 8 --
SELECT class_ship.name, country, numGuns
FROM classes
JOIN (SELECT name, class FROM ships JOIN outcomes ON ships.name = outcomes.ship WHERE result = "damaged") class_ship
ON class_ship.class = classes.class

-- 10 --
SELECT ROUND(AVG(price), 2) as AVG_price, product.maker, "PC" as type
FROM pc
INNER JOIN product ON pc.model = product.model
UNION
SELECT ROUND(AVG(price), 2), product.maker, "Laptop" as type
FROM laptop
INNER JOIN product ON laptop.model = product.model
WHERE product.maker = "A";
