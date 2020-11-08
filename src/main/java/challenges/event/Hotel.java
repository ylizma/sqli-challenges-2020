package challenges.event;

import java.util.List;

public class Hotel {
    private int standardRooms;
    private int suites;
    private int apparts;
    private int currentStandardRoomsTicket = 0;
    private int maxStandardRoomsTicket = 100;
    private int currentSuitsRoomsTicket = 101;
    private int maxSuitsRoomsTicket = 200;
    private int currentAppartmentTicket = 201;
    private int maxAppartmentTicket = 300;

    private List<Participant> participants;

    public Hotel(int standardRooms, int suites, int apparts) {
        this.standardRooms = standardRooms;
        this.suites = suites;
        this.apparts = apparts;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    void setRooms(String name) {
        for (Participant participant : participants
        ) {
            if (participant.getName().equals(name)) {
                if (participant instanceof Tringa) {
                    if (currentStandardRoomsTicket > maxStandardRoomsTicket) {
                        participant.setRoom("Apart room N°" +
                                currentAppartmentTicket+1);
                        currentAppartmentTicket++;
                    } else {
                        participant.setRoom("Standard room N°" + currentStandardRoomsTicket+1);
                        currentStandardRoomsTicket++;
                    }

                }
            }
        }
    }

    public String checkAvailibility() {
        StringBuilder check = new StringBuilder();
        check.append("Standard rooms:")
                .append(maxStandardRoomsTicket-currentStandardRoomsTicket);
        return check.toString();
    }
}
