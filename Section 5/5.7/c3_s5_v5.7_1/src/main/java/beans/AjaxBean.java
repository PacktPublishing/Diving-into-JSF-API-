package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

    private static final Map<Integer, String> myMap = new HashMap<>();
    private String piece = "";

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    static {
        myMap.put(1, "Nadal Rafael");
        myMap.put(2, "Federer Roger");
        myMap.put(3, "Ferer David");
        myMap.put(4, "Murray Andy");
        myMap.put(5, "Djokovic Novak");
        myMap.put(6, "Berdych Tomas");
        myMap.put(7, "Haas Tommy");
        myMap.put(8, "Isner John");
        myMap.put(9, "Fognini Fabio");
        myMap.put(10, "Robredo Tommy");
    }

    public void populatePlayerBox() {
        for (String player : myMap.values()) {
            if (player.toLowerCase().startsWith(piece.toLowerCase())) {
                piece = player;
            }
        }
    }
}
