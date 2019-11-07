SELECT `players`.`playerId`,
    `players`.`name`,
    `players`.`date`,
    count(`name`)rollsrolls
FROM `db_dicegame`.`players`
GROUP BY `name`;
