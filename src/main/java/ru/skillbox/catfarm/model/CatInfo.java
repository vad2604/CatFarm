package ru.skillbox.catfarm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class CatInfo {

    private CatStatus catStatus;
    private double foodEaten;
}
