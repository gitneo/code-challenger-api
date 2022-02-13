package com.cron.codechallenger.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PLAYER")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PLA_ID")
    private long id;
    @Column(name = "PLA_NAME")
    private String name;
    @Column(name="PLA_NICKNAME")
    private String nickname;
    @Column(name="PLA_PASSWORD")
    private String password;


    public Player() {
    }

    public Player(long id, String name, String nickname, String password, List<PlayerSubmission> playerSubmissionList) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
