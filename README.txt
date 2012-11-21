Per avviare Base App bisogna soddisfare alcuni prerequisiti.

[Prerequisiti]
1. Scaricare il codice dello stack dei servizi di geo-platform all'URL https://github.com/geosdi/geo-platform.

2. Creare il database spaziale su PostgreSQL con nome 'gp'.

3. Posizionarsi nella sottocartella geoplatform-service e compilare con il seguente comando: 'mvn clean install -P wms,wfs'. Verrà creato il WAR dei servizi nel modulo geoplatform-services/geoplatform-ws-core/geoplatform-ws-webapp/target.

4. Effettuare il deployment del WAR dei servizi su Apache Tomcat [Web container].

[Autenticazione]
Alla richiesta di login è possibile autenticarsi con i seguenti utenti (la password è uguale allo username): 'admin', 'user' e 'viewer'.