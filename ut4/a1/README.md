<center>

# UT4-A1 Digrama de clases para una plataforma de cursos online


</center>

***Nombre:***
***Curso:*** 

### ÍNDICE

+ [Enunciado](#id1)
+ [Objetivos](#id2)
+ [Tabla de clases, relaciones y cardinalidades](#id3)



#### ***Enunciado***. <a name="id1"></a>

Una plataforma de formación online necesita un sistema que permita gestionar cursos, usuarios y el proceso de matriculación y evaluación. Realizar un diagrama de clases UML que permita modelar el sistema atendiendo a las siguientes premisas:

La plataforma gestiona usuarios registrados, de los cuales se almacenan un identificador, nombre y correo electrónico, y que pueden iniciar y cerrar sesión en el sistema. Existen dos tipos de usuarios: alumnos y profesores. Los alumnos, además de los datos comunes, disponen de un número de expediente y pueden matricularse en cursos ofrecidos por la plataforma, así como consultar las calificaciones obtenidas. Los profesores, identificados también como usuarios, cuentan con una especialidad y son los responsables de crear cursos y de evaluar a los alumnos en las distintas actividades.

Los cursos ofrecidos por la plataforma se identifican mediante un código, un título y una descripción, y pueden publicarse o cerrarse. Cada curso se estructura internamente en módulos formativos, que representan bloques temáticos ordenados dentro del curso. De cada módulo se almacena su nombre y el orden que ocupa dentro del curso, y permite acceder a los contenidos que lo forman. Un curso debe estar estructurado en módulos para poder impartirse.

Dentro de cada módulo se proponen actividades evaluables, de las que se registra un título y una fecha límite de entrega. Los alumnos pueden entregar una actividad dentro del plazo establecido. Las actividades son utilizadas para evaluar el progreso del alumnado, pero su definición no depende necesariamente de un único módulo concreto.

Como resultado de la evaluación de una actividad, se generan calificaciones, en las que se almacena la nota obtenida y un comentario asociado. Las calificaciones permiten determinar si una actividad ha sido superada o no. Un alumno puede obtener varias calificaciones a lo largo de su formación, y una misma actividad puede dar lugar a varias calificaciones correspondientes a distintos alumnos.

Un alumno puede estar matriculado simultáneamente en varios cursos y un mismo curso puede contar con varios alumnos matriculados. No es obligatorio que todos los alumnos estén matriculados en algún curso en un momento determinado, ni que un curso tenga alumnos mientras no esté publicado.

Los profesores utilizan las calificaciones exclusivamente en el momento de evaluar a los alumnos, sin que exista una relación permanente de almacenamiento entre profesores y calificaciones.

A partir de estas premisas, se deberá identificar correctamente las clases implicadas, sus atributos y métodos, así como deducir el tipo de relación existente entre ellas y las cardinalidades correspondientes, utilizando notación UML estándar.

#### ***Tabla de clases, relaciones y cardinalidades***. <a name="id2"></a>

En la siguiente tabla debes especificar cada clase, la relación existente entre clases, justificación de la relación, cardinalidad y justificación de la cardinalidad


|    Clase origen     |  Clase destino  | Tipo de relación |          Argumento del tipo de relación           |  Cardinalidad  |                                                                     Argumento de la cardinalidad                                                                     |
|:-------------------:|:---------------:|:-----------------:|:--------------------------------------------------:|:--------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|      Platform       | User / Subject  |   Composición    |     No puede existir user/subject sin Platform     | n - 1<br>n - 1 | Platform puede tener muchos subjects, pero subjects solo puede estar en una platform<br>Platform puede tener muchos usuarios, pero cada usuario solo en una Platform |
|        User         | Student/Teacher |     Herencia      |     Student/Teacher heredan atributos de User      | 1 - 1<br>1 - 1 | User puede ser Student o al revés<br>                                                                    User puede ser Teacher o al revés.                        |
|       Student       |     Subject     |    Asociación    | relación norma y ambas pueden existir sin la otra |     n - n      | Student puede tener muchas Subjects<br>Subjects pueden tener muchos estudiantes <br><br>                                                                             |
|       Teacher       |   Execercises   |    Asociación    | relación norma y ambas pueden existir sin la otra |     n - 1      | Teacher puede evaluar muchos ejercicios<br>                                                            Ejercicio puede ser evaluado por un profe                     |
|       Subject       | Módulos Form.  |   Composición    |     Modulos Form. no puede existir sin Subject     |     n - 1      | Subject puede tener varios módulos <br>                                                                        los módulos tiene un curso                          |
| Módulos Formativos |   Excercises    |    Asociación    | relación norma y ambas pueden existir sin la otra |     n - n      | Módulos Formtivos pueden tener varios cursos<br>                                Exercise puede estar en muchos módulos Formativos                                  |
|     Excercises      | Módulos Form.  |   Composición    |       Exercises no puede existir sin Subject       |     n - n      | Módulos Formtivos pueden tener varios cursos<br>                                Exercise puede estar en muchos módulos Formativos                                  |

> ***PISTA IMPORTANTE:*** El número de filas de la tabla se corresponde exactamente con el número de relaciones entre las clases.

#### ***Diagrama de clases***. <a name="id3"></a>

A continuación se muestra el diagrama de clases: 

![Diagrama UML](img/PlataformaOline1.png)










> ***NOTA*** La imagen debe ser clara y estar correctamente insertada.
