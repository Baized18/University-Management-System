USE university_management_system;

-- Student Table
CREATE TABLE Student (
    Name VARCHAR(100),
    Father_Name VARCHAR(100),
    Roll_Number VARCHAR(100),
    Date_of_Birth VARCHAR(100),
    Address VARCHAR(100),
    Phone VARCHAR(100),
    Email VARCHAR(100),
    SSC_Grade VARCHAR(100),
    HSC_Grade VARCHAR(100),
    NID_No VARCHAR(100),
    Faculty VARCHAR(100),
    Program VARCHAR(100)
);

-- Teacher Table
CREATE TABLE Teacher (
    Name VARCHAR(100),
    Date_of_Birth VARCHAR(100),
    Employee_ID VARCHAR(100),
    Department VARCHAR(100),
    Address VARCHAR(100),
    Phone VARCHAR(100),
    Email VARCHAR(100),
    Qualification VARCHAR(100),
    Salary VARCHAR(100)
);

-- Student Leave
CREATE TABLE StudentLeave (
    Roll_Number VARCHAR(50),
    Date VARCHAR(50),
    Duration VARCHAR(50)
);

-- Teacher Leave
CREATE TABLE TeacherLeave (
    Employee_ID VARCHAR(50),
    Date VARCHAR(50),
    Duration VARCHAR(50)
);

-- Login Table (FIXED)
CREATE TABLE Login (
    Username VARCHAR(50),
    Password VARCHAR(50)
);

-- Subject Table
CREATE TABLE Subject (
    Roll_Number VARCHAR(50),
    Semester VARCHAR(50),
    Subject1 VARCHAR(50),
    Subject2 VARCHAR(50),
    Subject3 VARCHAR(50),
    Subject4 VARCHAR(50),
    Subject5 VARCHAR(50)
);

-- Marks Table
CREATE TABLE Marks (
    Roll_Number VARCHAR(50),
    Semester VARCHAR(50),
    Marks1 VARCHAR(50),
    Marks2 VARCHAR(50),
    Marks3 VARCHAR(50),
    Marks4 VARCHAR(50),
    Marks5 VARCHAR(50)
);

-- Fee Table
CREATE TABLE Fee (
    Program VARCHAR(50),
    Semester1 VARCHAR(50),
    Semester2 VARCHAR(50),
    Semester3 VARCHAR(50),
    Semester4 VARCHAR(50),
    Semester5 VARCHAR(50),
    Semester6 VARCHAR(50),
    Semester7 VARCHAR(50),
    Semester8 VARCHAR(50)
);

-- FeesPaid Table
CREATE TABLE FeesPaid (
    Roll_Number varchar(50) ,
    Program VARCHAR(50),
    Semester VARCHAR(50) ,
    Total varchar (50)
);

-- Insert Data
INSERT INTO fee VALUES
("BBA",  "75000", "70000", "65000", "60000", "55000", "50000", "45000", "40000"),
("MBA",  "80000", "75000", "70000", "65000", "60000", "55000", "50000", "45000"),
("EMBA", "85000", "80000", "75000", "70000", "65000", "60000", "55000", "50000"),
("B.A",  "60000", "55000", "50000", "45000", "40000", "35000", "30000", "25000"),
("M.A",  "65000", "60000", "55000", "50000", "45000", "40000", "35000", "30000"),
("B.Sc", "78000", "72000", "68000", "52000", "48000", "32000", "29000", "25000"),
("LL.B", "70000", "65000", "60000", "55000", "50000", "45000", "40000", "35000"),
("LL.M", "75000", "70000", "65000", "60000", "55000", "50000", "45000", "40000"),
("M.Sc", "82000", "78000", "74000", "70000", "66000", "62000", "58000", "54000");

-- View Data
SELECT * FROM Student;
SELECT * FROM Teacher;
SELECT * FROM Login;
SELECT * FROM StudentLeave;
SELECT * FROM TeacherLeave;
SELECT * FROM Subject;
SELECT * FROM Marks;
SELECT * FROM Fee;
select * from FeesPaid;