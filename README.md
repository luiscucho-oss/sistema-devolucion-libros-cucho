# Sistema de Devolución de Libros

Programa desarrollado en Kotlin para registrar la devolución de un libro, calcular los días de atraso y determinar la multa correspondiente.

## Funcionalidades

- Registro del título del libro.
- Registro del tipo de usuario: alumno o docente.
- Ingreso y validación de fechas.
- Cálculo de los días de atraso.
- Cálculo de la multa diaria y acumulada.
- Presentación de un reporte detallado de la devolución.
- Identificación del estado final del préstamo.

## Reglas principales

- Las fechas se ingresan con el formato `dd/MM/yyyy`.
- Si el libro se devuelve después de la fecha de entrega, se calculan los días de atraso.
- La multa diaria es de `S/ 1.50`.
- Si no existe atraso, no se genera ninguna multa.

## Tecnologías utilizadas

- Kotlin
- Android Studio
- Gradle

## Estructura del programa

- `Prestamo.kt`: representa los datos del préstamo.
- `EntradaDatos.kt`: solicita y valida la información ingresada.
- `Calculos.kt`: calcula los días de atraso y la multa.
- `Reporte.kt`: genera el resumen y el detalle de la devolución.
- `SistemaBiblioteca.kt`: contiene el punto de inicio del programa.

## Funcionamiento del programa
<img width="477" height="719" alt="Captura de pantalla 2026-08-31 003733" src="https://github.com/user-attachments/assets/973eadc5-e225-4912-a8f3-a003e98760e0" />
