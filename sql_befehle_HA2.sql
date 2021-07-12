create table HA2_Patient (
    PatientenID INT NOT NULL,
    Name VARCHAR2(20) NOT NULL,
    Vorname VARCHAR2(20) NOT NULL,
    Geburtsdatum DATE NOT NULL,
    Mail VARCHAR2(50),
    TelefonNr VARCHAR2(20),
    Constraint PK_Patient PRIMARY KEY (PatientenID)
);

create table HA2_Impfstoffcharge (
    ChargeID INT NOT NULL,
    Anzahl INT NOT NULL,
    Hersteller VARCHAR2(20) NOT NULL,
    Datum_Anlieferung DATE NOT NULL,
    Constraint PK_Impfstoffcharge PRIMARY KEY (ChargeID)
);

CREATE SEQUENCE Impfstoffcharge_seq START WITH 10 INCREMENT BY 1;

create table HA2_Termin (
    TerminID INT NOT NULL,
    Datum DATE NOT NULL,
    Uhrzeit VARCHAR2(20) NOT NULL,
    PatientID INT NOT NULL,
    isWahrgenommen INT,
    Constraint PK_Termin PRIMARY KEY (TerminID),
    Constraint FK_Termin_Patient FOREIGN KEY (PatientID) REFERENCES HA1_Patient(PatientenID)
);

create table HA2_Impfung (
    ImpfungID INT NOT NULL,
    Datum DATE NOT NULL,
    Uhrzeit VARCHAR2(20) NOT NULL,
    TerminID INT NOT NULL,
    ChargeID INT NOT NULL,
    Bemerkung VARCHAR2(500),
    Constraint PK_Impfung PRIMARY KEY (ImpfungID),
    Constraint FK_Impfung_Termin FOREIGN KEY (TerminID) REFERENCES HA1_Termin(TerminID) ON DELETE CASCADE,
    Constraint FK_Impfung_Impfstoffcharge FOREIGN KEY (ChargeID) REFERENCES HA1_Impfstoffcharge(ChargeID)
);
