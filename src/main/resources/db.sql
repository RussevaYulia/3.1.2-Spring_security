# INSERT INTO `web-app3`.users (id, department, name, password, salary, surname) VALUES (1, 'java', 'Denis', 'denis', 150, 'Wwww');
#
# INSERT INTO `web-app3`.roles(id, name) VALUES (2, 'ROLE_ADMIN');
#
# INSERT INTO `web-app3`.users_roles(user_id, role_id) VALUES (1,2);
#
# INSERT INTO `web-app3`.users (id, department, name, password, salary, surname) VALUES (3, 'js', 'Danil', 'danil', 150, 'Wwww');
#
# INSERT INTO `web-app3`.roles(id, name) VALUES (4, 'ROLE_USER');
#
# INSERT INTO `web-app3`.users_roles(user_id, role_id) VALUES (3,4);

INSERT INTO `web-app3`.users (id, department, name, password, salary, surname) VALUES (5, 'work', 'user3', 'user3', 150, 'Wwww');

INSERT INTO `web-app3`.roles(id, name) VALUES (6, 'ROLE_ADMIN');

INSERT INTO `web-app3`.users_roles(user_id, role_id) VALUES (5, 6);