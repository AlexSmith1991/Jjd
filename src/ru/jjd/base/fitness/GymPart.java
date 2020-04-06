package ru.jjd.base.fitness;

import java.time.LocalTime;
import java.util.Arrays;

public class GymPart {
    private String name;
    private GymMembership[] gymMemberships;
    private int gymMembershipsCount;
    private boolean singleMembershipAvailable;
    private boolean dailyMembershipAvailable;
    private boolean fullMembershipAvailable;

    public GymPart(String name, boolean singleMembershipAvailable, boolean dailyMembershipAvailable, boolean fullMembershipAvailable) {
        setName(name);
        this.singleMembershipAvailable = singleMembershipAvailable;
        this.dailyMembershipAvailable = dailyMembershipAvailable;
        this.fullMembershipAvailable = fullMembershipAvailable;
        gymMemberships = new GymMembership[20];
        gymMembershipsCount = 0;
    }

    public GymPart(String name) {
        setName(name);
        this.singleMembershipAvailable = true;
        this.dailyMembershipAvailable = true;
        this.fullMembershipAvailable = true;
        gymMemberships = new GymMembership[20];
        gymMembershipsCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void newDay(){
        gymMemberships = new GymMembership[20];
        gymMembershipsCount = 0;
    }

    public boolean appendNew(GymMembership gymMembership){
        boolean result = false;
        if ((!singleMembershipAvailable && gymMembership instanceof SingleGymMembership) ||
                (!dailyMembershipAvailable && gymMembership instanceof DailyGymMembership) ||
                (!fullMembershipAvailable && gymMembership instanceof FullGymMembership)){
            System.out.println("Данный вид занятий недоступен для выбранного абонемента");
            return false;
        }
        if (gymMembership == null ||
                gymMembership.getTimeStart().isAfter(LocalTime.now()) ||
                gymMembership.getTimeEnd().isBefore(LocalTime.now())){
            System.out.println("Невозможно посещение в текущее время");
        }else if (gymMembershipsCount < 20){
            gymMemberships[gymMembershipsCount++] = gymMembership;
            result = true;
        } else {
            for (int i = 0; i < gymMembershipsCount; i++) {
                if (gymMemberships[i].getTimeStart().isAfter(LocalTime.now()) ||
                        gymMemberships[i].getTimeEnd().isBefore(LocalTime.now())){
                    gymMemberships[i] = gymMembership;
                    result = true;
                }
            }
            if (!result) {
                System.out.println("Невозможно добавить, достигнуто максимальное количество посетителей");
            }
        }
        return result;
    }

    private void checkGuests(){
        if (gymMembershipsCount < 1){
            return;
        }
        GymMembership[] tempGymMemberships = new GymMembership[20];
        int tempGymMembershipsCount = 0;
        for (int i = 0; i < gymMembershipsCount; i++) {
            if (!gymMemberships[i].getTimeEnd().isBefore(LocalTime.now()) &&
                    !gymMemberships[i].getTimeStart().isAfter(LocalTime.now())){
                tempGymMemberships[tempGymMembershipsCount++] = gymMemberships[i];
            }
        }
        gymMemberships = tempGymMemberships;
        gymMembershipsCount = tempGymMembershipsCount;
    }

    public void displayGuests(){
        if (gymMembershipsCount < 1){
            return;
        }
        String[] guests = new String[gymMembershipsCount];
        checkGuests();
        for (int i = 0; i < gymMembershipsCount; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(gymMemberships[i].getOwner().getSurname());
            for (int j = gymMemberships[i].getOwner().getSurname().length(); j < 100; j++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(gymMemberships[i].getOwner().getName());
        }
        Arrays.sort(guests);
        System.out.println(getName());
        for (int i = 0; i < gymMembershipsCount; i++) {
            System.out.println(guests[i].trim().replaceAll("\\s", " "));
        }
        System.out.println();
    }
}
