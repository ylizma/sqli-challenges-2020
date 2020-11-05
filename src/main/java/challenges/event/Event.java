package challenges.event;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private Hotel hotel;
    private List<Participant> participants;
    private HotelFactory hotelFactory ;

    public Event(Hotel hotel) {
        this.hotel = hotel;
        this.participants = new ArrayList<>();
        this.hotelFactory = new HotelFactory();
    }

    public boolean register(String role, String name) {
        Participant participant = HotelFactory.getParticipant(role,name);
        return true;
    }
}
