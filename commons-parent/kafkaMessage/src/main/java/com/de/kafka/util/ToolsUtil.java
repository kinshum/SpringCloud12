package com.de.kafka.util;

import java.util.Random;
import java.util.UUID;

public class ToolsUtil {

    public synchronized static String getNextCode() {
        return UUID.randomUUID().toString();
    }


    public synchronized static Float getFee() {
        Random rand = new Random();
        float fee = rand.nextFloat();

        return fee;
    }


}
