package ru.jjd.base.school;

public class main {
    public static void main(String[] args) {
        String[] subjects = {"Математика", "Физика", "Химия", "Литература", "Русский язык", "География"};
        HeadMaster headMaster = new HeadMaster("Имя Директора", 46);
        School newSchool = new School(headMaster, "Школа №1");
        newSchool.AddTeacher(new Teacher("Учитель 1", 21, subjects[(int) (Math.random() * 6)]));
        newSchool.AddTeacher(new Teacher("Учитель 2", 52, subjects[(int) (Math.random() * 6)]));
        newSchool.AddTeacher(new Teacher("Учитель 3", 34, subjects[(int) (Math.random() * 6)]));
        newSchool.AddTeacher(new Teacher("Учитель 4", 65, subjects[(int) (Math.random() * 6)]));
        newSchool.AddTeacher(new Teacher("Учитель 5", 32, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 1", 12, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 2", 11, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 3", 19, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 4", 16, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 5", 17, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 6", 14, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 7", 12, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 8", 11, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 9", 10, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 10", 8, subjects[(int) (Math.random() * 6)]));
        newSchool.AddStudent(new Student("Ученик 11", 7, subjects[(int) (Math.random() * 6)]));
        newSchool.DayInSchool();
    }
    //когда будет вызываться метод школьный день - учителя учат учеников, если у них совпадают предметы,
    //школа не может быть без директора
    //если несколько учителей по одному предмету - можно между ними не разбивать
    //уровень знаний - инт
    //метод учиться - должен быть реализован как повышение их уровня знаний, просто повышение
    //у учителя метод учить, тип данных выбрать самостоятельно, в него передается ученик, внутри него вызывается метод
    //повышения знаний
    //возможно расширение программы, поэтому методы учиться и учить обязательно выносить в отдельный интерфейс
    //хорошо подумать над типом данных учить(интерфейс)
    //задачу можно усложнять по желанию
    //школьный день - объявление начала занятий, потом перебор массивов для учебы, потом объявление окончания занятий
    //предмет можно вынести в отдельный класс
    //один директор - приватный конструктор, статическая переменна, если переменная пустая - создавать директора
}
