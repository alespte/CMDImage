# CMDImage
Usign ascii characters, recreate an image following a local path

README

El código toma una imagen desde una ruta local para convertirlo en caracteres en la pantalla de comandos

El proyecto está escrito en Netbeans, pero por facilidad se creó en una sola clase y en un solo paquete, 
para probarlo puedes crear un nuevo proyecto en vscode o en Netbeans, copias el contenido de CMDImage/CMDImage/src/cmdimage/CMDImage.java
y lo pegas en la clase que acabaste de crear.

Solo debes modificar las rutas de los Strings que se mencionan abajo, ten presente que los backslash deben ser dobles y deben incluir el archivo en los tres strings,
Por ejemplo:

String imagePath = "C:\\workspace\\java\\imagen_caguai.jpg"; Si la ruta donde tienes la imagen es C:\workspace\java\imagen_caguai.jpg
String generatedBWImagePath = "C:\\workspace\\java\\imagen_caguai_enBN.jpg"; //Ruta donde van a guardar la imagen en blanco y negro
String resizedBWImagePath = "C:\\workspace\\java\\imagen_caguai_enBN_resized.jpg"; //Ruta donde van a guardar la imagen redimensionada


