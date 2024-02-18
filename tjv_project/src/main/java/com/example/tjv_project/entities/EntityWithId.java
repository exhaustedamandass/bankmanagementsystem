package com.example.tjv_project.entities;

public interface EntityWithId<ID> {
    ID getId();

    void setId(ID id);
}
