GO
IF OBJECT_ID ('sp_Insert_CANCER_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Insert_CANCER_IMAGE
GO
CREATE PROCEDURE sp_Insert_CANCER_IMAGE(
@ID_cancer int,
@ID_cancer_image int
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.CANCER_IMAGE
(ID_cancer, ID_cancer_image)
VALUES
(@ID_cancer, @ID_cancer_image)


GO
/*
EXECUTE sp_Insert_CANCER_IMAGE 1,3
SELECT * FROM dbo.CANCER_IMAGE
*/
IF OBJECT_ID ('sp_Update_CANCER_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_Update_CANCER_IMAGE
GO
CREATE PROCEDURE sp_Update_CANCER_IMAGE(
@ID_cancer int,
@ID_cancer_image int
)

AS

UPDATE dbo.CANCER_IMAGE


SET 
ID_cancer = @ID_cancer
WHERE ID_cancer = @ID_cancer and ID_cancer_image=@ID_cancer_image
GO
/*
EXECUTE dbo.sp_Update_CANCER_IMAGE @ID_cancer=1, @ID_cancer_image=135
*/

GO
IF OBJECT_ID ('sp_delete_CANCER_IMAGE','P') IS NOT NULL
DROP PROCEDURE sp_delete_CANCER_IMAGE
GO
CREATE PROCEDURE [dbo].[sp_delete_CANCER_IMAGE]
@ID_cancer int,
@ID_cancer_image int

AS

DELETE FROM [dbo].[CANCER_IMAGE]
WHERE ID_cancer = @ID_cancer and ID_cancer_image=@ID_cancer_image
GO
/*
EXECUTE dbo.sp_delete_CANCER_IMAGE 1, 3
*/