GO
IF OBJECT_ID ('sp_Insert_PREVENT_WAY','P') IS NOT NULL
DROP PROCEDURE sp_Insert_PREVENT_WAY
GO
CREATE PROCEDURE sp_Insert_PREVENT_WAY(
@prevent_way_name nvarchar(100),
@prevent_way_description ntext
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.PREVENT_WAY
(prevent_way_name,prevent_way_description)
VALUES
(@prevent_way_name, @prevent_way_description)


GO
/*
EXECUTE sp_Insert_PREVENT_WAY 'TROPOS PROLIYIS 1','how to do it'
SELECT * FROM dbo.PREVENT_WAY
*/
IF OBJECT_ID ('sp_Update_PREVENT_WAY','P') IS NOT NULL
DROP PROCEDURE sp_Update_PREVENT_WAY
GO
CREATE PROCEDURE sp_Update_PREVENT_WAY(
@ID_prevent_way int,
@prevent_way_name nvarchar(100),
@prevent_way_description ntext
)

AS

UPDATE dbo.PREVENT_WAY


SET 
prevent_way_name=@prevent_way_name,
prevent_way_description=@prevent_way_description

WHERE ID_prevent_way = @ID_prevent_way
GO
/*
EXECUTE dbo.sp_Update_PREVENT_WAY @ID_prevent_way=1, @prevent_way_name='igeini diatrofi', @prevent_way_description='description'
*/

GO
IF OBJECT_ID ('sp_delete_PREVENT_WAY','P') IS NOT NULL
DROP PROCEDURE sp_delete_PREVENT_WAY
GO
CREATE PROCEDURE [dbo].[sp_delete_PREVENT_WAY]
@ID_prevent_way int

AS

DELETE FROM [dbo].[PREVENT_WAY]
WHERE ID_prevent_way = @ID_prevent_way
GO
/*
EXECUTE dbo.sp_delete_PREVENT_WAY '1'
*/