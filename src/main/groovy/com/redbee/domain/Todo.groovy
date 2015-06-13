package com.redbee.domain

import grails.persistence.Entity

/**
 * Created by ezequiel on 13/6/15.
 */
@Entity
class Todo {

    String nombre

    String prioridad

    Estado estado

    def asBriefDTO() {

        def dto = [:]

        dto['id'] = id
        dto['nombre'] = nombre
        dto['prioridad'] = prioridad
        dto['estado'] = estado

        dto
    }

    def update(Todo todo) {

        this.nombre = todo.nombre
        this.prioridad = todo.prioridad
        this.estado = todo.estado

        this.save(failOnError: true)
    }
}
