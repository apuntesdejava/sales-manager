# Proyecto de Gestión de Ventas

Este proyecto pretende implementar todas las tecnologías asociadas a Java Jakarte EE aplicadas a una aplicación de Gestión de Ventas.
- JPA
- Implementación de EJB con balanceo de carga
- JSF para el Administrador
- Clustering
- Microprofile para el cliente (incluyendo una aplicación Flutter que consuma)
- Desplegado en un Cloud

## Desplegar recursos al Payara Server

`$AS_DOMAIN/bin/asadmin add-resources setup/payara-resources.xml`