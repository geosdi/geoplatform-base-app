[English Version]
A preliminary operation to do before launch the GeoPlatform Base App is:

[Prerequisite]
1. It is necessary to download the geo-platform's service stack web service from https://github.com/geosdi/geo-platform

2. Create a spatial PostgresSQL database named 'gp'

3. Execute the following command 'mvn clean install -P wms,wfs' from the subfolder %Geo_Platform_DIR%/geoplatform-services
  In this way the test code will be executed and the gp database will be filled with all the necessary data.
  Furthermore will be created the WAR archive containing the geo-platform web services in the 
  %Geo_Platform_DIR%/geoplatform-services/geoplatform-ws-core/geoplatform-ws-webapp/target  folder.

4. Deploy the war archive using Apache Tomat on port 8080, or otherwise it is possible to launch the web services
  stack using jetty from %Geo_Platform_DIR%/geoplatform-services/geoplatform-ws-core/geoplatform-ws-webapp
  and typing: 'mvn jetty:run -P wms,wfs'

5. After compiling %geoplatform-base-app% using 'mvn clean install' you can launch it using %geoplatform-base-app% mvn jetty:run
  in this way you can access to the geoplatform-base-app on localhost:9393

[Authentication]
You can login using the following users (the password is the same as the username): 'admin', 'user' and 'viewer'.

[Adding functionalities]
To add functionalities to the base app it is possible to follow the wiki guide (https://github.com/geosdi/geoplatform-base-app/wiki)

[Italian Version]
Per avviare Base App bisogna soddisfare alcuni prerequisiti.

[Prerequisiti]
1. Scaricare il codice dello stack dei servizi di geo-platform all'URL https://github.com/geosdi/geo-platform.

2. Creare un database con estensione spaziale su PostgreSQL con nome 'gp'.

3. Posizionarsi nella sottocartella %Geo_Platform_DIR%/geoplatform-services e compilare con il seguente comando: 
  'mvn clean install -P wms,wfs' . Verranno eseguiti i test che andranno a riempire il databse e verrà creato il 
  WAR dei servizi nel modulo %Geo_Platform_DIR%/geoplatform-services/geoplatform-ws-core/geoplatform-ws-webapp/target.

4. Effettuare il deployment del WAR dei servizi su Apache Tomcat [Web container] su porta 8080 oppure in alternativa
  è possibile lanciare lo stack dei servizi sfruttando jetty da %Geo_Platform_DIR%/geoplatform-services/geoplatform-ws-core/geoplatform-ws-webapp
  con il seguente comando: 'mvn jetty:run -P wms,wfs'

5. Dopo aver compilato l'applicazione %geoplatform-base-app% 'mvn clean install' è possibile lanciarla usando
  %geoplatform-base-app% mvn jetty:run , l'applicazione sarà disponibile su localhost:9393

[Autenticazione]
Alla richiesta di login è possibile autenticarsi con i seguenti utenti (la password è uguale allo username): 'admin', 'user' e 'viewer'.

[Aggiunta funzionalità]
Per poter aggiungere funzionalità alla Base App è possibile seguire la nostra guida wiki (https://github.com/geosdi/geoplatform-base-app/wiki)
