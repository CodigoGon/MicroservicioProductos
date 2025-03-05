# Microservicios Productos
---

## Sobre el proyecto
<p>El proyecto consta de un sistema de microservicio donde se divide en 4, que son:</p>


- [Eureka-SV](#eurekasv) 
- [Servicio Productos](#productos)
- [Servicio Carrito de compras](#carrito)
- [Servicio Ventas](#ventas)

---
## Eureka-SV

<p id="eurekasv">Aqui creamos el servicio de Eureka para que tenga el patron de diseño Server Discovery/Server Registry para los demas Microservicios</p>

## Servicio Productos

<p id="productos">En el servicio de Productos hacemos un sistema de CRUD basico, tambien le agregamos un LoadBalancer para evitar posibles sobrecarga de solicitudes del servicio Carrito de compras y tambien Server Discovery para que Eureka lo pueda encontrar.</p>

## Servicio Carrito Compras

<p id="carrito">El carrito de compras es un microservicio con sistema CRUD pero con OpenFeign para pedir lista de productos(o productos especificos) al microservicios Productos, tambien se le agreglo CircuitBreaker y LoadBalancer para evitar errores y tambien para que no se sobrecargue
asi se mantiene el microservicio estable y escalable, sin olvidar que tambien lleva Server Discovery para conectarse con Eureka y poder encontrar mejor a el servicio productos y poder ser encontrado por el microservicio Ventas.</p>

## Servicio Ventas

<p id="ventas">En este </p>
