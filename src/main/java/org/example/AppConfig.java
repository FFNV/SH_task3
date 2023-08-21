package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    // Определение всадников
    @Bean
    public Rider rider() {
        return new Rider("Доминик Торетто");
    }
    @Bean
    public Rider rider2() {
        return new Rider("Люк Хоббс");
    }
    @Bean
    public Rider rider3() {
        return new Rider("Брайн О'Коннер");
    }
    @Bean
    public Rider rider4() {
        return new Rider("Хан Лю");
    }

    // Определение пород
    @Bean
    public Breed breed() {
        return new Breed("Арабская");
    }
    @Bean
    public Breed breed2() {
        return new Breed("Американская");
    }
    @Bean
    public Breed breed3() {
        return new Breed("Фризская");
    }
    @Bean
    public Breed breed4() {
        return new Breed("Донская");
    }

    // Определение лошадей
    @Bean
    public Horse horse(Rider rider, Breed breed) {
        Horse horse = new Horse();
        horse.setName("Машка");
        horse.setRider(rider);
        horse.setBreed(breed);
        return horse;
    }
    @Bean
    public Horse horse2(Rider rider2, Breed breed2) {
        Horse horse = new Horse();
        horse.setName("Дашка");
        horse.setRider(rider2);
        horse.setBreed(breed2);
        return horse;
    }
    @Bean
    public Horse horse3(Rider rider3, Breed breed3) {
        Horse horse = new Horse();
        horse.setName("Сашка");
        horse.setRider(rider3);
        horse.setBreed(breed3);
        return horse;
    }
    @Bean
    public Horse horse4(Rider rider4, Breed breed4) {
        Horse horse = new Horse();
        horse.setName("Пашка");
        horse.setRider(rider4);
        horse.setBreed(breed4);
        return horse;
    }
    @Bean
    public List<Horse> horses(Horse horse, Horse horse2, Horse horse3, Horse horse4) {
        return Arrays.asList(horse, horse2, horse3, horse4);
    }

}
