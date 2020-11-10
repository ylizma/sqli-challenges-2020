package challenges.event;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private Hotel hotel;
    private List<Participant> participants;
    private HotelFactory hotelFactory;

    public Event(Hotel hotel) {
        this.hotel = hotel;
        this.participants = new ArrayList<>();
        this.hotelFactory = new HotelFactory();
        hotel.setParticipants(this.participants);
    }

    public boolean register(String role, String name) {
        if (findParticipantByName(name)) {
            return false;
        } else {
            Participant participant = HotelFactory.getParticipant(role, name);
            if (participant != null) {
                participant.setRole(role);
            }
            hotel.setRooms(name);
            this.participants.add(participant);
            return true;
        }
    }

    public boolean findParticipantByName(String name) {
        for (Participant participant : participants
        ) {
            if (participant.getName().equals(name))
                return true;
        }
        return false;
    }
}
