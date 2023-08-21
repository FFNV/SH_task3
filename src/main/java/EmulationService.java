import java.util.List;
import java.util.Random;

public class EmulationService {
    protected static final int RACE_DISTANCE = 100;

    public void emulate(Race race) {
        List<Horse> horses = race.getHorses();

        while (!isRaceOver(horses)) {
            emulateSecond(horses);
            printPositions(horses);
            sleepOneSecond();
        }

        announceWinner(horses);
    }

    private boolean isRaceOver(List<Horse> horses) {
        return horses.stream().anyMatch(h -> h.getPosition() >= RACE_DISTANCE);
    }

    private void emulateSecond(List<Horse> horses) {
        Random random = new Random();
        for (Horse horse : horses) {
            int progress = random.nextInt(5); // Лошадь продвигается от 0 до 4 единиц за секунду
            horse.setPosition(Math.min(horse.getPosition() + progress, RACE_DISTANCE));
        }
    }

    private void printPositions(List<Horse> horses) {
        System.out.println("Текущие позиции:");
        for (Horse horse : horses) {
            System.out.println(horse.getName() + ": " + horse.getPosition() + "/" + RACE_DISTANCE);
        }
    }

    private void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected void announceWinner(List<Horse> horses) {
        Horse winner = horses.stream().filter(h -> h.getPosition() == RACE_DISTANCE).findFirst().orElse(null);
        if (winner != null) {
            System.out.println("Победитель гонки: " + winner.getName() + "!");
        }
    }
}

