# Sistema Web - Arquitectura C4

Sistema para consultar si es contribuyente SRI por RUC, consultar información del vehiculo y consultar los puntos de licencia en el sitio de la ANT.

---

Para evidenciar los niveles del C4, ingresar al siguiente link: https://s.icepanel.io/mnxGtQMjEmy2nj/o6Jz

## Autores

Jéssica Olalla y Tomás Ontaneda

## Ejecución sistema web

1. Instalar dependencias en "consulta-ciudadano-frontend" con **npm install**.
2. Ejecutar frontend con **npm run dev**.
3. Configurar el puerto para CORS en el backend (api-gateway/src/main/java/com/apigateway/config/CorsConfig.java).
4. Ejecutar los microsericios **consulta-sri**, **consulta-vehiculo** y **consulta-ant**; luego el módulo **api-gateway**.
5. Ingresar RUC/Cédula (ej. 0102030405) y Placa (ej. ABC1234) desde el frontend y consultar para mostrar resultados.