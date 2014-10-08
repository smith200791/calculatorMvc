package ru.atc.Calcula;

import ru.atc.Calcula.database.HibernateUtils;


public class Main {

    public static void main(String[] args) {

        Calculate calculate = new Calculate();
        calculate.ssumm( Math.random()*10, Math.random()*10);
        calculate.viewLastResult("console");

        calculate.executeOperation("multiply",  Math.random()*10, Math.random()*10);
        calculate.viewLastResult("superConsole");

        calculate.executeOperation("multiply", Math.random()*10, Math.random()*10);
        calculate.viewLastResult("database");

        calculate.executeOperation("division", Math.random()*10, Math.random()*10);
        calculate.viewLastResult("database");
        
        HibernateUtils.shutdown();
    }

}
