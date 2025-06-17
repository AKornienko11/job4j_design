package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseSlf4j {
    private final static Logger LOG = LoggerFactory.getLogger(UseSlf4j.class.getName());

    public static void main(String[] args) {
        String name = "Peter Arsentev";
        byte project = 1;
        short chanel = 2;
        int age = 33;
        float weight = 80.6F;
        double height = 1.86D;
        long subscribers = 29344L;
        char initial = 'P';
        boolean vol = true;

        LOG.debug("User info name : {}, age : {} ", name, age);
        LOG.debug("User info project : {}, chanel : {} ", project, chanel);
        LOG.info("User info weight : {}, height : {} ", weight, height);
        LOG.warn("User info subscribers : {}, initial : {} ", subscribers, initial);
        LOG.error("User info vol : {} ", vol);
    }
}
