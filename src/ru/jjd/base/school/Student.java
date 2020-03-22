package ru.jjd.base.school;

public class Student extends Human implements Learn {

    private String learningSubject;
    private int knowledgeLevel;

    protected Student(String name, int age, String learningSubject) {
        super(name, age);
        setLearningSubject(learningSubject);
        setKnowledgeLevel((int) (Math.random() * 10));
    }

    public String getLearningSubject() {
        return learningSubject;
    }

    public void setLearningSubject(String learningSubject) {
        if (learningSubject != null && learningSubject.length() > 2){
            this.learningSubject = learningSubject;
        }
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(int knowledgeLevel) {
        if (knowledgeLevel >= 0){
            this.knowledgeLevel = knowledgeLevel;
        }
    }

    @Override
    public void learn() {
        this.knowledgeLevel++;
    }
}
