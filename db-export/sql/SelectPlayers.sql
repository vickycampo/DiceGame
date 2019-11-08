SELECT `players`.`playerId`,
    `players`.`name`,
    `players`.`date`,
    count(`name`)rollsrollsrolls
FROM `db_dicegame`.`players`
GROUP BY `name`;
