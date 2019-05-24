package com.todo.app.controllers;

import com.todo.app.models.todo.Task;
import com.todo.app.models.todo.TaskBinder;
import com.todo.app.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {

    private StoreService providerFileIO;
    private StoreService providerDatabase;
    private TaskBinder taskBinder;

    @Autowired
    public WebController(@Qualifier("file") StoreService providerFileIO,
                         @Qualifier("database") StoreService providerDatabase) {
        this.providerFileIO = providerFileIO;
        this.providerDatabase = providerDatabase;
        this.taskBinder = new TaskBinder();
    }

    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("book", taskBinder.read(providerDatabase.load()));
        model.addAttribute("newtask", new Task());
        return "index";
    }

    @GetMapping("/add")
    public String addAccount(Model model) {
        model.addAttribute("newtask", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        providerDatabase.save(task.read());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String displayAll(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("newtask", new Task());
        providerDatabase.delete(id);
        return "redirect:/";
    }
}
