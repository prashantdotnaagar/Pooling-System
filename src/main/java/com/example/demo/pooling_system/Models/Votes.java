package com.example.demo.pooling_system.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Votes {
    @Id
    private int vote_id;

    @ManyToOne
    @JoinColumn(name = "poll_id",nullable = false)
    @JoinColumn(name = "option_id" ,nullable = false)
    private Polls pole;
    private Options option;


    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public Polls getPole() {
        return pole;
    }

    public void setPole(Polls pole) {
        this.pole = pole;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "vote_id=" + vote_id +
                ", pole=" + pole +
                ", option=" + option +
                '}';
    }

}
