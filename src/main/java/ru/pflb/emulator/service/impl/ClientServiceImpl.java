package ru.pflb.emulator.service.impl;

import org.springframework.stereotype.Service;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {


    public ClientDto getClient(long id){
        ClientDto client = new ClientDto();
        client.setId(id);
        return client;
    }

    @Override
    public ClientDto getUserById(long id) {
        ClientDto client = ClientDto.builder().id(id)
                        .firstName(randomString())
                        .lastName(randomString())
                        .cardNumber(randomCardNumber())
                        .isActive(randomBoolean())
                        .build();
        return client;
    }

    private int randomNumber(int min, int max){
        int random = (int) ((Math.random() *  ((max - min) + 1)) + min);
        return random;
    }
    
    private String randomString(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            stringBuilder.append((char) ('a' + random.nextInt(26)));
        }
        return stringBuilder.toString();
    }

    private String randomCardNumber(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(randomNumber(0, 9));
        }
        return stringBuilder.toString();
    }

    private boolean randomBoolean(){
        if (randomNumber(0, 9) % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
