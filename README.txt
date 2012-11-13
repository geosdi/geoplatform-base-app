Affinchè l'applicazione Base App funzioni bisogna scaricare il codice dello stack dei servizi di geo-platform all'url https://github.com/geosdi/geo-platform.
Si deve poi creare il database spaziale su postgres con nome gp.
Posizionarsi in geoplatform-service e compilare con il seguente comando : mvn clean install -Pwms,wfs.
Verrà creato il war dei servizi nel modulo geoplatform-services/geoplatform-ws-core/geoplatform-ws-webapp/target.
Deploiare il war dei servizi sotto tomcat.