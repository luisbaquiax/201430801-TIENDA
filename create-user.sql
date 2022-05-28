SHOW VARIABLES LIKE 'validate_password%';

SET GLOBAL validate_password.LENGTH = 4;
SET GLOBAL validate_password.policy = 0;
SET GLOBAL validate_password.mixed_case_count = 0;
SET GLOBAL validate_password.number_count = 0;
SET GLOBAL validate_password.special_char_count = 0;
SET GLOBAL validate_password.check_user_name = 0;

CREATE USER 'tienda'@'localhost' IDENTIFIED BY 'tienda1234';

GRANT ALL PRIVILEGES ON TIENDA.* TO 'tienda'@'localhost' WITH GRANT OPTION;
