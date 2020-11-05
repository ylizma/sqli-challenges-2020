package challenges.event;

public class HotelFactory {

    public static Participant getParticipant(String role, String name) {
        switch(role){
            case "TRINGA":
                return new Tringa(name,role);
        }
        return null;
    }
}
