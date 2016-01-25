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
	
	// formato para mostrar la frase
    private static final String template = " : %s";

    // Soporte CORS. Necesario?
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(@RequestParam(required=false, defaultValue="La eterna brevedad del ser") String name) {
        System.out.println("==== saludando ====");
        int x = randInt(0,7);
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
    	String[] frases = {"All my life I thouth air was free... until I bought a bag of chips.", 
    			"When I die, I want to go peacefully like my grandfather did: in his sleep. "
    			+ "Not yelling and screaming like the passengers in his car.", 
    			"Always borrow money from a pessimist. He won’t expect it back.",
    			"Friendship is like peeing on yourself: everyone can see it, but only you get the warm feeling that it brings.",
    			"Dogs have masters. Cats have staff.",
    			"Knowledge is knowing a tomato is a fruit; wisdom is not putting it in a fruit salad.",
    			"I love deadlines. I like the whooshing sound they make as they fly by.",
    			"The best way to lie is to tell the truth . . . carefully edited truth."};
    	return frases[x];
    }

}