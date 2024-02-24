USE pavlo_turchynyak;

DROP TRIGGER IF EXISTS onwer_name;
DROP TRIGGER IF EXISTS prevent_delete_country;
DROP TRIGGER IF EXISTS insert_in_user_account;

DELIMITER //
CREATE TRIGGER onwer_name
    BEFORE INSERT
    ON information_about_owner
    FOR EACH ROW
BEGIN
    IF new.name NOT REGEXP('Svitlana'|'Petro'|'Olha'|'Taras') THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Not correct name';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER prevent_delete_country
    BEFORE DELETE
    ON country
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Delete error for table country';
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER insert_in_user_account
    BEFORE INSERT
    ON user_account for EACH ROW
BEGIN
    IF new.nickname NOT RLIKE '[MR, RM]{2}-[0-9]{3}-[0-9]{2}' THEN
        SET new.name = new.name;
        SET new.surname = new.surname;
        SET new.credential_id = new.credential_id;
        SET new.nickname = new.nickname;
    ELSE
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'This nickname is not correct';
    END IF;
END //
DELIMITER ;