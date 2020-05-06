package ru.jjd.base.lesson17.ditask.tstclasses;


import ru.jjd.base.lesson17.ditask.container.marks.Required;
import ru.jjd.base.lesson17.ditask.container.marks.RequiredClass;
import ru.jjd.base.lesson17.ditask.tstclasses.config.AnimalsConfig;

@RequiredClass
public class Owner {
    @Required
    private AnimalsConfig ownerConfig;

    public String getName(){
        return ownerConfig.getOwnerName();
    }
}
