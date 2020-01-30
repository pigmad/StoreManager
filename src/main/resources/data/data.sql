-- STORES 
INSERT INTO store(city) VALUES('Paris');
INSERT INTO store(city) VALUES('Lyon');
INSERT INTO store(city) VALUES('Tours');

-- DIRECTORS
INSERT INTO director(idStore,lastName,firstName,mail,password) VALUES(1,'Gilles','Dupont','gilles.dupont@magasin.fr','director');
INSERT INTO director(idStore,lastName,firstName,mail,password) VALUES(2,'Felicien','Coupart','felicien.coupart@magasin.fr','director');
INSERT INTO director(idStore,lastName,firstName,mail,password) VALUES(3,'Ignace','Labrosse','ignace.labrosse@magasin.fr','director');

UPDATE store SET idDirector = 1 WHERE idStore=1;
UPDATE store SET idDirector = 2 WHERE idStore=2;
UPDATE store SET idDirector = 3 WHERE idStore=3;

-- STORE 1 SHELVES
INSERT INTO shelf(idStore,name) VALUES(1,'shelf1');
INSERT INTO shelf(idStore,name) VALUES(1,'shelf2');
-- STORE 2 SHELVES
INSERT INTO shelf(idStore,name) VALUES(2,'shelf3');
INSERT INTO shelf(idStore,name) VALUES(2,'shelf4');
-- STORE 3 SHELVES
INSERT INTO shelf(idStore,name) VALUES(3,'shelf5');
INSERT INTO shelf(idStore,name) VALUES(3,'shelf6');
INSERT INTO shelf(idStore,name) VALUES(3,'shelf7');

-- STORE 1 SELLERS 
    -- SHELF 1 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(1,1,true,'Gabriel','Martin','gabriel.martin@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(1,1,false,'Louis','Durant','louis.durant@magasin.fr','seller');
    -- SHELF 2 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(1,2,true,'Lucas','Robert','lucas.robert@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(1,2,false,'Jules','Petit','jules.petit@magasin.fr','seller');

-- STORE 2 SELLERS 
    -- SHELF 3 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(2,3,true,'Joy','Brousse','joy.brousse@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(2,3,false,'Clovis','Bousquet','clovis.bousquet@magasin.fr','seller');
    -- SHELF 4 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(2,4,true,'Pansy','Mathieu','pansy.mathieu@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(2,4,false,'Sibyla','Dandonneau','sibyla.dandonneau@magasin.fr','seller');

-- STORE 3 SELLERS 
    -- SHELF 5 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,5,true,'Isaac','Guimond','isaac.guimond@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,5,false,'Avril','Grondin','avril.grondin@magasin.fr','seller');
    -- SHELF 6 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,6,true,'Garland','Quirion','garland.quirion@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,6,false,'Peverell','Léveillé','peverell.léveillé@magasin.fr','seller');
    -- SHELF 7 SELLERS
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,7,true,'Colette','Leroux','colette.leroux@magasin.fr','seller');
    INSERT INTO seller(idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,7,false,'Claude','Therriault','claude.therriault@magasin.fr','seller');

-- STORE 1 ITEMS
INSERT INTO item(idShelf,name,price,quantity) VALUES(1,'item1',22.99,5);
INSERT INTO item(idShelf,name,price,quantity) VALUES(1,'item2',23.99,8);
INSERT INTO item(idShelf,name,price,quantity) VALUES(1,'item3',24.99,6);
INSERT INTO item(idShelf,name,price,quantity) VALUES(2,'item4',25.99,4);
INSERT INTO item(idShelf,name,price,quantity) VALUES(2,'item5',26.99,19);
INSERT INTO item(idShelf,name,price,quantity) VALUES(2,'item6',27.99,2);

-- STORE 2 ITEMS
INSERT INTO item(idShelf,name,price,quantity) VALUES(3,'item7',24.99,30);
INSERT INTO item(idShelf,name,price,quantity) VALUES(3,'item8',49.99,4);
INSERT INTO item(idShelf,name,price,quantity) VALUES(3,'item9',39.99,10);
INSERT INTO item(idShelf,name,price,quantity) VALUES(4,'item10',74.99,34);
INSERT INTO item(idShelf,name,price,quantity) VALUES(4,'item11',99.99,12);
INSERT INTO item(idShelf,name,price,quantity) VALUES(4,'item12',149.99,8);

-- STORE 3 ITEMS
INSERT INTO item(idShelf,name,price,quantity) VALUES(5,'item13',4.99,5);
INSERT INTO item(idShelf,name,price,quantity) VALUES(5,'item14',5.99,8);
INSERT INTO item(idShelf,name,price,quantity) VALUES(5,'item15',6.99,6);
INSERT INTO item(idShelf,name,price,quantity) VALUES(6,'item16',7.99,4);
INSERT INTO item(idShelf,name,price,quantity) VALUES(6,'item17',8.99,19);
INSERT INTO item(idShelf,name,price,quantity) VALUES(6,'item18',9.99,2);
INSERT INTO item(idShelf,name,price,quantity) VALUES(7,'item19',10.99,4);
INSERT INTO item(idShelf,name,price,quantity) VALUES(7,'item20',11.99,19);
INSERT INTO item(idShelf,name,price,quantity) VALUES(7,'item21',112.99,2);