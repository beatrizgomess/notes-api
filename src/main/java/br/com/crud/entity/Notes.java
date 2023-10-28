package br.com.crud.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;


@Entity
@Table(name = "TodoList")
public class Notes extends PanacheEntity {


    private String title;
    private String description;
    @NotNull
    private String createdAt;
    @NotNull
    @Column(nullable = true)
    private Boolean done = false;


    public Notes() {

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

    public String getcreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
