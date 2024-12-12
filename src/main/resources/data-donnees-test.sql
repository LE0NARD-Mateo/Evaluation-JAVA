-- mot de passe = root --
INSERT INTO entreprise (nom) VALUES
("Carrefour") ,
("Match") ,
("LECLERC");

-- mot de passe = root --
INSERT INTO utilisateur (entreprise_id,email, password) VALUES
(null,"tata@gmail.com",  "$2a$10$31nhEmGLow2iIug.qqq6RuG3GXv1fo6wXfojXNswxqYqwR8kUJUEm"),
(1,"toto@gmail.com",  "$2a$10$31nhEmGLow2iIug.qqq6RuG3GXv1fo6wXfojXNswxqYqwR8kUJUEm"),
(2,"titi@gmail.com",  "$2a$10$31nhEmGLow2iIug.qqq6RuG3GXv1fo6wXfojXNswxqYqwR8kUJUEm");

INSERT INTO Convention (entreprise_id,nom,subvention,salarie_maximum) VALUES
(1,"contrat1",2000.99,2) ,
(2,"contrat2",1500.99,3) ,
(2,"contrat3",1000.99,3),
(3,"contrat4",1.99,5);

INSERT INTO salarie (convention_id,matricule,code_barre) VALUES
(1,"Jeff", 1234 ) ,
(1,"Jarry" , 2341) ,
(2,"Pedro" , 3412) ,
(2,"Kayle" , 34125) ,
(3,"Claire" , 4123);
