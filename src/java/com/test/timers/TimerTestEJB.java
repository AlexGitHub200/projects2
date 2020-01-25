/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.timers;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import commonj.timers.*;

/**
 *
 * @author alex
 */
@Singleton
@Startup
@LocalBean
public class TimerTestEJB {

//programmatic timer example
    @Resource
    private TimerService timerService;

    @PostConstruct
    private void init() {
   TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("CalendarProgTimerDemo_Info");
        timerConfig.setPersistent(true);
        ScheduleExpression schedule = new ScheduleExpression();
       schedule.hour("*").minute("*").second("*/10");
        timerService.createCalendarTimer(schedule, timerConfig);
    }

    @Timeout
    public void writeToLog(Timer timer) {
        System.out.println("Timer Service : " + timer.getInfo());
        System.out.println("Execution Time from 1 : " + new Date());
        System.out.println("____________________________________________");   
    }

}
