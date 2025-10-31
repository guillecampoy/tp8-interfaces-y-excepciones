# Trabajo Práctico 8 – Interfaces y Excepciones

> **Cátedra:** Programación II  
> **Alumno:** Guillermo Campoy  
> **Docente:** Giuliano Espejo  
> **Año/Cuat.**: 2025 / 2C  
> **Lenguaje:** Java (>= 21)

## 📌 Objetivo

Desarrollar habilidades en el uso de **interfaces** y manejo de **excepciones** en Java para
fomentar la modularidad, flexibilidad y robustez del código. Comprender la definición e
implementación de interfaces como contratos de comportamiento y su aplicación en el
diseño orientado a objetos. Aplicar jerarquías de excepciones para controlar y
comunicar errores de forma segura. Diferenciar entre excepciones comprobadas y no
comprobadas, y utilizar bloques try, catch, finally y throw para garantizar la
integridad del programa. Integrar interfaces y manejo de excepciones en el desarrollo
de aplicaciones escalables y mantenibles.

---

## 📂 Estructura del Proyecto

```bash
Tp8-interfaces-y-excepciones/
├── ../app
│      ├── app/
│      │   └── Main.java                       # Clase con método main, menu simple para ejecución del trabajo  
│      ├── core/                               # Clases soporte cross del proyecto, como menues y decoradores
│      │    ├── utils/
│      │    │      └──                         # Decorado en consola     
│      │    └── menu/                  
│      │           └──                         # Menu principal      
│      ├── data/
│      │      ├── exceptions/ 
│      │      │     └──                        # Excepciones custom
│      │      ├── interfaces/                  
│      │      │     └──                        # Interfaces para casos de uso de ecommerce
│      │      ├── mediospago/ 
│      │      │     └──                        # Clases específicas de medios de pago
│      │      └── model/                  
│      │           └──                         # Clases modelo de datos ecommerce   
│      ├── featuress/                          
│      │   └──                                 # Casos de uso ecommerce (interfaces) y manejo errores (exceptions)
│      ├── fixtures/                          
│      │   └──                                 # Carga de datos de prueba para los ejercicios
│      └── usecases/
│            └──                               # utilitarios para modelado de casos de uso
├── README.md
└── .gitignore
```

## Casos de uso y demostración del trabajo

### 1- E-commerce (interfaces):

>Caso de uso 1: “Crear un Pedido para un Cliente”

**Objetivo:** Instanciar un cliente, crear un pedido vacío y asociarlos.

Pasos:
El usuario elige un cliente existente (o se crea uno nuevo).
Se crea un Pedido con estado inicial CREADO.
Se registra quién es el cliente asociado a ese pedido.
Se muestra “Pedido creado exitosamente”.

**Justificación**
Muestra creación de objetos y relación 1 a 1 Pedido ↔ Cliente (asociación).


>Caso de uso 2: “Agregar productos al Pedido”

**Objetivo:** Popular un pedido con varios productos y calcular el total.

Pasos:
Listar productos disponibles.
El usuario selecciona uno o más productos.
Esos productos se agregan a la List<Producto> dentro de Pedido.
Llamar pedido.calcularTotal() (implementado de Pagable) y mostrar el monto acumulado.

**Justificación**
Pedido implementa Pagable: suma los precios de todos los productos.
Producto también implementa Pagable individualmente (puede devolver su propio precio como total).
Uso de colecciones (ArrayList).

>Caso de uso 3: “Simular pago del Pedido”

**Objetivo:** Elegir un medio de pago concreto y procesar el pago.

Escenario:
TarjetaCredito implementa PagoConDescuento.
aplicarDescuento(monto) por ejemplo 15% off si supera cierto umbral.
procesarPago(monto) devuelve true/false simulando autorización.
PayPal implementa Pago. No aplica descuento, solo procesarPago(monto).

Pasos:
Calcular el total del Pedido (pedido.calcularTotal()).
Ofrecer medios de pago:
Tarjeta de crédito (usa descuento si corresponde).
PayPal (sin descuento).

* Si elige Tarjeta:
mostrar precio original mostrar precio con descuento (aplicarDescuento)
llamar procesarPago(montoDescontado)

* Si elige PayPal: llamar procesarPago(montoOriginal)

Si el pago fue aprobado:
actualizar estado del pedido a PAGADO.

**Justificación:**
Demuestra polimorfismo por interfaz: Pago y PagoConDescuento.
Muestra BigDecimal y cálculo con descuentos.
Cambia el estado del pedido (transición de negocio).

Validación de interfaz:
Ejercita Pago / PagoConDescuento.

> Caso de uso 4: “Avanzar el estado del Pedido y notificar al Cliente”

**Objetivo:** Cambiar estado y notificar.

Pasos:
Seleccionar un pedido existente.
Avanzar su estado (por ejemplo de PAGADO → EN_PREPARACION → ENVIADO → ENTREGADO).
Esto lo hace un método tipo pedido.avanzarEstado().
Cada vez que cambia el estado, Pedido invoca internamente a cliente.notificar("Tu pedido pasó a ENVIADO").

**Justificación:**
Cliente implementa Notificable.
Pedido depende de Notificable y la llama cuando cambia el estado → esto es dependencia de uso, modelada en tus apuntes (flecha punteada UML con <<call>>) porque Pedido usa Cliente para enviar mensaje en ese momento, no para un cálculo propio.
Valida la interfaz Notificable.
Validación de interfaz:
Ejercita Notificable.
Además refuerza “Tell, Don’t Ask”: el pedido le dice al cliente “te notifico”, no le pregunta datos para notificarlo él mismo.

>Caso de uso 5: “Resumen del Pedido”

**Objetivo:** Mostrar de forma legible todo el estado actual de un pedido.

Se muestra en consola:

Cliente: nombre

Estado actual

Listado de productos (nombre + precio)

Total pagado / pendiente

Medio de pago usado (opcional si querés guardarlo)

Historial de notificaciones enviadas (opcional como texto en consola)

**Justificación:**

Integra todo en una vista “final”: colecciones, cálculo total, estado, notificaciones.

### 2- Excepciones:

>Caso de uso 1: “División segura”

Solicitar dos números y dividirlos. Manejar ArithmeticException si el divisor es cero.

>Caso de uso 2: “Conversión de cadena a número”

Leer texto del usuario e intentar convertirlo a int. Manejar NumberFormatException si no es válido.

>Caso de uso 3: “Lectura de archivo”

Leer un archivo de texto y mostrarlo. Manejar FileNotFoundException si el archivo no existe.

>Caso de uso 4: “Excepción personalizada”

Crear EdadInvalidaException. Lanzarla si la edad es menor a 0 o mayor a 120. Capturarla y mostrar mensaje.

>Caso de uso 5: “Uso de try-with-resources”

Leer un archivo con BufferedReader usando try-with-resources. Manejar IOException correctamente.

---
✍️ **Autor:** Guillermo Campoy  
📅 **Año:** 2025