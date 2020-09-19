--
UPDATE stockbase
SET mcode = CODE;

UPDATE stockbase
SET CODE = REPLACE (mcode, 'SH', '')
WHERE
	mcode LIKE 'SH%';

UPDATE stockbase
SET CODE = REPLACE (mcode, 'SZ', '')
WHERE
	mcode LIKE 'SZ%';

UPDATE stockbase
SET market = 'SH'
WHERE
	mcode LIKE 'SH%';

UPDATE stockbase
SET market = 'SZ'
WHERE
	mcode LIKE 'SZ%';

-- 更新gaoyi表格code
UPDATE gaoyi
SET gaoyi. CODE = (
	SELECT
		stockbase. CODE
	FROM
		stockbase
	WHERE
		stockbase. NAME = gaoyi. NAME
);

