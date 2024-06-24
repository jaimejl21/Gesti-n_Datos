CREATE TABLE Servidor(id INT PRIMARY KEY, region VARCHAR NOT NULL, numSalas INT);
CREATE TABLE Sala(id INT, idServidor INT, PRIMARY KEY(id,idServidor), 
FOREIGN KEY(idServidor) REFERENCES Servidor(id));
CREATE TABLE Equipo(nombre VARCHAR PRIMARY KEY, pais VARCHAR NOT NULL, 
liga VARCHAR NOT NULL);
CREATE TABLE Futbolistas(nombre VARCHAR PRIMARY KEY, equipo VARCHAR NOT NULL, 
edad INT NOT NULL, media INT NOT NULL, FOREIGN KEY (equipo) REFERENCES Equipo(nombre));
CREATE TABLE Club(nombre VARCHAR PRIMARY KEY, maxMiembros INT NOT NULL);
CREATE TABLE Vitrina(trofeos VARCHAR, edicionTrofeos INT, 
nombreClub VARCHAR NOT NULL, PRIMARY KEY(trofeos,edicionTrofeos), 
FOREIGN KEY (nombreClub) REFERENCES Club(nombre));
CREATE TABLE Articulo(nombre VARCHAR PRIMARY KEY, precio INT NOT NULL);
CREATE TABLE Jugador(nick VARCHAR PRIMARY KEY, division INT NOT NULL, 
monedas INT NOT NULL, cuentaOrigin VARCHAR, club VARCHAR, 
FOREIGN KEY (club) REFERENCES Club(nombre));
CREATE TABLE Compra(idCompra INT PRIMARY KEY, nick VARCHAR NOT NULL, 
fecha DATE NOT NULL, FOREIGN KEY (nick) REFERENCES Jugador(nick));
CREATE TABLE Carrito(idCompra INT, nombre VARCHAR, cantidad INT NOT NULL, 
PRIMARY KEY(idCompra,nombre), FOREIGN KEY (idCompra) REFERENCES Compra(idCompra), 
FOREIGN KEY (nombre) REFERENCES Articulo(nombre));
CREATE TABLE Partido(id INT PRIMARY KEY, jugador1 VARCHAR NOT NULL, jugador2 VARCHAR NOT NULL,
 equipo1 VARCHAR NOT NULL, equipo2 VARCHAR NOT NULL, tipo VARCHAR NOT NULL, 
idSala INT NOT NULL, idServidor INT NOT NULL, ganador VARCHAR, 
FOREIGN KEY (jugador1) REFERENCES Jugador(nick), FOREIGN KEY (jugador2) REFERENCES Jugador(nick), 
FOREIGN KEY (equipo1) REFERENCES Equipo(nombre), FOREIGN KEY (equipo2) REFERENCES Equipo(nombre), 
FOREIGN KEY (idSala) REFERENCES Sala(id), 
FOREIGN KEY (idServidor) REFERENCES Servidor(id));   



--Inserción de datos para las consultas
	
	--Primera
	INSERT INTO Club VALUES('Novatos',7);
	INSERT INTO Club VALUES('FreeFire',5);
	
	INSERT INTO Jugador VALUES('aitoorgrc._','Primera',500000,NULL,'Novatos');
	INSERT INTO Jugador VALUES('jaimejl21','Segunda',30000,'jaimejl21','FreeFire');
	
	--Segunda
	INSERT INTO Equipo VALUES('Atlético de Madrid','España','Primera');
	INSERT INTO Equipo VALUES('Barcelona','España','Primera');
	INSERT INTO Equipo VALUES('Chelsea','Inglaterra','Primera');
	INSERT INTO Equipo VALUES('Sevilla','España','Primera');
	INSERT INTO Equipo VALUES('Juventus','Italia','Primera');
	
	INSERT INTO Futbolistas VALUES('Cristiano Ronaldo','Juventus',36,92);
	INSERT INTO Futbolistas VALUES('Luis Suárez','Atlético de Madrid',34,87);
	INSERT INTO Futbolistas VALUES('Antoine Griezmann','Barcelona',29,86);
	INSERT INTO Futbolistas VALUES('Alejandro Papu Gómez','Sevilla',33,86);
	INSERT INTO Futbolistas VALUES('Olivier Giroud','Chelsea',34,79);
	
	--Tercera
	INSERT INTO Articulo VALUES('Estadio',750);
	INSERT INTO Articulo VALUES('Equipación',500);
	INSERT INTO Articulo VALUES('Mejoras',400);
	INSERT INTO Articulo VALUES('Botas',450);
	
	INSERT INTO Compra VALUES(1,'aitoorgrc._','2021-03-09');
	INSERT INTO Compra VALUES(3,'jaimejl21','2021-03-09');
	
	INSERT INTO Carrito VALUES(1,'Estadio',1);
	INSERT INTO Carrito VALUES(3,'Estadio',3);
	INSERT INTO Carrito VALUES(3,'Botas',2);
	INSERT INTO Carrito VALUES(1,'Botas',7);
	
	--Cuarta
	INSERT INTO Vitrina VALUES('Champions League',2007, 'FreeFire');
	INSERT INTO Vitrina VALUES('Europa League',2020, 'Novatos');
	
	--Quinta
	INSERT INTO Equipo VALUES('Leipzig','Alemania','Primera');
	INSERT INTO Equipo VALUES('Real Betis','España','Primera');	
	INSERT INTO Equipo VALUES('Oporto','Portugal','Primera');
	INSERT INTO Equipo VALUES('Borussia Dortmund','Alemania','Primera');
	INSERT INTO Equipo VALUES('Real Madrid','España','Primera');
	INSERT INTO Equipo VALUES('Olympique de Lyon','Francia','Primera');
	INSERT INTO Equipo VALUES('Bayern München','Alemania','Primera');
	INSERT INTO Equipo VALUES('Milan','Italia','Primera');
	INSERT INTO Equipo VALUES('Paris Saint Germain','Francia','Primera');
	INSERT INTO Equipo VALUES('Manchester United','Inglaterra','Primera');
	
	INSERT INTO Partido VALUES(1,'jaimejl21','aitoorgrc._','Real Madrid','Oporto','Gol de oro',1,5,'Oporto');
	INSERT INTO Partido VALUES(2,'jaimejl21','aitoorgrc._','Barcelona','Olympique de Lyon','Normal',4,4,'Barcelona');
	INSERT INTO Partido VALUES(3,'aitoorgrc._','jaimejl21','Atlético de Madrid','Chelsea','Tanda de penaltis',3,3,'Chelsea');
	INSERT INTO Partido VALUES(4,'aitoorgrc._','jaimejl21','Leipzig','Borussia Dortmund','Bola misteriosa',2,3,'Leipzig');
	INSERT INTO Partido VALUES(5,'jaimejl21','aitoorgrc._','Bayern München','Milan','Sin reglas',5,2,'Milan');
	INSERT INTO Partido VALUES(6,'aitoorgrc._','jaimejl21','Paris Saint Germain','Manchester United','Final de la champions',2,1,'Manchester United');
	INSERT INTO Partido VALUES(7,'jaimejl21','raul2000pro','Real Betis','Oporto','Gol de oro',1,5,'Oporto');
	INSERT INTO Partido VALUES(8,'jaimejl21','raul2000pro','Barcelona','Oporto','Normal',4,4,'Oporto');
	INSERT INTO Partido VALUES(9,'raul2000pro','jaimejl21','Atlético de Madrid','Chelsea','Tanda de penaltis',3,3,'Chelsea');
	
	--Sexta
	INSERT INTO Compra VALUES(4,'raul2000pro','2021-02-27');



	--INSERT en tablas no utilizadas para las consultas
	INSERT INTO Servidor VALUES(1,'Europa',12);
	INSERT INTO Servidor VALUES(2,'Asia',8);

	INSERT INTO Sala VALUES(1,2);
	INSERT INTO Sala VALUES(2,3);




	
--Consultas
	--Una tabla con filtros
	
		--Primera consulta
		UPDATE Jugador SET monedas = (monedas + 30) WHERE cuentaOrigin NOT NULL;  
		SELECT * FROM Jugador WHERE cuentaOrigin NOT NULL;
		
		--Segunda consulta
		SELECT nombre, MAX(media) FROM Futbolistas;
		
	--JOIN
	
		--Tercera consulta (historial de compras, jugador-carrito(cantidad)) 
		SELECT j.nick, c.nombre, c.cantidad FROM Jugador j JOIN Compra co ON j.nick = co.nick 
		JOIN Carrito c ON co.idCompra = c.idCompra ORDER BY j.nick;
		
		
		--Cuarta consulta (sacar equipo con mas victorias)
		SELECT j.nick, c.nombre, v.trofeos FROM jugador j 
		JOIN club c ON j.club = c.nombre JOIN vitrina v ON v.nombreClub = c.nombre 
		WHERE v.trofeos = 'Champions League';
		
		
	--GROUP BY
	
		-- Quinta consulta
		SELECT ganador, COUNT(ganador) 
		FROM Partido GROUP BY ganador 
		ORDER BY COUNT(ganador) desc;
	
	
		--Sexta consulta (Ordenar de manera descendente objetos comprados)
		SELECT a.nombre, sum(c.cantidad) FROM Articulo a JOIN Carrito c ON a.nombre = c.nombre 
		JOIN compra co ON c.idCompra = co.idCompra WHERE co.fecha = '2021-03-09' 
		GROUP BY a.nombre ORDER BY sum(c.cantidad) DESC;	
		