# \# 🏛️ Indexador LegalTech - Liquidación de Alquileres Comerciales

# 

# \### 📜 Motor de Indexación Contractual Post-DNU 70/2023

# 

# Aplicación web corporativa de alta gama diseñada para el cálculo, actualización y liquidación automática de cánones locativos comerciales en la República Argentina. El sistema procesa de forma dinámica la serie histórica del IPC, emite un dictamen digital estructurado con localización contable regional (`es-AR`) y cuenta con un módulo de auditoría interna.

# 

# \---

# 

# \## 🚀 Características Principales

# 

# \*   \*\*Cerebro Lógico-Financiero:\*\* Implementación exacta de la fórmula matemática post-DNU para actualización de contratos de locación.

# \*   \*\*Arquitectura Limpia \& POO:\*\* Backend desacoplado en capas de servicios (`service`), controladores (`controller`) y modelos de objetos (`model`).

# \*   \*\*Interfaz Web Premium:\*\* Diseño institucional responsivo con paleta de colores corporativa (Azul Marino y Dorado Champagne) desarrollado con HTML5, CSS3 nativo y \*\*Thymeleaf\*\*.

# \*   \*\*Carga Dinámica de Datos:\*\* Procesamiento automatizado de archivos \*\*CSV\*\* para absorber de forma continua la serie histórica del INDEC/BCRA.

# \*   \*\*Persistencia Local de Auditoría:\*\* Registro automático en tiempo real de cada liquidación exitosa en un archivo de historial local (`historial\_liquidaciones.csv`) para control de consultas.

# \*   \*\*Diseño Adaptativo (Responsive):\*\* Interfaz optimizada con Media Queries para visualización y uso táctil impecable en celulares, tablets y computadoras.

# 

# \---

# 

# \## 🛠️ Stack Tecnológico

# 

# \*   \*\*Lenguaje:\*\* Java 26

# \*   \*\*Framework:\*\* Spring Boot 4.1.0

# \*   \*\*Motor de Plantillas:\*\* Thymeleaf

# \*   \*\*Gestor de Dependencias:\*\* Maven

# \*   \*\*Diseño Front-End:\*\* HTML5 / CSS3 (Diseño responsivo / Media Queries)

# \*   \*\*Control de Versiones:\*\* Git / GitHub

# 

# \---

# 

# \## 📂 Estructura del Proyecto

# 

# ```text

# legaltech-alquileres-indexador-java/

# │

# ├── data/

# │   ├── indices.csv                 # Serie histórica continuada del IPC

# │   └── historial\_liquidaciones.csv # Base de datos local de auditoría (Excluida en Git)

# │

# └── src/main/

# &#x20;   ├── java/com/matifelitti/legaltech/alquileres/

# &#x20;   │   ├── controller/             # Controladores Web (Mapeo HTTP GET/POST)

# &#x20;   │   ├── model/                  # Molde de objetos puros (Contrato, IndicePrecios)

# &#x20;   │   └── service/                # Motor matemático y lectores/escritores CSV

# &#x20;   │

# &#x20;   └── resources/

# &#x20;       ├── static/css/             # Hojas de estilo desacopladas (styles, resultado, historial)

# &#x20;       └── templates/              # Vistas HTML nativas de Thymeleaf (index, resultado, historial)

# ```

# 

# \---

# 

# \## 💻 Instalación y Ejecución Local

# 

# \### Requisitos previos

# \*   Java JDK 26 instalado y configurado en el sistema.

# \*   Apache NetBeans IDE 25 (o cualquier IDE compatible con Maven).

# 

# \### Pasos para correr el proyecto

# 1\.  Clonar el repositorio en tu disco local limpio lejos de nubes de sincronización:

# &#x20;   ```bash

# &#x20;   git clone https://github.com/matifelitti/legaltech-alquileres-indexador-java

# &#x20;   ```

# 2\.  Abrir el proyecto desde tu IDE de preferencia como un proyecto Maven existente.

# 3\.  Ejecutar la acción \*\*Clean and Build\*\* para descargar las dependencias de Spring Boot 4.

# 4\.  Darle al botón de \*\*Play (Run Project)\*\*.

# 5\.  Abrir tu navegador e ingresar a la interfaz web local:

# &#x20;   \*   \*\*Calculador Principal:\*\* `http://localhost:8080/`

# &#x20;   \*   \*\*Panel de Auditoría Histórica:\*\* `http://localhost:8080/historial`

# 

# \---

# 

# \## 🛡️ Cumplimiento Normativo

# Este sistema procesa y almacena la información de auditoría de consultas exclusivamente en memoria y disco local del servidor, cumpliendo estrictamente con los estándares y normativas fijadas por la \*\*Ley N° 25.326 de Protección de Datos Personales\*\* de la República Argentina.



