package ru.jjd.base.school;

public class Teacher extends Human implements Teach {

    private String teachingSubject;

    protected Teacher(String name, int age, String teachingSubject) {
        super(name, age);
        setTeachingSubject(teachingSubject);
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        if (teachingSubject != null && teachingSubject.length() > 2){
            this.teachingSubject = teachingSubject;
        }
    }

    @Override
    public void setAge(int age) {
        if (age > 17){
            super.setAge(age);
        }
    }

    @Override
    public void Teach(Learn student) {
        student.learn();
    }
}
