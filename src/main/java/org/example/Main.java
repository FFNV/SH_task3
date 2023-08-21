package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HorseService horseService = context.getBean("horseService", HorseService.class);
        RaceService raceService = context.getBean("raceService", RaceService.class);
        EmulationService emulationService = context.getBean("emulationService", EmulationService.class);

        // Вывод информации о предстоящей гонке
        System.out.println("Предстоящая гонка:");
        horseService.getHorse().forEach(h -> System.out.println(h.getName() + " - " + h.getRider().getName() + " - " + h.getBreed().getName()));

        // Выбор лошади
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите свою лошадь по имени, породе или имени всадника:");
        String choice = scanner.nextLine();
        Horse chosenHorse = horseService.getHorse().stream()
                .filter(h -> h.getName().equals(choice) || h.getBreed().getName().equals(choice) || h.getRider().getName().equals(choice))
                .findFirst()
                .orElse(null);

        if (chosenHorse == null) {
            System.out.println("Лошадь не найдена. Завершение программы.");
            return;
        }

        System.out.println("Вы выбрали лошадь: " + chosenHorse.getName());

        // Эмуляция гонки
        Race race = raceService.getRace(horseService.getHorse());
        emulationService.emulate(race);

        // Получение победителя
        Horse winner = race.getHorses().stream().filter(h -> h.getPosition() == EmulationService.RACE_DISTANCE).findFirst().orElse(null);

        // Сравнение победителя с выбранной лошадью
        if (winner != null) {
            if (winner.equals(chosenHorse)) {
                System.out.println("Поздравляем! Ваша лошадь выиграла!");
            } else {
                System.out.println("К сожалению, ваша лошадь не выиграла. Победила лошадь " + winner.getName());
            }
        } else {
            System.out.println("Гонка не завершилась победой ни одной лошади.");
        }

        scanner.close();
    }
}

