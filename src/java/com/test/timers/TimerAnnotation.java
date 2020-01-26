/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.timers;

import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author alex
 */
@Singleton
@LocalBean
@Startup
//automatic timer example
public class TimerAnnotation {
     @Schedule(second="*/5", minute="*", hour="*")
    public void execute() {
        System.out.println("Executing ...");
        System.out.println("Execution Time from 2 : " + new Date());
        System.out.println("__________________________________________");


    }
 
}
