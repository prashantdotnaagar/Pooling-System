package com.example.demo.pooling_system.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Poll_table")
public class Polls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int poll_id;

    @Column(name = "title")
    private  String poll_title;

    @Column(name = "description")
    private  String poll_description;
    @JsonManagedReference
    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Options> options;
    public int getPoll_id() {
        return poll_id;
    }
    public void setPoll_id(int poll_id) {
        this.poll_id = poll_id;
    }
    public String getPoll_title() {
        return poll_title;
    }
    public void setPoll_title(String poll_title) {
        this.poll_title = poll_title;
    }
    public String getPoll_description() {
        return poll_description;
    }
    public void setPoll_description(String poll_description) {
        this.poll_description = poll_description;
    }
    public List<Options> getOptions() {
        return options;
    }
    public void setOptions(List<Options> options) {
        this.options = options;
    }
    @Override
    public String toString() {
        return "Polls{" +
                "poll_id=" + poll_id +
                ", poll_title='" + poll_title + '\'' +
                ", poll_description='" + poll_description + '\'' +
                ", options=" + options +
                '}';
    }
}
