package com.org.test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
@AccessTimeout(value = 5, unit = TimeUnit.MINUTES)
public class TaskScheduler {
    private static final Logger log = Logger.getLogger(TaskScheduler.class.getName());

    @EJB
    private TaskImpl taskImpl;

    //@Schedule(hour = "14", minute = "00")
	@Schedule(hour = "*", minute = "*/2")
	public void extraRun() {

		log.info("Extra run...");
		try {
			crmTaskImpl.getCrmAccountsFullExport();
			taskImpl.communicateWithJMSQueue();
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Task failed. The error is:\n", ex);
		}
	}
    
}
