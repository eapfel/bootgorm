package com.redbee.domain

/**
 * Created by ezequiel on 13/6/15.
 */
enum Estado {

    PENDIENTE('Pendiente'),
    DONE('Done')

    String descripcion

    Estado(descripcion) {

        this.descripcion = descripcion
    }
}