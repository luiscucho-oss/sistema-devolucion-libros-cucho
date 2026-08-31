package com.cucho.sistemadevolucionlibro

import java.time.format.DateTimeFormatter
import java.util.Locale

private val FORMATO_REPORTE = DateTimeFormatter.ofPattern("dd/MM/yyyy")

fun mostrarReporte(prestamo: Prestamo) {
    val diasAtraso = calcularDiasAtraso(prestamo)
    val multaDiaria = obtenerMultaDiaria(prestamo.tipoUsuario)
    val totalMulta = calcularTotalMulta(diasAtraso, multaDiaria)

    val estado = when {
        diasAtraso > 0 -> {
            val palabraDia = if (diasAtraso == 1L) "día" else "días"
            "Devuelto con $diasAtraso $palabraDia de atraso"
        }

        prestamo.fechaDevolucion.isBefore(prestamo.fechaEntrega) ->
            "Devuelto antes de la fecha límite"

        else -> "Devuelto a tiempo"
    }

    println()
    println("=".repeat(58))
    println("SISTEMA DE DEVOLUCIÓN DE LIBROS")
    println("=".repeat(58))
    println("Título del libro:    ${prestamo.titulo}")
    println("Tipo de usuario:     ${prestamo.tipoUsuario}")
    println(
        "Fecha de préstamo:   " +
                prestamo.fechaPrestamo.format(FORMATO_REPORTE)
    )
    println(
        "Fecha de entrega:    " +
                prestamo.fechaEntrega.format(FORMATO_REPORTE)
    )
    println(
        "Fecha de devolución: " +
                prestamo.fechaDevolucion.format(FORMATO_REPORTE)
    )
    println("Estado: $estado")

    if (diasAtraso > 0) {
        mostrarDetalleMulta(
            prestamo = prestamo,
            diasAtraso = diasAtraso,
            multaDiaria = multaDiaria,
            totalMulta = totalMulta
        )
    } else {
        println()
        println("-".repeat(58))
        println("TOTAL A PAGAR: S/ 0.00")
        println("-".repeat(58))
    }
}

private fun mostrarDetalleMulta(
    prestamo: Prestamo,
    diasAtraso: Long,
    multaDiaria: Double,
    totalMulta: Double
) {
    println()
    println("-".repeat(58))
    println("DETALLE DE MULTA")
    println("-".repeat(58))
    println("Día  | Fecha      | Multa diaria  | Multa acumulada")
    println("-".repeat(58))

    for (dia in 1..diasAtraso.toInt()) {
        val fechaMulta = prestamo.fechaEntrega.plusDays(dia.toLong())
        val multaAcumulada = multaDiaria * dia

        println(
            String.format(
                Locale.US,
                "%-4d | %-10s | S/ %9.2f | S/ %13.2f",
                dia,
                fechaMulta.format(FORMATO_REPORTE),
                multaDiaria,
                multaAcumulada
            )
        )
    }

    println("-".repeat(58))
    println(
        String.format(
            Locale.US,
            "TOTAL A PAGAR: S/ %.2f",
            totalMulta
        )
    )
    println("-".repeat(58))
}