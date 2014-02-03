GO
IF OBJECT_ID ('sp_Insert_Cancer','P') IS NOT NULL
DROP PROCEDURE sp_Insert_Cancer
GO
CREATE PROCEDURE sp_Insert_Cancer(
@cancer_name nvarchar(100),
@cancer_description nvarchar(max)
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.CANCER
(cancer_name,cancer_description)
VALUES
(@cancer_name,@cancer_description)


GO
/*
EXECUTE sp_Insert_Cancer 'karkinos toy mastou','how to do it'
SELECT * FROM dbo.CANCER
*/
IF OBJECT_ID ('sp_Update_Cancer','P') IS NOT NULL
DROP PROCEDURE sp_Update_Cancer
GO
CREATE PROCEDURE sp_Update_Cancer(
@ID_Cancer int,
@cancer_name nvarchar(100),
@cancer_description nvarchar(max)
)

AS

UPDATE dbo.CANCER


SET 
cancer_name=@cancer_name,
cancer_description=@cancer_description

WHERE ID_Cancer = @ID_Cancer
GO
/*
EXECUTE dbo.sp_Update_Cancer @ID_Cancer=1, @cancer_name='karkinos tou pnevmona', @cancer_description='description'
*/

GO
IF OBJECT_ID ('sp_delete_Cancer','P') IS NOT NULL
DROP PROCEDURE sp_delete_Cancer
GO
CREATE PROCEDURE [dbo].[sp_delete_Cancer]
@ID_Cancer int

AS

DELETE FROM [dbo].[CANCER]
WHERE ID_Cancer = @ID_Cancer
GO
/*
EXECUTE dbo.sp_delete_Cancer '1'
*/