GO
IF OBJECT_ID ('sp_Insert_Image','P') IS NOT NULL
DROP PROCEDURE sp_Insert_Image
GO
CREATE PROCEDURE sp_Insert_Image(
@Image varbinary(max)
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.Image
(Image)
VALUES
(@Image)


GO
/*
EXECUTE sp_Insert_Image 0101010101
SELECT * FROM dbo.Image
*/
IF OBJECT_ID ('sp_Update_Image','P') IS NOT NULL
DROP PROCEDURE sp_Update_Image
GO
CREATE PROCEDURE sp_Update_Image(
@ID_Image int,
@Image varbinary(max)
)

AS

UPDATE dbo.Image


SET 
Image=@Image

WHERE ID_Image = @ID_Image
GO
/*
EXECUTE dbo.sp_Update_Image @ID_Image=1, @Image=1110010001
*/

GO
IF OBJECT_ID ('sp_delete_Image','P') IS NOT NULL
DROP PROCEDURE sp_delete_Image
GO
CREATE PROCEDURE [dbo].[sp_delete_Image]
@ID_Image int

AS

DELETE FROM [dbo].[Image]
WHERE ID_Image = @ID_Image
GO
/*
EXECUTE dbo.sp_delete_Image '1'
*/