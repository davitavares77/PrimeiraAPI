package com.rev.revisao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.OverridesAttribute.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    public List<Task>getAllTask(){
        return taskRepository.findAll();
    }
    
    
    // GET /api/tasks/{id} - Buscar tarefa por ID
    // POST /api/tasks - Criar nova tarefa
    // PUT /api/tasks/{id} - Atualizar tarefa
    // DELETE /api/tasks/{id} - Deletar tarefa
    // PATCH /api/tasks/{id}/toggle - Alternar status da tarefa
}