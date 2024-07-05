SELECT 
    '/home/grep/src/' || BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT AS FILE_PATH
FROM 
    USED_GOODS_FILE
WHERE 
    BOARD_ID = (
        SELECT 
            MAX_VIEW_BOARD_ID 
        FROM (
            SELECT 
                BOARD_ID AS MAX_VIEW_BOARD_ID 
            FROM 
                USED_GOODS_BOARD ugb
            ORDER BY 
                ugb.VIEWS DESC
        )
        WHERE 
            ROWNUM = 1
    )
ORDER BY FILE_ID DESC
;
