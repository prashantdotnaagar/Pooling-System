package com.example.demo.pooling_system.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Vote_table")
public class Votes {
    @Id
    private int vote_id;

    @ManyToOne
    @JoinColumn(name = "poll_id",nullable = false)
    private Polls polls;

    @ManyToOne
    @JoinColumn(name = "option_id" ,nullable = false)
    private Options option;


    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public Polls getPolls() {
        return polls;
    }

    public void setPolls(Polls polls) {
        this.polls = polls;
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
                ", pole=" + polls +
                ", option=" + option +
                '}';
    }

}
