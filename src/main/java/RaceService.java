import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class RaceService {

    private static final int NUMBER_OF_HORSES_IN_RACE = 5; // Можно выбрать другое число лошадей в гонке

    public Race getRace(List<Horse> horses) {
        Collections.shuffle(horses);
        List<Horse> selectedHorses = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_HORSES_IN_RACE && i < horses.size(); i++) {
            selectedHorses.add(horses.get(i));
        }

        Race race = new Race();
        race.setHorses(selectedHorses);
        return race;
    }
}
