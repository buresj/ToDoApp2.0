package com.todo.app.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier("file")
public class IOManager implements StoreService {

    Path path;
    String filename;

    public IOManager() {
        this.path = Paths.get("assets/" + "tasks.txt");
    }

    @Override
    public List<String> load() {
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(this.path);
        } catch (IOException e) {
            System.out.println("Cannot read file");
        }
        return content;
    }


    @Override
    public void changeStatus(int index) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void save(List<String> list) {
        List<String> content = load();
        content.add(list.get(1));
        try {
            Files.write(path, content);
        } catch (IOException e) {
            System.out.println("Cannot write file.");
        }
    }
}
