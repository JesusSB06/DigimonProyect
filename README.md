# DigimonProyect
## Introducción
Nuestra aplicación accede a una api sobre digimon, y nos permite extraer los datos de la misma y exponérselos al usuario en un formato legible. Tambien permite la creación de usuarios, y el inicio de sesión del mismo para la gestión de su propia lista de digimon.
### Postman
Usamos la aplicación postman para acceder a la api y estudiarla, observando de que está compuesta, para la creación de los POJOs necesarios para nuestra aplicación, como puede ser la clase digimon y todos us atributos, asi como para la correcta extracción de datos de la misma usando GSON.
## Funcionalidades
### Sesiones de Usuario
El programa permite crear usuarios, con un nombre de usuario y una contraseña, así como iniciar sesión con los mismos. Todos los usuarios tienen la capacidad de visualizar la información de los digimon, así como de buscarlos por su nombre, aún sin haber iniciado sesión. 
Para crear un usuario, debemos abrir el menú options, y entrar en el apartado de sesión.

Una vez dentro, introduciremos el nombre de usuario y la contraseña que el usuario desee.

Para poder crear la cuenta, los dos campos deben estar rellenados, y el usuario no debe existir previamente.

Cuando hayamos creado el usuario correctamente, la aplicación nos pedirá iniciar sesión.

Para iniciar sesión, accederemos al apartado session desde el menú options, introduciremos un usuario existente así como su contraseña, y pulsamos el botón de iniciar sesión.

Para iniciar sesión es necesario que el usuario exista, y que la contraseña que introduzcamos sea la que está relacionada con ese usuario. 

Una vez iniciada sesión, podremos acceder a todas las funcionalidades de la aplicación.
Si no iniciamos sesión, podremos buscar Digimon y acceder a su información, pero no podremos introducirlos en la lista personal, ni ver está misma ya que no hemos introducido un usuario, y por lo tanto no tenemos una lista a la que acceder.
### Busqueda de Digimon
La opción principal del programa sería la búsqueda de Digimons a traves de la API (https://digi-api.com/api/v1/digimon), esta funcionalidad podra ser usada con o sin usuario registrado pero con un usuario no registrado el usuario poseera ciertas restricciones que se explicaran mas adelante:
A esta funcionalidad del programa podremos acceder desde el menú “options” de la ventana principal del programa, se accede pulsando en la opción “DigimonAPI”:

Después de esto, dependiendo de que tengamos un usuario introducido o no, nos saldrá un JOptionPane que nos dará un aviso de que no hemos introducido ningún usuario en caso de que no lo hayamos:

Al darle a “Ok”, nos transportará a la ventana “DigimonJDialog.java”  en la cual te permitirá buscar por nombre un digimon:
 
Esta ventana estará controlada por “DigimonJDialogController.java”, el cual se encargará de las funcionalidades de los elementos del diálogo.
Cuando pulsemos en el botón buscar, se mostrará una imagen del digimon obtenida de su API junto con las facciones a las que este mismo pertenece, además, habilitará dos botones, El de “Show Information” y el más importante: “Add to list”, este botón sólo estará disponible si se ha introducido un usuario, si no, simplemente no se podrá usar su función. 
El botón “Search”, guardará el digimon buscado en una variable interna para su uso, si le damos a “Add to List”, este variable Digimon se introducirá a la lista personal del usuario y se guardará para su modificación y manejo del usuario:

El botón “Show Information…”  nos llevara a otro diálogo el cúal nos mostrará toda la información de ese Digimon obtenida desde la API, desde su descripción hasta sus habilidades:

Desde esta ventana podremos acceder al botón “Show Evolution chain…”, si pulsamos este botón, nos llevará al último diálogo de esta sección:

Este diálogo nos dará acceso a un JTabbedPane con dos tablas, una para las evoluciones y otra para las preevoluciones, cada una con sus correspondientes condiciones, a la cúal podremos acceder de forma completa con el botón “Show info…” y con el botón “Go to digimon…” nos volverá al diálogo principal de la ventana para buscar ese Digimon y acceder a su información.

### Lista personal de digimon

## Mejoras
Sesiones de usuario
Introducción de opción de eliminar usuario, en caso de comercializar, para seguir con la ley protección de datos.
Visualización de fecha y hora de último inicio de sesión.


## Reparto de tareas
- Adán Otero López
Ventana y controlador de la lista de usuarios.
- Jesús Santos Baquero
Capacidad del programa de acceso a los datos de la API.
Ventana y controlador de “DigimonJDialog” y los diálogos y controladores que desciende de este.
- Jose Carlos Domínguez Figueiras
Gestión de usuarios (inicio de sesión, creación de los mismos, manejo de errores, almacenamiento de los usuarios).
Ventana y controlador de la inicio de sesión.
- Tareas realizadas en su mayoría por todos los integrantes:
Toma de decisiones, distribución del trabajo, diseño estilístico de la aplicación, sugerencias y ayudas mutuas en las tareas de los demás, captura de errores, creación del README. 
Búsqueda de Digimon
Mejor visualización de los diálogos, más estéticos.
Poder acceder a las evoluciones sin tiempo de carga o espera.
Cierre de ciertas ventanas según abras más diálogos en caso de que el usuario habrá demasiadas.
Lista personal de Digimon:
Una segunda opción de crear Digimon para expertos de la saga, que permita agregar características una a una, en vez de adquirirlas de otro digimon.
## Conclusiones

## Autores
Adán Otero López/Anonymous180937642012
Jesús Santos Baquero/JesusSB06
Jose Carlos Domínguez Figueiras/a24josedf

