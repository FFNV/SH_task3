package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class HorseService {
    private List<Horse> horses;

    public List<Horse> getHorse() {
        return horses;
    }
//    public void setHorses(List<Horse> horses) {
//        this.horses = horses;
//    }
    public HorseService(List<Horse> horses) {
        this.horses = horses;
    }
}
