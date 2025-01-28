package com.example.demo.pooling_system.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Option_table")
public class Options {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int option_id;
    private String option_title;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="poll_id", nullable = false)
    private Polls poll;

    public Polls getPoll() {
        return poll;
    }

    public void setPoll(Polls poll) {
        this.poll = poll;
    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }


    public String getOption_title() {
        return option_title;
    }

    public void setOption_title(String option_title) {
        this.option_title = option_title;
    }

    @Override
    public String toString() {
        return "Options{" +
                "option_id=" + option_id +
                ", option_title='" + option_title + '\'' +
                ", poll=" + poll +
                '}';
    }
}
