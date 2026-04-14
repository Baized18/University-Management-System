use university_management_system;

create table Student (Name varchar(100) , 
                     Father_Name varchar(100) ,
					Roll_Number varchar(100) ,
                    Date_of_Birth varchar(100) , 
                    Address varchar(100) ,
                    Phone varchar (100) , 
                    Email varchar (100) ,
                    SSC_Grade varchar(100) , 
                    HSC_Grade varchar(100) , 
                    NID_No varchar(100) ,
                    Faculty varchar(100) , 
                    Program varchar(100));

create table Teacher (Name varchar(100) ,
			         Date_of_Birth varchar(100) ,
                     Employee_ID varchar(100) ,
                     Department varchar(100) , 
                      Address varchar(100) , 
                        Phone varchar (100) , 
                        Email varchar (100)  ,
                        Qualification varchar(100) , 
                        Salary varchar(100));

create table StudentLeave (Roll_Number varchar(50) ,  
                           Date varchar(50) , 
                           Duration varchar(50));

create table TeacherLeave (Employee_ID varchar(50) , 
							Date varchar(50) , 
                            Duration varchar(50));
  
create table Login (Username varchar(50)  , Password varchar(50);  
                            
create table subject (Roll_Number varchar(50) , Semester varchar(50) , Subject1 varchar(50) , Subject2 varchar(50) , Subject3 varchar(50) , Subject4 varchar(50) , Subject5 varchar(50));

create table marks (Roll_Number varchar(50) , Semester varchar(50) , Marks1 varchar(50) , Marks2 varchar(50) , Marks3 varchar(50) , Marks4 varchar(50) , Marks5 varchar(50));



select * from Student;

select * from Teacher;

select * from Login;

select * from studentleave;

select * from Teacherleave;

select * from subject;

select * from marks;
