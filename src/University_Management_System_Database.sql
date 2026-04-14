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

select * from Student;

select * from Teacher;

select * from Login;

select * from studentleave;

select * from Teacherleave;
