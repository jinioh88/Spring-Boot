package com.exjson.exjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExjsonApplication {

    public static void main(String[] args) {
        User srcUser = new User(30,"oh","1234");
        ObjectMapper om = new ObjectMapper();

        try{
            System.out.println("convert to json");
            String srcJson = om.writeValueAsString(srcUser);
            System.out.printf("%s\n\n",srcJson);

            User confUser = om.readValue(srcJson,User.class);
            System.out.println(confUser.getName()+confUser.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
