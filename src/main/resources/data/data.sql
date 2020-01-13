INSERT INTO tab_store(idStore,idDirector,city) VALUES(1,1,"Paris");

INSERT INTO tab_director(idDirector,idStore,lastName,firstName,mail,password) VALUES(1,1,"Gilles","Dupont","gilles.dupont@magasin.fr","director");

INSERT INTO tab_shelf(idShelf,idStore,name) VALUES(1,1,"shelf1");
INSERT INTO tab_shelf(idShelf,idStore,name) VALUES(2,1,"shelf2");


INSERT INTO tab_seller(idSeller,idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(1,1,1,true,"Gabriel","Martin","gabrielmartin@magasin.fr","seller");
INSERT INTO tab_seller(idSeller,idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(2,1,1,false,"Louis","Durant","louis.durant@magasin.fr","seller");
INSERT INTO tab_seller(idSeller,idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(3,1,2,true,"Lucas","Robert","lucas.robert@magasin.fr","seller");
INSERT INTO tab_seller(idSeller,idStore,idShelf,isAdmin,lastName,firstName,mail,password) VALUES(4,1,2,false,"Jules","Petit","jules.petit@magasin.fr","seller");

INSERT INTO tab_item(idItem,idShelf,name,price,quantity) VALUES(1,1,"item1",22.99,5);
INSERT INTO tab_item(idItem,idShelf,name,price,quantity) VALUES(2,1,"item2",23.99,8);
INSERT INTO tab_item(idItem,idShelf,name,price,quantity) VALUES(3,1,"item3",24.99,6);
INSERT INTO tab_item(idItem,idShelf,name,price,quantity) VALUES(4,2,"item4",25.99,4);
INSERT INTO tab_item(idItem,idShelf,name,price,quantity) VALUES(5,2,"item5",26.99,19);
INSERT INTO tab_item(idItem,idShelf,name,price,quantity) VALUES(6,2,"item6",27.99,2);