package com.rev.revisao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rev.revisao.model.Task;

import jakarta.validation.OverridesAttribute.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public List<Task> getByUserId(String userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);
        return tasks;
    }

   public ResponseEntity<Task> createTask( Task task){
    Task savedTask = taskRepository.save(task);
     return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
   }

    // PUT /api/tasks/{id} - Atualizar tarefa

    // DELETE /api/tasks/{id} - Deletar tarefa
   public ResponseEntity<void> deleteTask(id){
    taskRepository.deleteTaskbyId;
    return ResponseEntity.noContent().build();
}

    // noContent() é um método estático que cria uma resposta com o código de status
    // 204 No Content.
    // build() finaliza a construção da resposta e retorna o objeto ResponseEntity
    // pronto para ser enviado.

    // PATCH /api/tasks/{id}/toggle - Alternar status da tarefa
    public Task toggleTaskCompleted(id) {
        Task task = taskRepository.findById(id).get();
        task.setCompleted(task.getCompleted());
         return taskRepository.save(task);
}
}