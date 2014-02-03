GO
IF OBJECT_ID ('sp_Insert_CANCER_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Insert_CANCER_IMAGE
GO
CREATE PROCEDURE sp_Insert_CANCER_IMAGE(
@ID_cancer int,
@cancer_image image 
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.CANCER_IMAGE
(ID_cancer, cancer_image)
VALUES
(@ID_cancer, @cancer_image)


GO
/*
EXECUTE sp_Insert_CANCER_IMAGE 1,'237896'
SELECT * FROM dbo.CANCER_IMAGE
*/
IF OBJECT_ID ('sp_Update_CANCER_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Update_CANCER_IMAGE
GO
CREATE PROCEDURE sp_Update_CANCER_IMAGE(
@ID_cancer int,
@cancer_image image 
)

AS

UPDATE dbo.CANCER_IMAGE


SET 
ID_cancer = @ID_cancer
WHERE ID_cancer = @ID_cancer and convert(varbinary,cancer_image)= convert(varbinary,@cancer_image)
GO
/*
EXECUTE dbo.sp_Update_PREVENT_WAY_IMAGE @ID_prevent_way=1, @prevent_way_image='2135456'
*/

GO
IF OBJECT_ID ('sp_delete_CANCER_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_delete_CANCER_IMAGE
GO
CREATE PROCEDURE [dbo].[sp_delete_CANCER_IMAGE]
@ID_cancer int,
@cancer_image image 

AS

DELETE FROM [dbo].[CANCER_IMAGE]
WHERE ID_cancer = @ID_cancer and convert(varbinary,cancer_image)= convert(varbinary,@cancer_image)
GO
/*
EXECUTE dbo.sp_delete_CANCER_IMAGE 1, '237896'
*/