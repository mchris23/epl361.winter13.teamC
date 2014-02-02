GO
IF OBJECT_ID ('sp_Insert_Examination','P') IS NOT NULL
DROP PROCEDURE sp_Insert_Examination
GO
CREATE PROCEDURE sp_Insert_Examination(
@examination_name nvarchar(100),
@examination_description nvarchar(max),
@examination_frequency int
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.EXAMINATION
(examination_name,examination_description,examination_frequency)
VALUES
(@examination_name, @examination_description, @examination_frequency)


GO
/*
EXECUTE sp_Insert_Examination 'eksetasi aimatos','how to do it',30
SELECT * FROM dbo.EXAMINATION
*/
IF OBJECT_ID ('sp_Update_Examination','P') IS NOT NULL
DROP PROCEDURE sp_Update_Examination
GO
CREATE PROCEDURE sp_Update_Examination(
@ID_Examination int,
@examination_name nvarchar(100),
@examination_description nvarchar(max),
@examination_frequency int
)

AS

UPDATE dbo.EXAMINATION


SET 
examination_Name=@examination_Name,
examination_description=@examination_description,
examination_frequency=@examination_frequency

WHERE ID_Examination = @ID_Examination
GO
/*
EXECUTE dbo.sp_Update_Examination @ID_Examination=1, @examination_name='eksetasi kopranon', @examination_description='description', @examination_frequency='90'
*/

GO
IF OBJECT_ID ('sp_delete_Examination','P') IS NOT NULL
DROP PROCEDURE sp_delete_Examination
GO
CREATE PROCEDURE [dbo].[sp_delete_Examination]
@ID_Examination int

AS

DELETE FROM [dbo].[EXAMINATION]
WHERE ID_Examination = @ID_Examination
GO
/*
EXECUTE dbo.sp_delete_Examination '1'
*/