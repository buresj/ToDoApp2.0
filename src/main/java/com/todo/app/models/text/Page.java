package com.todo.app.models.text;

import java.util.ArrayList;
import java.util.List;

public abstract class Page{

    private int pageNumber;
    private String content;
    private String date;
    private String daysToFinish;
    private boolean finished;

    public Page() {
    }

    public Page(int pageNumber, String content, String date, String daysToFinish, boolean finished) {
        this.pageNumber = pageNumber;
        this.content = content;
        this.date = date;
        this.daysToFinish = daysToFinish;
        this.finished = finished;
    }

    public Page(String content, String daysToFinish) {
        this.content = content;
        this.daysToFinish = daysToFinish;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getDaysToFinish() {
        return daysToFinish;
    }

    public boolean toBeFinished() {
        return getDaysToFinish().equals(" 3") || getDaysToFinish().equals(" 2") || getDaysToFinish().equals(" 1");
    }


    public void setDaysToFinish(String daysToFinish) {
        this.daysToFinish = daysToFinish;
    }

    public List<String> read() {
        List<String> list = new ArrayList<>();
        list.add("null");
        list.add(this.getContent());
        list.add(this.getDaysToFinish());
        list.add(this.isFinished() ? "1" : "0");
        return list;
    }
}
