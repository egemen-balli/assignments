-- Use this template for your se2222 project
-- Before submission be sure that your file is named like [your_ID].sql
-- You will get minus 20% of total score for each day after due date
-- Name:EGEMEN BALLI
-- ID:20070006005

-- 1. Create and use a schema for your project named SE2222_[your_ID]
CREATE SCHEMA SE2222_20070006005;
USE SE2222_20070006005;
-- 1. Definitions:
-- All table definitions of your project including any constraints
-- Before each table creation give a short explanation of the table

-- Boat table holds boat values
CREATE TABLE Boat(
BoatName VARCHAR(20) PRIMARY KEY,
Capacity INT,
Expense INT);

-- Traveller table holds values that represent travellers of boat
CREATE TABLE Traveller(
TravellerNumber INT PRIMARY KEY,
Name VARCHAR(20),
Destination VARCHAR(20),
BoatName VARCHAR(20),
FOREIGN KEY(BoatName) REFERENCES Boat(BoatName));

-- Cargo table holds cargo values of travellers
CREATE TABLE Cargo(
CargoNumber INT PRIMARY KEY,
Weight INT);

-- Seaport table holds seaports that boats will board
CREATE TABLE Seaport(
Location VARCHAR(20) PRIMARY KEY,
Budget INT,
Capacity INT);

-- Captain table holds captain value of a boat
CREATE TABLE Captain(
CaptainName VARCHAR(20),
Salary INT,
Experience INT,
BoatName VARCHAR(20),
Location VARCHAR(20),
PRIMARY KEY(CaptainName, Salary, Experience, BoatName),
FOREIGN KEY(BoatName) REFERENCES Boat(BoatName),
FOREIGN KEY(Location) REFERENCES Seaport(Location));

-- Crew table holds crew's member values
CREATE TABLE Crew(
CrewName VARCHAR(20) PRIMARY KEY,
Section VARCHAR(20),
Salary INT);

-- TravelDate table holds date values of boat's travel date
CREATE TABLE TravelDate(
Day DATE,
StartTime INT,
EndTime INT,
PRIMARY KEY(Day, StartTime, EndTime));

-- Route table holds route values that boats will follow
CREATE TABLE Route(
StartingPoint VARCHAR(20),
EndingPoint VARCHAR(20),
PRIMARY KEY(StartingPoint, EndingPoint));

-- Follow table represents which route a boat will follow
CREATE TABLE Follow(
BoatName VARCHAR(20),
StartingPoint VARCHAR(20),
EndingPoint VARCHAR(20),
PRIMARY KEY(BoatName, StartingPoint, EndingPoint),
FOREIGN KEY(BoatName) REFERENCES Boat(BoatName),
FOREIGN KEY(StartingPoint, EndingPoint) REFERENCES Route(StartingPoint, EndingPoint));

-- HaveDate table shows the date a boat will travel at
CREATE TABLE HaveDate(
BoatName VARCHAR(20),
Day DATE,
StartTime INT,
EndTime INT,
PRIMARY KEY(BoatName, Day, StartTime, EndTime),
FOREIGN KEY(BoatName) REFERENCES Boat(BoatName),
FOREIGN KEY(Day, StartTime, EndTime) REFERENCES TravelDate(Day, StartTime, EndTime));

-- Manage table holds the management relationship between captain and crew members
CREATE TABLE Manage(
CrewName VARCHAR(20),
CaptainName VARCHAR(20),
Salary INT,
Experience INT,
PRIMARY KEY(CrewName, CaptainName, Salary, Experience),
FOREIGN KEY(CrewName) REFERENCES Crew(CrewName),
FOREIGN KEY(CaptainName, Salary, Experience) REFERENCES Captain(CaptainName, Salary, Experience));

-- HaveCargo table shows the relationship between travellers and their cargo.
CREATE TABLE HaveCargo(
CargoNumber INT,
TravellerNumber INT,
PRIMARY KEY(CargoNumber, TravellerNumber),
FOREIGN KEY(CargoNumber) REFERENCES Cargo(CargoNumber),
FOREIGN KEY(TravellerNumber) REFERENCES Traveller(TravellerNumber));

-- 2. Insertions(Data manipulation):
-- For each table, add enough number of rows to make your queries in step three to produce meaningful result sets.

-- Ex:
-- INSERT INTO A1(A) VALUES(1);
INSERT INTO Boat(BoatName, Capacity, Expense) VALUES('Mavi Yunus', 12, 25000);
INSERT INTO Boat(BoatName, Capacity, Expense) VALUES('Deniz Kizi', 15, 35000);
INSERT INTO Boat(BoatName, Capacity, Expense) VALUES('Marti', 8, 15000);

INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(1, 'Ali', 'Heybeli Ada', 'Mavi Yunus');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(2, 'Orhan', 'Heybeli Ada', 'Marti');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(3, 'Mehmet', 'Heybeli Ada', 'Mavi Yunus');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(4, 'Engin', 'Heybeli Ada', 'Deniz Kizi');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(5, 'Kaan', 'Heybeli Ada', 'Deniz Kizi');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(6, 'Zeynep', 'Burgaz Ada', 'Marti');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(7, 'Nevin', 'Burgaz Ada', 'Deniz Kizi');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(8, 'Kemal', 'Burgaz Ada', 'Mavi Yunus');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(9, 'Ebru', 'Burgaz Ada', 'Deniz Kizi');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(10, 'Pelin', 'Büyük Ada', 'Marti');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(11, 'Yasar', 'Büyük Ada', 'Marti');
INSERT INTO Traveller(TravellerNumber, Name, Destination, BoatName) VALUES(12, 'Ayla', 'Büyük Ada', 'Mavi Yunus');

INSERT INTO Cargo(CargoNumber, Weight) VALUES(1, 15);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(2, 20);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(3, 17);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(4, 11);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(5, 9);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(6, 7);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(7, 19);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(8, 11);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(9, 12);
INSERT INTO Cargo(CargoNumber, Weight) VALUES(10, 15);

INSERT INTO Seaport(Location, Budget, Capacity) VALUES('Eminonu', 170000, 9);
INSERT INTO Seaport(Location, Budget, Capacity) VALUES('Kadikoy', 145000, 7);
INSERT INTO Seaport(Location, Budget, Capacity) VALUES('Uskudar', 140000, 6);

INSERT INTO Captain(CaptainName, Salary, Experience, BoatName, Location) VALUES('Burak', 6000, 15, 'Deniz Kizi', 'Eminonu');
INSERT INTO Captain(CaptainName, Salary, Experience, BoatName, Location) VALUES('Murat', 8500, 9, 'Marti', 'Kadikoy');
INSERT INTO Captain(CaptainName, Salary, Experience, BoatName, Location) VALUES('Mustafa', 7400, 4, 'Mavi Yunus', 'Uskudar');

INSERT INTO Crew(CrewName, Section, Salary) VALUES('Nuri', 'Cabin', 3000);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Ugur', 'Deck', 2500);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Naci', 'Engine', 2700);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Kadir', 'Cabin', 3000);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Tuna', 'Engine', 2250);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Tarık', 'Cabin', 2500);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Cengiz', 'Cabin', 3000);
INSERT INTO Crew(CrewName, Section, Salary) VALUES('Metin', 'Engine', 2000);

INSERT INTO TravelDate(Day, StartTime, EndTime) VALUES(20230405, 9, 13);
INSERT INTO TravelDate(Day, StartTime, EndTime) VALUES(20230405, 11, 16);
INSERT INTO TravelDate(Day, StartTime, EndTime) VALUES(20230417, 14, 17);
INSERT INTO TravelDate(Day, StartTime, EndTime) VALUES(20230520, 12, 14);
INSERT INTO TravelDate(Day, StartTime, EndTime) VALUES(20230612, 13, 17);

INSERT INTO Route(StartingPoint, EndingPoint) VALUES('Uskudar', 'Burgaz Ada');
INSERT INTO Route(StartingPoint, EndingPoint) VALUES('Kadikoy', 'Heybeli Ada');
INSERT INTO Route(StartingPoint, EndingPoint) VALUES('Eminonu', 'Buyuk Ada');

-- 3. Queries:
-- Write 5 queries with explanations 
-- Write 5 queries. Your queries should do a task that is meaningful in your selected context (project topic). 
-- At least one that joins two or more tables
-- At least one that include group functions
-- At least one with one or more sub-query(es)
-- At least one update
-- At least one delete
-- At least one include arithmetic functions
-- At least one uses alias

-- Ex:
-- Finding all records in A1 table
-- SELECT * FROM A1;

-- My queries:
-- Details of the boats on which the travelers are traveling.
SELECT * FROM Traveller JOIN Boat ON Traveller.BoatName = Boat.BoatName;
-- Number of crew members by sections.
SELECT Section, COUNT(*) AS CrewCount FROM Crew GROUP BY Section;
-- Number list of cargoes above average cargo weight.
SELECT CargoNumber FROM Cargo WHERE Weight > (SELECT AVG(Weight) FROM Cargo);
-- 15% increase in Captain Burak's salary.
UPDATE Captain SET Salary = Salary*1.15 WHERE CaptainName = 'Burak';
-- Deleting TravelDate dated 04.17.2023 from the TravelDate table.
DELETE FROM TravelDate WHERE Day = 20230417;