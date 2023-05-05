Esta API fue desarrollada para FARMU para dar cumplimiento a la prueba de backend.

Para realizar el recortador de URL después devarias consultas el codigo esta basado en la lógica expuesta en: https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/ esto dado que fue la fuente con más practicidad al usar el id de la base de datos para basarse en la url corta.

las tecnologias usadas son: Java 17, Junit, mockito, spring boot, spring mvc, hybernate, mysql, lombok, mapstruck, maven y thumbnailator.


los servicios desarrollados fueron:
para crear la url corta:
    http://localhost:8080/api/tools/shortener/v1/createShort
para recuperar la url larga:
    http://localhost:8080/farmu/hs
para cambiar el tamaño de la imagen:
    http://localhost:8080/api/tools/image/v1/resize

A nivel de código su uso el diseño controller-service-repository de Spring, así mismo para el manejo de POJOs se trabajo del lado de la base de datos con objetos "dominios" y para el lado del controlador DTOs usando mappers entre puente para convertir los objetos.

A nivel de base de datos se crearon las entidades:
farmutools.url: que contienen un Id, fecha de creacion, url sin alterar y url corta.