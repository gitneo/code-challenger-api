package com.cron.codechallenger.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TSK_ID")
    private long id;
    @Column(name = "TSK_TASK_TITLE")
    private String title;
    @Column(name="TSK_TASK_DESC")
    private String description;

    public Task() {
    }

    public Task(long id, String title, String description, List<PlayerSubmission> submissionList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.submissionList = submissionList;
    }

    @OneToMany(mappedBy = "task")
    private List<PlayerSubmission> submissionList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addSubmission(PlayerSubmission submission){
        this.submissionList.add(submission);
        submission.setTask(this);
    }
}
