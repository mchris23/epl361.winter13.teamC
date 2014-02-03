GO
IF OBJECT_ID ('sp_Insert_Examination','P') IS NOT NULL
DROP PROCEDURE sp_Insert_Examination
GO
CREATE PROCEDURE sp_Insert_Examination(
@examination_name nvarchar(100),
@examination_description nvarchar(max),
@examination_frequency int,
@examination_sex bit,
@examination_agerange nvarchar(20),
@examination_weight nvarchar(20),
@examination_smoker tinyint,
@examination_height nvarchar(20),
@examination_family_histoty bit,
@examination_alcohol bit  
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.EXAMINATION
(examination_name,examination_description,examination_frequency,examination_sex,examination_agerange,examination_weight,examination_smoker,examination_height,examination_family_histoty,examination_alcohol)
VALUES
(@examination_name, @examination_description, @examination_frequency,@examination_sex,@examination_agerange,@examination_weight,@examination_smoker,@examination_height,@examination_family_histoty,@examination_alcohol)


GO
/*
EXECUTE sp_Insert_Examination 'eksetasi aimatos','how to do it',30,1,'12-14','45',1,'123',1,0
SELECT * FROM dbo.EXAMINATION
*/
IF OBJECT_ID ('sp_Update_Examination','P') IS NOT NULL
DROP PROCEDURE sp_Update_Examination
GO
CREATE PROCEDURE sp_Update_Examination(
@ID_Examination int,
@examination_name nvarchar(100),
@examination_description nvarchar(max),
@examination_frequency int,
@examination_sex bit,
@examination_agerange nvarchar(20),
@examination_weight nvarchar(20),
@examination_smoker tinyint,
@examination_height nvarchar(20),
@examination_family_histoty bit,
@examination_alcohol bit   
)

AS

UPDATE dbo.EXAMINATION


SET 
examination_Name=@examination_Name,
examination_description=@examination_description,
examination_frequency=@examination_frequency,
examination_sex=@examination_sex,
examination_agerange=@examination_agerange,
examination_weight=@examination_weight,
examination_smoker=@examination_smoker,
examination_height=@examination_height,
examination_family_histoty=@examination_family_histoty,
examination_alcohol=@examination_alcohol 

WHERE ID_Examination = @ID_Examination
GO
/*
EXECUTE dbo.sp_Update_Examination @ID_Examination=1, @examination_name='eksetasi kopranon', @examination_description='description', @examination_frequency='90',@examination_sex=0,@examination_agerange='12-40',@examination_weight='49-89',@examination_smoker=1,@examination_height='120-185',@examination_family_histoty=1,@examination_alcohol=1
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