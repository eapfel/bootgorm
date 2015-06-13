package com.redbee

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by ezequiel on 13/6/15.
 */
@SpringBootApplication
class Application {

    /*@Bean
    CommandLineRunner init() {

        return {
            ["Tarea1","Tarea2"].each {

                def todo = new Todo()

                todo.nombre = it
                todo.prioridad = 1
                todo.estado = PENDIENTE

                todo.save(failOnError:true)
            }
        }
    }*/

    static void main(String[] args) {
        SpringApplication.run Application, args
    }
}
