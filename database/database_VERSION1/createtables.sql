GO

/* Create tables */

IF OBJECT_ID('dbo.EXAMINATION','U') IS NOT NULL
DROP TABLE dbo.EXAMINATION
GO
CREATE TABLE dbo.EXAMINATION(
ID_Examination int identity(1,1) NOT NULL,
examination_name nvarchar(100) NOT NULL,
examination_description nvarchar(max) NOT NULL,
examination_frequency int NULL 
)
GO
IF OBJECT_ID('dbo.EXAMINATION_IMAGE','U') IS NOT NULL
DROP TABLE dbo.EXAMINATION_IMAGE
GO
CREATE TABLE dbo.EXAMINATION_IMAGE(
ID_Examination int NOT NULL,
examination_image binary(100) NOT NULL
)
GO

IF OBJECT_ID('dbo.CANCER','U') IS NOT NULL
DROP TABLE dbo.CANCER
GO
CREATE TABLE dbo.CANCER(
ID_cancer int identity(1,1) NOT NULL,
cancer_name nvarchar(100) NOT NULL,
cancer_description nvarchar(max) NOT NULL
)
GO
IF OBJECT_ID('dbo.CANCER_IMAGE','U') IS NOT NULL
DROP TABLE dbo.CANCER_IMAGE
GO
CREATE TABLE dbo.CANCER_IMAGE(
ID_cancer int NOT NULL,
cancer_image binary(100) NOT NULL
)
GO

IF OBJECT_ID('dbo.PREVENT_WAY','U') IS NOT NULL
DROP TABLE dbo.PREVENT_WAY
GO
CREATE TABLE dbo.PREVENT_WAY(
ID_prevent_way int identity(1,1) NOT NULL,
prevent_way_name nvarchar(100) NOT NULL,
prevent_way_description nvarchar(max) NOT NULL,
)

GO
IF OBJECT_ID('dbo.PREVENT_WAY_IMAGE','U') IS NOT NULL
DROP TABLE dbo.PREVENT_WAY_IMAGE
GO
CREATE TABLE dbo.PREVENT_WAY_IMAGE(
ID_prevent_way int NOT NULL,
prevent_way_image binary(100) NOT NULL
)

GO
IF OBJECT_ID('dbo.EXAMINATION_CANCER','U') IS NOT NULL
DROP TABLE dbo.EXAMINATION_CANCER
GO
CREATE TABLE dbo.EXAMINATION_CANCER(
ID_Examination int NOT NULL,
ID_cancer int NOT NULL
)

GO
IF OBJECT_ID('dbo.CANCER_PREVENTION','U') IS NOT NULL
DROP TABLE dbo.CANCER_PREVENTION
GO
CREATE TABLE dbo.CANCER_PREVENTION(
ID_cancer int NOT NULL,
ID_prevent_way int NOT NULL
)