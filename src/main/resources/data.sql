USE `ghsicilianotfi`;

LOCK TABLES `usuario_rol` WRITE;
insert into `usuario_rol` VALUES (1,'ROLE_ADMIN');
insert into `usuario_rol` VALUES (2,'ROLE_AUDIT');
UNLOCK TABLES;

LOCK TABLES `usuario` WRITE;
INSERT INTO `usuario` VALUES(1, 'oo2.grupo20@gmail.com', true, 'admin', 'admin', 1, 1);
INSERT INTO `usuario` VALUES(2, 'oo2@gmail.com', true, 'audit', 'audit', 1, 2);
UNLOCK TABLES;



