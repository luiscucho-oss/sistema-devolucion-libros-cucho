package com.cucho.sistemadevolucionlibro

fun main() {
    println("--- INGRESO DE DATOS ---")
    println()

    val titulo = leerTexto("Ingresa el título del libro: ")
    val tipoUsuario = leerTipoUsuario()

    val fechaPrestamo = leerFecha(
        "Ingresa la fecha de préstamo (dd/MM/yyyy): "
    )

    val fechaEntrega = leerFechaNoAnterior(
        mensaje = "Ingresa la fecha de entrega (dd/MM/yyyy): ",
        fechaMinima = fechaPrestamo
    )

    val fechaDevolucion = leerFechaNoAnterior(
        mensaje = "Ingresa la fecha de devolución (dd/MM/yyyy): ",
        fechaMinima = fechaPrestamo
    )

    val prestamo = Prestamo(
        titulo = titulo,
        tipoUsuario = tipoUsuario,
        fechaPrestamo = fechaPrestamo,
        fechaEntrega = fechaEntrega,
        fechaDevolucion = fechaDevolucion
    )

    mostrarReporte(prestamo)
}