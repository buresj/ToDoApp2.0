package com.todo.app.models.todo;
import com.todo.app.models.text.Page;

public class Task extends Page {

    public Task() {
        super();
    }

    public Task(int pageNumber, String content, String date, String daysToFinish, boolean finished) {
        super(pageNumber, content, date, daysToFinish, finished);
    }

    public Task(String content, String daysToFinish) {
        super(content, daysToFinish);
    }
}
