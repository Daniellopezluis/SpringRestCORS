package com.daniel.restfulcors;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

//------ CONTROLADORES ------//
@Controller
public class GreetingController {

    private static final String template = " : %s";

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(@RequestParam(required=false, defaultValue="La eterna brevedad del ser") String name) {
        System.out.println("==== saludando ====");
        int x = randInt(0,4);
        return new Greeting(x, String.format(template, generarFrase(x)));
    }

 //------ FUNCIONES PARA GENERAR EL CONTENIDO DEL JSON ------//    
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println("Numero rand: " + randomNum);
        return randomNum;
    }
    
    public String generarFrase(int x){
    	String[] frases = {"All my life I thouth air was free... until I bought a bag of chips", 
    			"Happy new year", 
    			"What is love?",
    			"En el bosque de la china",
    			"Alakazam"};
    	return frases[x];
    }

}