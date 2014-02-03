GO
IF OBJECT_ID ('sp_Insert_EXAMINATION_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Insert_EXAMINATION_IMAGE
GO
CREATE PROCEDURE sp_Insert_EXAMINATION_IMAGE(
@ID_Examination int,
@ID_examination_image int
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.EXAMINATION_IMAGE
(ID_examination, ID_examination_image)
VALUES
(@ID_examination, @ID_examination_image)


GO
/*
EXECUTE sp_Insert_EXAMINATION_IMAGE 1,2
SELECT * FROM dbo.EXAMINATION_IMAGE
*/
IF OBJECT_ID ('sp_Update_EXAMINATION_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Update_EXAMINATION_IMAGE
GO
CREATE PROCEDURE sp_Update_EXAMINATION_IMAGE(
@ID_Examination int,
@ID_examination_image int
)

AS

UPDATE dbo.EXAMINATION_IMAGE


SET 
ID_examination = @ID_examination
WHERE ID_examination = @ID_examination and ID_examination_image=@ID_examination_image
GO
/*
EXECUTE dbo.sp_Update_EXAMINATION_IMAGE @ID_Examination=1, @ID_examination_image=21
*/

GO
IF OBJECT_ID ('sp_delete_EXAMINATION_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_delete_EXAMINATION_IMAGE
GO
CREATE PROCEDURE [dbo].[sp_delete_EXAMINATION_IMAGE]
@ID_examination int,
@ID_examination_image int

AS

DELETE FROM [dbo].[EXAMINATION_IMAGE]
WHERE ID_examination = @ID_examination and ID_examination_image=@ID_examination_image
GO
/*
EXECUTE dbo.sp_delete_EXAMINATION_IMAGE 1, 2
*/