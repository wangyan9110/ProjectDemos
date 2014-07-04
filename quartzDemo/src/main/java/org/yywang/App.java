package org.yywang;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //创建一个JobDetail实例
        JobBuilder builder=JobBuilder.newJob(SimpleJob.class);
        JobDetail jobDetail=builder.build();
        //创建一个调度规则，1s中运行一次，现在开始
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever()).
                startNow().build();
        try {
            //获取一个调度器
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            //注册jobDetail，trigger到调度器
            scheduler.scheduleJob(jobDetail,trigger);
            //开始执行
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
