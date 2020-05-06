package ru.jjd.base.lesson17.ditask;

import ru.jjd.base.lesson17.ditask.container.DIContainer;
import ru.jjd.base.lesson17.ditask.tstclasses.Cat;
import ru.jjd.base.lesson17.ditask.tstclasses.Mouse;
import ru.jjd.base.lesson17.ditask.tstclasses.Owner;
import ru.jjd.base.lesson17.ditask.tstclasses.config.AnimalsConfig;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Class> classes = new HashSet<>();
        classes.add(Cat.class);
        classes.add(Mouse.class);
        classes.add(Owner.class);
        classes.add(AnimalsConfig.class);

        DIContainer container = new DIContainer(classes);

        ((Cat) container.getObject("Cat")).catchMouse(((Mouse) container.getObject("Mouse")));
    }
}
