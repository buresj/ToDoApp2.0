package com.todo.app.models.todo;
import com.todo.app.models.text.Book;
import com.todo.app.models.text.Page;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class TaskBinder extends Book {

    private List<Page> tasks;

    public TaskBinder() {
    }

    @Override
    public List<Page> read(List<String> list) {
        return this.tasks = list.stream()
                .map(line -> {String[] parsed = line.split(",");
                    return new Task (
                            parseInt(parsed[0]),
                            parsed[1],
                            parsed[2],
                            parsed[3],
                            parsed[4].equals("1"));
                })
                .collect(Collectors.toList());
    }

    @Override
    public void write(Page page) {
        super.write(page);
    }

    public void remove(int id) {
    }

    public void check(int id) {
    }

    public void paginator (){
    }
}
