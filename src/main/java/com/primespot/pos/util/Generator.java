package com.primespot.pos.util;

import org.springframework.stereotype.Service;

import java.util.Random;

//To generator ID
@Service
public class Generator {

    private final Random RANDOM = new Random();

    public Long generateDigits(int length){
        return generateRandomDigits(length);
    }

    public Long generateRandomDigits(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i=0 ; i<length ; i++){
            String NUMERICAL = "0123456789";
            returnValue.append(NUMERICAL.charAt(RANDOM.nextInt(NUMERICAL.length())));
        }
        return Long.parseLong(returnValue.toString());
    }

    public GeneratedIdentificationDto generatorID(){
        StringBuilder builder = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int index = (int) (ALPHABET.length()*Math.random());
            builder.append(ALPHABET.charAt(index));
        }
        return new GeneratedIdentificationDto(generateDigits(8),builder.toString());
    }
}
