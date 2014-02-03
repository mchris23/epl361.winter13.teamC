GO
IF OBJECT_ID ('sp_Insert_CANCER_PREVENTION','P') IS NOT NULL
DROP PROCEDURE sp_Insert_CANCER_PREVENTION
GO
CREATE PROCEDURE sp_Insert_CANCER_PREVENTION(
@ID_prevent_way int,
@ID_cancer int
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.CANCER_PREVENTION
(ID_prevent_way, ID_cancer)
VALUES
(@ID_prevent_way, @ID_cancer)


GO
/*
EXECUTE sp_Insert_CANCER_PREVENTION 1,1
SELECT * FROM dbo.CANCER_PREVENTION
*/
IF OBJECT_ID ('sp_Update_CANCER_PREVENTION','P') IS NOT NULL
DROP PROCEDURE sp_Update_CANCER_PREVENTION
GO
CREATE PROCEDURE sp_Update_CANCER_PREVENTION(
@ID_prevent_way int,
@ID_cancer int
)

AS

UPDATE dbo.CANCER_PREVENTION


SET 
ID_prevent_way = @ID_prevent_way,
ID_cancer=@ID_cancer
WHERE ID_prevent_way = @ID_prevent_way and ID_cancer=@ID_cancer
GO
/*
EXECUTE dbo.sp_Update_CANCER_PREVENTION @ID_prevent_way=1, @ID_cancer='1'
*/

GO
IF OBJECT_ID ('sp_delete_CANCER_PREVENTION','P') IS NOT NULL
DROP PROCEDURE sp_delete_CANCER_PREVENTION
GO
CREATE PROCEDURE [dbo].[sp_delete_CANCER_PREVENTION]
@ID_prevent_way int,
@ID_cancer int

AS

DELETE FROM [dbo].[CANCER_PREVENTION]
WHERE ID_prevent_way = @ID_prevent_way and ID_cancer=@ID_cancer
GO
/*
EXECUTE dbo.sp_delete_CANCER_PREVENTION 1,1
*/