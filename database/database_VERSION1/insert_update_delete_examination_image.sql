GO
IF OBJECT_ID ('sp_Insert_EXAMINATION_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Insert_EXAMINATION_IMAGE
GO
CREATE PROCEDURE sp_Insert_EXAMINATION_IMAGE(
@ID_Examination int,
@examination_image image 
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.EXAMINATION_IMAGE
(ID_examination, examination_image)
VALUES
(@ID_examination, @examination_image)


GO
/*
EXECUTE sp_Insert_EXAMINATION_IMAGE 1,'237896'
SELECT * FROM dbo.EXAMINATION_IMAGE
*/
IF OBJECT_ID ('sp_Update_EXAMINATION_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Update_EXAMINATION_IMAGE
GO
CREATE PROCEDURE sp_Update_EXAMINATION_IMAGE(
@ID_Examination int,
@examination_image image 
)

AS

UPDATE dbo.EXAMINATION_IMAGE


SET 
ID_examination = @ID_examination
WHERE ID_examination = @ID_examination and convert(varbinary,examination_image)= convert(varbinary,@examination_image)
GO
/*
EXECUTE dbo.sp_Update_EXAMINATION_IMAGE @ID_Examination=1, @examination_image='2135456'
*/

GO
IF OBJECT_ID ('sp_delete_EXAMINATION_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_delete_EXAMINATION_IMAGE
GO
CREATE PROCEDURE [dbo].[sp_delete_EXAMINATION_IMAGE]
@ID_examination int,
@examination_image image 

AS

DELETE FROM [dbo].[EXAMINATION_IMAGE]
WHERE ID_examination = @ID_examination and convert(varbinary,examination_image)= convert(varbinary,@examination_image)
GO
/*
EXECUTE dbo.sp_delete_EXAMINATION_IMAGE 1, '237896'
*/