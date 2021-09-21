INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES ('administrador','$2a$10$/AdOvfzru2FHh.EnVIuEWeSm/grYtt4Do.lV1pC/AyXwtUOx1yM.O',true,'Max','Camata','mcamata@gmail.com');
INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES ('usuario','$2a$10$/AdOvfzru2FHh.EnVIuEWeSm/grYtt4Do.lV1pC/AyXwtUOx1yM.O',true,'Juan','Garcia Lima','jgarcia@gmail.com');
INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES ('usuario1','$2a$10$/AdOvfzru2FHh.EnVIuEWeSm/grYtt4Do.lV1pC/AyXwtUOx1yM.O',true,'Cristian','Colque Mamani','cmamani@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES ('ROLE_ALMACENERO');
INSERT INTO roles (nombre) VALUES ('ROLE_VENDEDOR');



INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3,3);