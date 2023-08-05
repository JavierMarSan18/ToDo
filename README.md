# ToDoApp

## Descripción

Este proyecto muestra cómo se trabajó separando componentes e implementando interfaces para desacoplar la implementación. Además de abordar concurrencia.

## Detalles de la Implementación

El proyecto se estructura en diferentes componentes y se aplicaron interfaces para promover un diseño flexible y modular. Esto permite una fácil extensibilidad y mantenibilidad del código.

Se utilizó la clase `CompletableFuture` de Java para realizar tareas de manera asincrónica y aprovechar la concurrencia en el programa. Esto permite que ciertas operaciones no bloqueen el hilo principal y puedan ejecutarse en segundo plano para mejorar la eficiencia.

## Requisitos

- Java 12 o versiones superiores.