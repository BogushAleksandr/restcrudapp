DROP TABLE IF EXISTS tblEmployees;
DROP TABLE IF EXISTS tblDepartments;


-- table tblEmployees
CREATE TABLE IF NOT EXISTS tblDepartments
(
    dpID   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dpName VARCHAR(255) NOT NULL UNIQUE
);

-- table tblEmployees
CREATE TABLE IF NOT EXISTS tblEmployees
(
    empID     INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    empName   VARCHAR(255) NOT NULL,
    empActive TINYINT      NOT NULL,
    emp_dpID  INT          NOT NULL,
    FOREIGN KEY (emp_dpID) REFERENCES tblDepartments (dpID)
);

insert into tblDepartments (dpName)
values ("HR");
insert into tblDepartments (dpName)
values ("Tech");
insert into tblDepartments (dpName)
values ("Finance");

insert into tblEmployees (empName, empActive, emp_dpID) VALUES ("Lisa",1,1);
insert into tblEmployees (empName, empActive, emp_dpID) VALUES ("Erik",1,2);
insert into tblEmployees (empName, empActive, emp_dpID) VALUES ("Don",1,3);
insert into tblEmployees (empName, empActive, emp_dpID) VALUES ("Peter",0,1);

