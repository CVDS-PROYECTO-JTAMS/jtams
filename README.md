# Escuela Colombiana de Ingeniería
# JTAMS
# Ciclos de vida para el desarrollo de software 2020-1
### Integrantes: 
      Verbo Camacho 
      Nikolai Bermudez
      Juan Romero
## Descripción
La Plataforma banco de iniciativas de proyectos, es una herramienta donde la comunidad universitaria de la Escuela Colombiana
de Ingeniería Julio Garavito pueden registrar sus iniciativas e ideas de proyectos para ser desarrollados o gestionados por la PMO
de la Escuela. El sistema, más allá de facilitar el registro de las iniciativas e ideas de proyectos, es una valiosa base de
conocimiento donde los diferentes actores pueden revisar si hay iniciativas, ideas o intereses similares y aunar esfuerzos para la
materialización. Adicional a lo anterior, el personal académico puede integrar a los estudiantes de diferentes asignaturas o
proyectos de grado para su realización, materializando las iniciativas para el beneficio de toda la comunidad universitaria. La
PMO puede priorizar las iniciativas viables, asignar responsables, gestionar la asignación de recursos, llevar métricas e identificar
grupos de interés -a través del tiempo- que se van presentando para cada iniciativa. Con esto se espera lograr no solo la
realización de los proyectos sino una aplicación práctica de los conocimientos adquiridos por los estudiantes dentro de las
asignaturas de la Escuela generando un ambiente de aprendizaje colaborativo.

## Detalles provistos por el Stakeholder.
El objetivo del sistema es permitir el registro y seguimiento de las iniciativas e ideas de proyectos que han sido propuestas por la
comunidad universitaria de la Escuela. El banco de iniciativas debe contar con una interfaz de usuario bonita y amigable con los usuarios.

- Administrador:

      Modificar el Estado de las ideas o iniciativas.
      Agrupamiento de las ideas o iniciativas equivalentes o relacionadas
      Asignar perfil a los usuarios
      Consultar las iniciativas agrupadas.
      Modificar el estado de las iniciativas
      
- Proponente:

      Agregar una iniciativa o idea
      Editar una iniciativa
      Consultar inciiativas por palabras
     
- Personal

      Consultar todas las iniciativas
      Consultar todas las iniciativas por estado
      Consultar todas las iniciativas por area
      Consultar la estadisticas de por areas
      Consultar la estadisticas de por estados
      Permite dar like a una iniciativa
     
- Público

       Consultar todas las iniciativas
       Permite comentar cualquier iniciativa
      
      
# Arquitectura y diseño JTAMS

## Diagrama de clases
![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/PrimerasImagenes/ModeloDeClases.PNG "Diagrama de clases")

#  Manual de usuario

## Pantalla de login y de inicio: 

#### Se pueden consultar todas las iniciativas, se realiza la validacion del login y puede recordar el usuario, este login tiene la adecuada seguridad 
![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/login/Login.PNG "login")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/login/Bienvenidos.PNG "Bienvenidos")

## Pantalla del administrador:

#### Puede Modificar el Estado de las ideas o iniciativas, agrupar las iniciativas relacionadas, asignar perfil a los usuarios, consultar las iniciativas agrupadas, ademas de cerrar la sesion y con posibilidad de volver al menu principal
 
 ##### Menu principal
 
 ![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/Home.png "Home")
 
 ##### Modificar estado
 ![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/ModificarEstadoIniciativa1.png "ModificarEstadoIniciativa1")

 ![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/ModificarEstadoIniciativa2.png "ModificarEstadoIniciativa2")
 
 ##### Agrupar iniciativas
![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/AgruparIniciativas1.png "AgruparIniciativas1")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/AgruparIniciativas2.png "AgruparIniciativas2")

##### Asignar perfil a usuarios

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/AsignarPerfilUsuarios.png "AsignarPerfilUsuarios")

##### Consulta iniciativas relacionadas

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/administrador/ConsultarIniciativasAgrupadas.png "ConsultarIniciativasAgrupadas")

## Pantalla del usuario tipo personal:

####  Consultar todas las iniciativa, todas las iniciativas por estado, todas las iniciativas por area, la estadisticas de por areas,la estadisticas de por estados y por ulimo ermite dar like a una iniciativa, con posibilidad de cerrar sesion y volver al menu principal

##### Menu principal

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/Home.png "Home")


##### Consulta todas las iniciativas

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/ConsultarIniciativas1.png "ConsultarIniciativas1")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/ConsultarIniciativas2.png "ConsultarIniciativas2")

##### Consulta todas las iniciativas por estado

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/ConsultarIniciativasPorEstado.png "ConsultarIniciativaPorEstado")

##### Consulta todas las iniciativas por area

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/ConsultarIniciativasPorArea.png "ConsultarIniciativaPorArea")

##### Consulta la estadisticas de por areas

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/EstadisticasArea1.png "EstadisticasArea1")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/EstadisticasArea2.png "ConsultarEstadisticasArea2")

##### Consulta la estadisticas de por estados

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/EstadisticasEstado1.png "EstadisticasEstado1")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/EstadisticasEstado2.png "ConsultarEstadisticasEstado2")

##### Like a una iniciativa

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/Votar(like)1.png "Votar(like)1")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/personal/Votar(like)2.png "Votar(like)2")

## Pantalla del usuario tipo Publico:

####  Consultar todas las iniciativas, permite comentar cualquier iniciativa, con posibilidad de cerrar sesion y volver al menu principal

##### Menu principal

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Public/Home.png "Home")

##### Consultar todas las iniciativas, Permite comentar cualquier iniciativa

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Public/ComentarIniciativas1.png "ComentarIniciativas1")


![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Public/ComentarIniciativas1.png "ComentarIniciativas1")

## Pantalla del usuario tipo Proponente:

#### permite agregar una iniciativa, editar una iniciativa, consultar inciiativas por palabras clave, con posibilidad de cerrar sesion y volver al menu principal

##### Menu principal

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Proponente/Home.png "Home")

##### Agregar una iniciativa o idea

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Proponente/AgregarIniciativa.png "AgregarIniciativa")

##### Editar una iniciativa

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Proponente/EditarIniciativa1.png "EditarIniciativa1")

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Proponente/EditarIniciativa2.png "EditarIniciativa2")

##### Consultar inciativas por palabras clave

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/ImagenesContenidoAplicacion/Proponente/ConsultarIniciativas.png "ConsultarIniciativas")



## Enlace de la aplicacion Heroku 
  https://proyecto-jtams.herokuapp.com/

# Sprint1
En este sprint quedaron varias tareas abiertas debido a tuvimos problemas dentro del equipo y además de que tocó hacer una refactorización de la parte de UX y la mayoría del Back y del Front, pero dentro de todo pudimos superar este percanse y avanzar lo mas que pudimos trabajando de la mejor forma como equipo asignando tareas especificas a cada miembro esto le dio un poco mas de orden al desarollo del proyecto.

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/PrimerasImagenes/Sprint1.PNG "Sprint1")

# Sprint2

En este sprint  no se presentaron muchos inconveniente en el equipo ni en el proyecto debido a esto pudimos de una manera adecuada completar casi todos lo propuesto. Cada integrante del equipo trato cumplir en su debido tiempo las tareas asignadas. y adelantar y corregir tareas del sprint1 que aun estaban incompletas, completando asi todo el sprint 1 y dejandonos unas tareas baiertas del sprint2.

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/PrimerasImagenes/Sprint2.PNG "Sprint2")

# Sprint3

Finalmente, en este sprint se completaron todas las tareas pendientes del segundo sprint, y se realizó correctamente el resto de tareas asignadas para este sprint. contemplamos con seguridad que se cumplieron con todas las tareas solcitadas, y que el proyecto está en un excelente estado en cuanto a funcionalidad y calidad. Demostrando asi  en este resultado nuestro trabajo como equipo.

![alt text](https://github.com/CVDS-PROYECTO-JTAMS/jtams/blob/master/PrimerasImagenes/Sprint3.PNG "Sprint3")
