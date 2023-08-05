package edu.jjms.ui;

import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.TaskDto;
import edu.jjms.models.dto.UpdateTaskDto;
import edu.jjms.presentation.inter.ITaskController;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class ToDoApp {

    private final ITaskController controller;
    private final Scanner scanner = new Scanner(System.in);
    private boolean _continue;

    public ToDoApp(ITaskController controller) {
        this.controller = controller;
    }

    public void start(){
        _continue = true;
        while(_continue){
            showMenu();
            String option = new Scanner(System.in).next();
            try {
                executeOption(option);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void executeOption(String option) throws ExecutionException, InterruptedException {
        switch (option) {
            case "1" -> showTasks(controller.findAll().get());
            case "2" -> controller.create(createTask());
            case "3" -> controller.update(updateTask());
            case "4" -> controller.delete(deleteTask());
            case "5" -> finish();
        }
    }

    private CreateTaskDto createTask() {
        CreateTaskDto task = new CreateTaskDto();
        System.out.println("----------------------");
        System.out.println("| ==== ToDo APP ==== |");
        System.out.println("----------------------");
        System.out.println("| Create Task:        |");
        System.out.println("----------------------");
        System.out.println("| Description:       |");
        System.out.println("----------------------");
        task.setDescription(scanner.nextLine());
        System.out.println("----------------------");
        System.out.println("| Is completed? (Y/N)|");
        System.out.println("----------------------");
        task.setIsCompleted(scanner.nextLine().equalsIgnoreCase("y"));
        return task;
    }

    private UpdateTaskDto updateTask() {
        UpdateTaskDto task = new UpdateTaskDto();
        System.out.println("----------------------");
        System.out.println("| ==== ToDo APP ==== |");
        System.out.println("----------------------");
        System.out.println("| Update Task:       |");
        System.out.println("----------------------");
        System.out.println("| Id:                |");
        System.out.println("----------------------");
        task.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("----------------------");
        System.out.println("| Description:       |");
        System.out.println("----------------------");
        task.setDescription(scanner.nextLine());
        System.out.println("----------------------");
        System.out.println("| Is It completed? (Y/N)|");
        System.out.println("----------------------");
        task.setIsCompleted(scanner.nextLine().equalsIgnoreCase("y"));
        return task;
    }

    private DeleteTaskDto deleteTask() {
        DeleteTaskDto task = new DeleteTaskDto();
        System.out.println("----------------------");
        System.out.println("| ==== ToDo APP ==== |");
        System.out.println("----------------------");
        System.out.println("| Delete Task:       |");
        System.out.println("----------------------");
        System.out.println("| Id:                |");
        System.out.println("----------------------");
        task.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("----------------------");
        System.out.println("| Are you sure? (Y/N)|");
        System.out.println("----------------------");
        String option = scanner.nextLine();
        if (!option.equalsIgnoreCase("y")){
            task.setId(-1);
        }
        return task;
    }

    private void showTasks(List<TaskDto> tasks) {
        tasks.forEach(task -> System.out.println(task.toString()));
    }

    private void showMenu(){
        System.out.println("----------------------");
        System.out.println("| ==== ToDo APP ==== |");
        System.out.println("----------------------");
        System.out.println("| Choose:            |");
        System.out.println("----------------------");
        System.out.println("| 1. Find All Task   |");
        System.out.println("| 2. Create Task     |");
        System.out.println("| 3. Update Task     |");
        System.out.println("| 4. Delete Task     |");
        System.out.println("| 5. Exit            |");
        System.out.println("----------------------");
    }

    private void finish(){
        _continue = false;
        System.out.println("Exiting...");
    }
}
