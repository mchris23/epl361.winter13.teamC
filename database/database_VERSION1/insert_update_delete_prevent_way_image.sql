GO
IF OBJECT_ID ('sp_Insert_PREVENT_WAY_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Insert_PREVENT_WAY_IMAGE
GO
CREATE PROCEDURE sp_Insert_PREVENT_WAY_IMAGE(
@ID_prevent_way int,
@prevent_way_image image 
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.PREVENT_WAY_IMAGE
(ID_prevent_way, prevent_way_image)
VALUES
(@ID_prevent_way, @prevent_way_image)


GO
/*
EXECUTE sp_Insert_PREVENT_WAY_IMAGE 1,'237896'
SELECT * FROM dbo.PREVENT_WAY_IMAGE
*/
IF OBJECT_ID ('sp_Update_PREVENT_WAY_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Update_PREVENT_WAY_IMAGE
GO
CREATE PROCEDURE sp_Update_PREVENT_WAY_IMAGE(
@ID_prevent_way int,
@prevent_way_image image 
)

AS

UPDATE dbo.PREVENT_WAY_IMAGE


SET 
ID_prevent_way = @ID_prevent_way
WHERE ID_prevent_way = @ID_prevent_way and convert(varbinary,prevent_way_image)= convert(varbinary,@prevent_way_image)
GO
/*
EXECUTE dbo.sp_Update_PREVENT_WAY_IMAGE @ID_prevent_way=1, @prevent_way_image='2135456'
*/

GO
IF OBJECT_ID ('sp_delete_PREVENT_WAY_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_delete_PREVENT_WAY_IMAGE
GO
CREATE PROCEDURE [dbo].[sp_delete_PREVENT_WAY_IMAGE]
@ID_prevent_way int,
@prevent_way_image image 

AS

DELETE FROM [dbo].[PREVENT_WAY_IMAGE]
WHERE ID_prevent_way = @ID_prevent_way and convert(varbinary,prevent_way_image)= convert(varbinary,@prevent_way_image)
GO
/*
EXECUTE dbo.sp_delete_PREVENT_WAY_IMAGE 1, '237896'
*/