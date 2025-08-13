//Declarando pacote da sua classe java
package com.rev.revisao.controller;
//exports 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rev.revisao.model.Task;

import java.util.List;

import jakarta.validation.OverridesAttribute.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    //busca todas taferas no repositorio 
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
        //busca tafera no repositorio pelo id 
    public List<Task> getByUserId(String userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);
        return tasks;
    }
    // cria tafera
   public ResponseEntity<Task> createTask( Task task){
    Task savedTask = taskRepository.save(task);
     return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
   }

    // PUT /api/tasks/{id} - Atualizar tarefa

    @PutMapping("/{id}")//O id entre {} é parametro de busca
    public Task atualizarTask(@Pathvariable long id, @RequestBody Task NovaTask){
        if(!Task.containsKey(id)){ //Procuro por uma task com o ID
            throw new RuntimeException("Tarefa Não encontrada ");//se nao achar avisa que nao existe
        }
        novaTask.setId(id);//atualizando a novatask
        Task.put(id, novaTask);//sobe
        return novaTask
    }
    // DELETE /api/tasks/{id} - Deletar tarefa  
   public ResponseEntity<Void> deleteTask(id){ 
    taskRepository.deleteTaskbyId; //Deleta tarefa com base no id fornecido
    return ResponseEntity.noContent().build(); // retorna 204 no content
}

    // noContent() é um método estático que cria uma resposta com o código de status
    // 204 No Content.
    // build() finaliza a construção da resposta e retorna o objeto ResponseEntity
    // pronto para ser enviado.



    // PATCH /api/tasks/{id}/toggle - Alternar status da tarefa
    public Task toggleTaskCompleted(id) { 
        Task task = taskRepository.findById(id).get(); // procura a tarefa pelo id
        task.setCompleted(task.getCompleted()); // atualiza os status da tarefa
         return taskRepository.save(task);// retorna a tarefa 
}
}