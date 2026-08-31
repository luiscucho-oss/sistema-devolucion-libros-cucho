package com.cucho.sistemadevolucionlibro

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private val FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy")

fun leerTexto(mensaje: String): String {
    while (true) {
        print(mensaje)
        val texto = readln().trim()

        if (texto.isNotEmpty()) {
            return texto
        }

        println("El valor no puede estar vacío.")
    }
}

fun leerTipoUsuario(): String {
    while (true) {
        val tipo = leerTexto(
            "Ingresa el tipo de usuario (Alumno/Docente): "
        )

        when (tipo.lowercase()) {
            "alumno" -> return "Alumno"
            "docente" -> return "Docente"
            else -> println("Escribe solamente Alumno o Docente.")
        }
    }
}

fun leerFecha(mensaje: String): LocalDate {
    while (true) {
        val texto = leerTexto(mensaje)

        try {
            return LocalDate.parse(texto, FORMATO_FECHA)
        } catch (error: DateTimeParseException) {
            println("Fecha inválida. Utiliza el formato dd/MM/yyyy.")
        }
    }
}

fun leerFechaNoAnterior(
    mensaje: String,
    fechaMinima: LocalDate
): LocalDate {
    while (true) {
        val fecha = leerFecha(mensaje)

        if (!fecha.isBefore(fechaMinima)) {
            return fecha
        }

        println(
            "La fecha no puede ser anterior a " +
                    fechaMinima.format(FORMATO_FECHA)
        )
    }
}