SELECT * FROM (
	SELECT
	    min(${PARTITION_FIELD_CASTING}) AS partition_from,
	    max(${PARTITION_FIELD_CASTING}) AS partition_to
	FROM 
	    ${INPUT_TABLE_SCHEMA}.${INPUT_TABLE_NAME}
	WHERE 
	   ${WHERE_CONDITION_TO_RECOVER}
)x
