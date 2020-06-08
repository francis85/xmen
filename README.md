# xmen
Es una aplicación que verifica si un humano es mutante mediante la secuencia de ADN.

Posee dos puntos de accesos mediante las clases:
  * LambdaHandlerMutant: controlador el cual devuelve si un humano es mutante por medio de su ADN y registra el resultado en una base de datos para su posterior consulta.
  * LambdaHandlerStats: controlador el cual devuelve el ratio de humanos mutantes registrados en el base de datos mediante la consulta anterior.
  
Para el funcionamiento de la aplicación se requiere de acceso a una base de datos DynamoDB.
