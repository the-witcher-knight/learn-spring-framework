package com.example.blog;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bikini implements Outfit {

    @Override
    public void wear() {
        System.out.println("Mặc bikini");
    }

}
