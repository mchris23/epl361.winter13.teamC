GO
IF OBJECT_ID ('sp_Insert_EXAMINATION_CANCER','P') IS NOT NULL
DROP PROCEDURE sp_Insert_EXAMINATION_CANCER
GO
CREATE PROCEDURE sp_Insert_EXAMINATION_CANCER(
@ID_Examination int,
@ID_cancer int
)

AS

SET NOCOUNT ON 
INSERT INTO dbo.EXAMINATION_CANCER
(ID_examination, ID_cancer)
VALUES
(@ID_examination, @ID_cancer)


GO
/*
EXECUTE sp_Insert_EXAMINATION_CANCER 1,1
SELECT * FROM dbo.EXAMINATION_CANCER
*/
IF OBJECT_ID ('sp_Update_EXAMINATION_CANCER','P') IS NOT NULL
DROP PROCEDURE sp_Update_EXAMINATION_CANCER
GO
CREATE PROCEDURE sp_Update_EXAMINATION_CANCER(
@ID_Examination int,
@ID_cancer int
)

AS

UPDATE dbo.EXAMINATION_CANCER


SET 
ID_examination = @ID_examination,
ID_cancer=@ID_cancer
WHERE ID_examination = @ID_examination and ID_cancer=@ID_cancer
GO
/*
EXECUTE dbo.sp_Update_EXAMINATION_CANCER @ID_Examination=1, @ID_cancer='1'
*/

GO
IF OBJECT_ID ('sp_delete_EXAMINATION_CANCER','P') IS NOT NULL
DROP PROCEDURE sp_delete_EXAMINATION_CANCER
GO
CREATE PROCEDURE [dbo].[sp_delete_EXAMINATION_CANCER]
@ID_examination int,
@ID_cancer int

AS

DELETE FROM [dbo].[EXAMINATION_CANCER]
WHERE ID_examination = @ID_examination and ID_cancer=@ID_cancer
GO
/*
EXECUTE dbo.sp_delete_EXAMINATION_CANCER 1,1
*/