CREATE TABLE MODELS(
    MODEL_ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NAME CHAR(255) NOT NULL,
    ENGINE CHAR(255) NOT NULL,
    DRIVETRAIN CHAR(255) NOT NULL,
    TRANSMISSION CHAR(255) NOT NULL,
    VERSION CHAR(255) NOT NULL,
    PRICE BIGINT(255) NOT NULL
);

CREATE TABLE CUSTOMERS (
    CUSTOMER_ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NAME CHAR(255) NOT NULL,
    EMAIL CHAR(255)
);

CREATE TABLE ORDERS (
    ORDER_ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    MODEL_ID BIGINT(20) NOT NULL,
    CUSTOMER_ID BIGINT(20) NOT NULL,
    ORDER_DATE TIMESTAMP DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_MODEL_ID FOREIGN KEY (MODEL_ID) REFERENCES MODELS(MODEL_ID),
    CONSTRAINT FK_CUSTOMER_ID FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID)
);


INSERT  IGNORE CUSTOMERS(NAME, EMAIL) VALUES
                                           ('Jan Nowak', 'jan.nowak@gmail.com'),
                                           ('Tadeusz Kowalski', 'tadzik69@yahoo.com');

INSERT INTO MODELS(NAME, ENGINE, DRIVETRAIN, TRANSMISSION, VERSION, PRICE)
    VALUES
        ('Vitara', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Comfort Plus', 91900),
        ('Vitara', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Premium', 96900),
        ('Vitara', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Elegance', 106900),
        ('Vitara', '1.4 BoosterJet mild Hybrid', '4WD', '6MT', 'Premium', 108900),
        ('Vitara', '1.4 BoosterJet mild Hybrid', '4WD', '6MT', 'Elegance', 118900),
        ('Vitara', '1.4 BoosterJet mild Hybrid', '4WD', '6MT', 'Elegance Sun', 123900),
        ('Jimmy', '1.4 VVT', '4WD', '5MT', 'Pro', 104900),
        ('Swift Sport', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Sport', 99900),
        ('Swace', '1.8 Hybrid', '2WD', 'E-CVT', 'Premium Plus', 120900),
        ('Swace', '1.8 Hybrid', '2WD', 'E-CVT', 'Elegance', 130900),
        ('Across', '2.5 Plug-in Hybrid', '4WD (E-Four)', 'E-CVT', 'Elegance', 249500),
        ('Vitara Strong Hybrid', '1.5 DualJet Hybrid', '2WD', '6AGS', 'Premium', 112900),
        ('Vitara Strong Hybrid', '1.5 DualJet Hybrid', '2WD', '6AGS', 'Elegance', 122900),
        ('Vitara Strong Hybrid', '1.5 DualJet Hybrid', '4WD', '6AGS', 'Premium', 124900),
        ('Vitara Strong Hybrid', '1.5 DualJet Hybrid', '4WD', '6AGS', 'Elegance Sun', 139900),
        ('S-Cross Strong Hybrid', '1.5 DualJet Hybrid', '2WD', '6AGS', 'Premium', 124900),
        ('S-Cross Strong Hybrid', '1.5 DualJet Hybrid', '2WD', '6AGS', 'Elegance', 134900),
        ('S-Cross Strong Hybrid', '1.5 DualJet Hybrid', '4WD', '6AGS', 'Premium', 136900),
        ('S-Cross Strong Hybrid', '1.5 DualJet Hybrid', '4WD', '6AGS', 'Elegance Sun', 151900),
        ('Swift', '1.2 DualJet mild Hybrid', '2WD', '5MT', 'Premium', 65900),
        ('Swift', '1.2 DualJet mild Hybrid', '2WD', 'CVT', 'Premium', 70900),
        ('Swift', '1.2 DualJet mild Hybrid', '2WD', '5MT', 'Premium Plus', 71900),
        ('Swift', '1.2 DualJet mild Hybrid', '2WD', '5MT', 'Elegance', 75900),
        ('Swift', '1.2 DualJet mild Hybrid', '2WD', 'CVT', 'Premium Plus', 76900),
        ('Ignis', '1.2 DualJet mild Hybrid', '2WD', '5MT', 'Comfort Plus', 68900),
        ('Ignis', '1.2 DualJet mild Hybrid', '2WD', '5MT', 'Premium Plus', 76900),
        ('Ignis', '1.2 DualJet mild Hybrid', '2WD', 'CVT', 'Premium Plus', 80900),
        ('Ignis', '1.2 DualJet mild Hybrid', '4WD', '5MT', 'Premium Plus', 83900),
        ('Ignis', '1.2 DualJet mild Hybrid', '4WD', '5MT', 'Elegance', 87900),
        ('S-Cross', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Comfort', 103900),
        ('S-Cross', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Premium', 108900),
        ('S-Cross', '1.4 BoosterJet mild Hybrid', '2WD', '6MT', 'Elegance', 118900),
        ('S-Cross', '1.4 BoosterJet mild Hybrid', '4WD', '6MT', 'Premium', 120900),
        ('S-Cross', '1.4 BoosterJet mild Hybrid', '4WD', '6MT', 'Elegance', 130900);
