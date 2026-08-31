package com.cucho.sistemadevolucionlibro

import java.time.temporal.ChronoUnit

private const val MULTA_DIARIA_ALUMNO = 1.50
private const val MULTA_DIARIA_DOCENTE = 1.00

fun obtenerMultaDiaria(tipoUsuario: String): Double {
    return when (tipoUsuario) {
        "Alumno" -> MULTA_DIARIA_ALUMNO
        "Docente" -> MULTA_DIARIA_DOCENTE
        else -> 0.0
    }
}

fun calcularDiasAtraso(prestamo: Prestamo): Long {
    val diferencia = ChronoUnit.DAYS.between(
        prestamo.fechaEntrega,
        prestamo.fechaDevolucion
    )

    return diferencia.coerceAtLeast(0L)
}

fun calcularTotalMulta(
    diasAtraso: Long,
    multaDiaria: Double
): Double {
    return diasAtraso.toDouble() * multaDiaria
}