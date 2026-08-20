# ESTÁNDAR DE CODIFICACIÓN
## Proyecto COMFEY – Asistente Médico Virtual

**Proyecto:** COMFEY – Asistente Médico Virtual  
**Lenguaje:** Java  
**Base de datos:** H2  
**Tecnología de conexión:** JDBC  
**Control de versiones:** Git y GitHub  

---

## 1. Objetivo

Establecer las reglas y buenas prácticas utilizadas durante el desarrollo del proyecto COMFEY, con el propósito de mantener un código organizado, legible, uniforme y fácil de mantener.

---

## 2. Nomenclatura

### 2.1 Clases

Las clases utilizan la convención PascalCase, iniciando cada palabra con letra mayúscula.

Ejemplos:

- `ConexionBD`
- `Usuario`
- `UsuarioDAO`
- `PrincipalCRUD`
- `PruebaConexion`

### 2.2 Variables y atributos

Las variables y atributos utilizan camelCase.

Ejemplos:

- `nombre`
- `correo`
- `contrasena`
- `tipoUsuario`
- `usuarioDAO`

### 2.3 Métodos

Los métodos utilizan camelCase y nombres descriptivos relacionados con la acción que realizan.

Ejemplos:

- `conectar()`
- `crearTabla()`
- `registrarUsuario()`
- `listarUsuarios()`
- `actualizarUsuario()`
- `eliminarUsuario()`

### 2.4 Constantes

Las constantes se escriben utilizando letras mayúsculas y guiones bajos.

Ejemplo:

`URL_BASE_DATOS`

---

## 3. Organización del proyecto

El código fuente se organiza mediante paquetes según la responsabilidad de cada componente:

```text
backend/src/
├── conexion/
├── modelo/
├── dao/
└── principal/
