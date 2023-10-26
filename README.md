# prueba-tecnica-25102023
Prueba técnica QA Senior (Selenium + java + appium):

Página DEMO: Guru99 Bank Home Page

Visitar la página que se va a probar usando Chrome como navegador
Crear casos de uso a testear como:

1. Verificar que el título de la página sea correcto (Guru99 Bank)
2. Verificar que aparecen campos de login, password y boton login y reset
3. ...Casos segun veas necesarios para su validación (Ejemplo comporbación de datos correctos, incorrectos, etc)
4. Crear un README.md con instrucciones
5. Crear Workflow GitHub Actions para ejecutar los tests cada noche.


## Configuración

1. Descargar entorno, preferiblemente IntelliJ C Edition.
2. Abrir el proyecto desde IntelliJ
3. Hacer checkout a develop ya que es la rama que está preparada para ser ejecutada en local.
4. Ejecutar tests. (Es posible que dependiendo de la versión de google chrome instalada sea necesario cambiar el chromedriver).

## Github Actions

En la pestaña Actions se ha configurado un job que ejecuta los tests al final de cada dia pero también se puede ejecutar manualmente. Se espera que el workflow muestre una traza de error dado que uno de los tests falla intencionadamente.
