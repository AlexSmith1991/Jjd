package ru.jjd.base.fitness;

import java.time.LocalTime;

public class GymPart {
    private GymMembership[] gymMemberships;
    private int gymMembershipsCount;
    private boolean singleMembershipAvailable;
    private boolean dailyMembershipAvailable;
    private boolean fullMembershipAvailable;

    public GymPart(boolean singleMembershipAvailable, boolean dailyMembershipAvailable, boolean fullMembershipAvailable) {
        this.singleMembershipAvailable = singleMembershipAvailable;
        this.dailyMembershipAvailable = dailyMembershipAvailable;
        this.fullMembershipAvailable = fullMembershipAvailable;
        gymMemberships = new GymMembership[20];
        gymMembershipsCount = 0;
    }

    public GymPart() {
        this.singleMembershipAvailable = true;
        this.dailyMembershipAvailable = true;
        this.fullMembershipAvailable = true;
        gymMemberships = new GymMembership[20];
        gymMembershipsCount = 0;
    }

    public void NewDay(){
        gymMemberships = new GymMembership[20];
        gymMembershipsCount = 0;
    }

    public void AppendNew(GymMembership gymMembership){
        if (gymMembership == null ||
                gymMembership.getTimeStart().isAfter(LocalTime.now()) ||
                gymMembership.getTimeEnd().isBefore(LocalTime.now())){
            System.out.println("Невозможно посещение в текущее время");
            return;
        }
        if (gymMembershipsCount < 20){
            gymMemberships[gymMembershipsCount++] = gymMembership;
        } else {
            for (int i = 0; i < gymMembershipsCount; i++) {
                if (gymMemberships[i].getTimeStart().isAfter(LocalTime.now()) ||
                        gymMemberships[i].getTimeEnd().isBefore(LocalTime.now())){
                    gymMemberships[i] = gymMembership;
                    return;
                }
            }
            System.out.println("Невозможно добавить, достигнуто максимальное количество посетителей");
        }
    }
}
