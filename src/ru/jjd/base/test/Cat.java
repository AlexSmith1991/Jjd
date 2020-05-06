package ru.jjd.base.test;

import ru.jjd.base.lesson17.ditask.container.marks.Required;
import ru.jjd.base.lesson17.ditask.container.marks.RequiredClass;
import ru.jjd.base.lesson17.ditask.tstclasses.config.AnimalsConfig;

import java.util.ArrayList;


public class Cat {

    private Owner owner;

    private ArrayList<Mouse> mice = new ArrayList<>(20);

    public void catchMouse(Mouse mouse) {
        mice.add(mouse);
        System.out.println(" поймал " + mouse.getName());

    }



}
