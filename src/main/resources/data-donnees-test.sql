-- mot de passe = root --
INSERT INTO entreprise (nom) VALUES
("Carrefour") ,
("Match") ,
("LECLERC");

-- mot de passe = root --
INSERT INTO utilisateur (email, password) VALUES
("tata@gmail.com",  "$2a$10$31nhEmGLow2iIug.qqq6RuG3GXv1fo6wXfojXNswxqYqwR8kUJUEm"),
("toto@gmail.com",  "$2a$10$31nhEmGLow2iIug.qqq6RuG3GXv1fo6wXfojXNswxqYqwR8kUJUEm"),
("titi@gmail.com",  "$2a$10$31nhEmGLow2iIug.qqq6RuG3GXv1fo6wXfojXNswxqYqwR8kUJUEm");

INSERT INTO Convention (nom,subvention,salarie_maximum) VALUES
("contrat1",2000.99,2) ,
("contrat2",1500.99,3) ,
("contrat3",1000.99,1);

INSERT INTO salarie (matricule,code_barre) VALUES
("Jeff", 1 ) ,
("Jarry" , 2) ,
("Pedro" , 2) ,
("Claire" , 3);
