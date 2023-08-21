package org.example;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Horse {

        private String name;
        private Rider rider;
        private Breed breed;
        private int position = 0;
        // Геттеры и сеттеры


        public void setName(String name) {
                this.name = name;
        }

        public void setRider(Rider rider) {
                this.rider = rider;
        }

        public void setBreed(Breed breed) {
                this.breed = breed;
        }

        public String getName() {
                return name;
        }

        public Rider getRider() {
                return rider;
        }


        public Breed getBreed() {
                return breed;
        }

        public int getPosition() {
                return position;
        }

        public void setPosition(int position) {
                this.position = position;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Horse horse = (Horse) o;
                return Objects.equals(name, horse.name);
        }

        @Override
        public int hashCode() {
                return Objects.hash(name);
        }


}
