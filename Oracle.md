
# Oracle 笔记




分页查询

`SELECT * FROM (
    SELECT
        A.*, ROWNUM RN
    FROM (
        SELECT * FROM TABLE_NAME
    ) A WHERE ROWNUM <= 40
) WHERE RN >= 21`










