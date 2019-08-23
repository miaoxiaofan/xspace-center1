package com.xspace.ordercenter.task;/**
 * Created by huxl on 2019/8/1.
 */

import com.xspace.ordercenter.service.DeleteRedisKeyService;
import com.xspace.ordercenter.service.SyncCompanyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author huxl
 * @date 2019-08-01 09:37
 */
@Component
@Configuration  //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling  // 2.开启定时任务
@PropertySource("classpath:/properties/scheduler.properties")    // 3.配置文件位置
public class SyncCompanyFileTask implements SchedulingConfigurer {

    @Resource
    SyncCompanyFileService syncCompanyFileService;

    @Autowired
    private DeleteRedisKeyService deleteRedisKeyService;

    @Value("${scheduler.date}")
    private String dateStr;
    @Value("${scheduler.cronConfig}")
    private String cronConfig;
    public static String cron = "*/60 * * * * ?";


    @Scheduled(cron = "${scheduler.cron}")
    private void execute(){
          System.out.println("数据同步定时任务每分钟扫描一次");
          cron = cronConfig;
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("每月1号执行数据同步任务");
                try {
                    //dateStr=201904
                    String date = dateStr;
                    if(StringUtils.isEmpty(date)){
                        //日期为空。默认获取上个月份的文件
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date());
                        cal.add(Calendar.MONTH, -1);
                        SimpleDateFormat format= new SimpleDateFormat("yyyyMM");
                        date = format.format(cal.getTime());
                    }
                    //syncCompanyFileService.fetchCompanyData(date);
                    //删除过期key
                    deleteRedisKeyService.deleteOutOfDateLKey();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });

    }
}
