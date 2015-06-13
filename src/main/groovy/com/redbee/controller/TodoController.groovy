package com.redbee.controller

import com.redbee.domain.Todo
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.HttpStatus.*
import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/api/todo")
class TodoController {


    @Transactional(readOnly = true)
    @RequestMapping(method = GET)
    def index() {

        Todo.list()*.asBriefDTO()

    }

    @Transactional(readOnly = true)
    @RequestMapping(value="/{id}", method = GET)
    def show(@PathVariable Long id) {

        def t = Todo.get(id)

        t ? t.asBriefDTO() : new ResponseEntity(NOT_FOUND)
    }

    @Transactional
    @RequestMapping(method = POST)
    def save(@RequestBody Todo todo) {

        todo.save(failOnError: true)

        new ResponseEntity(CREATED)
    }

    @Transactional
    @RequestMapping(value="/{id}", method = PUT)
    def save(@PathVariable Long id, @RequestBody Todo todo) {

        Todo dbTodo = Todo.get(id)

        if (dbTodo) {

            dbTodo.update(todo)

            new ResponseEntity(OK)

        }  else {

            new ResponseEntity(UNPROCESSABLE_ENTITY)
        }

    }
}
