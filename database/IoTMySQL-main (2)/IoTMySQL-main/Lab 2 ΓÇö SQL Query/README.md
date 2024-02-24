# Lab 2 (Create Query for Database)

### Task

`
According to the task, write SQL queries for selection of necessary data and statistical information from databases, that are specified in the application, and perform these requests to the database in the graphic MySQL Workbench tool, check for operability and correctness of received data.
`

### All Queries

1. DB **"Firm priy. recycled materials"**. Display information about issuance money at the reception point No. 2 of the **Outcome table**. Output data according to forge by growth by column out.

2. Database **"Ships"**. Find all: ships with class names ending in with the letter 'o'.

3. Database **"Comp. firm"**. Find laptop manufacturers with processor no above *500 MHz*. Output: maker.

4. Database **"Comp. firm"**. Find manufacturers that release at the same time PCs and laptops *(use keyword ANY)*. Display maker.

5. Database **"Comp. firm"**. Find PC manufacturers that would produce laptops with a speed of 500 MHz and below. Output: maker.

6. Database **"Ships"**. From the Battles table, output the dates in the following format: `year.month.day`, for example 2001.02.21 (no time format).

7. DB **"Ships"**. List the battles in which, at least, two ships of the same country *(Choose a country through the Ships table, and the names of the ships for the Outcomes table, which are missing in the Ships table, do not take into account)*. Display: battle name, country, number of ships.

8. DB "Ships". State the name, country, and number of guns of the ships which were damaged in battles. Output: ship, country, numGuns. *(Hint: use subqueries as computational ones columns)*

9. Database **"Comp. firm"**. Get the summary set for the Product table
in the form of a table with columns maker, printer, in which for each
the producer must indicate whether he produces `('yes')` or not `('no')` appropriate type of products. In the first case `('yes')` additionally indicate next to it in round brackets the total amount available *(that is, what located in the Printer table)* of products, for example **'yes(2)'**. *(Hint: use subqueries as calculated columns and **CASE** operator)*

10. Database **"Comp. firm"**. Find the average price of PCs and laptops that produced by manufacturer 'A'. Output: one total average price. *(Hint: use the UNION operator)*