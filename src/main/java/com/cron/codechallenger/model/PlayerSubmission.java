package com.cron.codechallenger.model;

import javax.persistence.*;

@Entity
@Table(name="SUBMISSION")
public class PlayerSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUB_ID")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUB_TASK_ID")
    private Task task;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name ="SUB_PLAYER_ID")
    private Player player;

    @Column(name ="SUB_SOLUTION")
    private String solution;

    @Column(name="SUB_STATUS")
    private boolean status;

    public PlayerSubmission() {
    }

    public PlayerSubmission(long id, String solution, boolean status) {
        this.id = id;
        this.solution = solution;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
