package ru.jjd.base.lesson16.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})//определение, к чему аннотация может применяться
@Retention(RetentionPolicy.RUNTIME)//определение, когда можно ее использовать
public @interface Required {//правила нейминга у аннотация такие же как у классов
}
