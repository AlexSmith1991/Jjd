package ru.jjd.base.school;

public class School {
    private Teacher[] teachers = new Teacher[50];
    private Student[] students = new Student[1000];
    private int teachersCount;
    private int studentsCount;
    private HeadMaster headMaster;
    private String name;

    public HeadMaster getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(HeadMaster headMaster) {
        if (headMaster == null){
            System.out.println("Школа не может функционировать без директора");
        } else {
            this.headMaster = headMaster;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 1) {
            this.name = name;
        }
    }

    public School(HeadMaster headMaster, String name){
        if (headMaster != null){
            setHeadMaster(headMaster);
            setName(name);
            teachersCount = 0;
            studentsCount = 0;
        }
    }

    public void AddTeacher(Teacher teacher){
        if (teacher != null){
            if (teachersCount < teachers.length) {
                teachers[teachersCount++] = teacher;
            } else {
                System.out.println("Максимальное количество учителей достигнуто");
            }
        }
    }

    public void AddStudent(Student student){
        if (student != null){
            if (studentsCount < students.length) {
                students[studentsCount++] = student;
            } else {
                System.out.println("Максимальное количество учеников достигнуто");
            }
        }
    }

    public void DayInSchool(){
        if (headMaster == null){
            System.out.println("В школе отсутствует директор");
            return;
        }
        headMaster.AnnounceLessonsStart();
        for (int i = 0; i < teachersCount; i++) {
            for (int j = 0; j < studentsCount; j++) {
                if (teachers[i].getTeachingSubject().equals(students[j].getLearningSubject())){
                    teachers[i].Teach(students[j]);
                }
            }
        }
        headMaster.AnnounceLessonsEnd();
    }


}
