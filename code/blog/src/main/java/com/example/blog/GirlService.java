package com.example.blog;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public String randomGirlName(int length) {
        return RandomStringUtils.randomAlphanumeric(length).toLowerCase();
    }

    public Girl getRandomGirl() {
        String name = randomGirlName(10);

        return girlRepository.getGirlByName(name);
    }


}
