CREATE TABLE staff (
    sid BIGINT AUTO_INCREMENT PRIMARY KEY,
    staff_type VARCHAR(50),   -- discriminator column
    sname VARCHAR(255),
    areaexpertise VARCHAR(255),
    qualification VARCHAR(255),
    subject_expert VARCHAR(255)   
);
select * from staff;
