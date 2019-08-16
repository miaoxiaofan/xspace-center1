package com.xspace.commoncenter.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Created by cbb on 18/1/23.
 * 防止spring boot启动后自动退出
 */
public class ApplicationHolderListener implements ApplicationListener {
    private Thread holdThread;
    private Boolean running = Boolean.FALSE;
    private static final Long CHECK_INTERVAL = 2000L;

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ApplicationPreparedEvent ||
                applicationEvent instanceof ApplicationReadyEvent) {
            if(running == Boolean.FALSE) {
                running = Boolean.TRUE;
            }

            if(holdThread == null) {
                holdThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(ApplicationHolderListener.this.running.booleanValue() && !Thread.currentThread().isInterrupted()) {
                            try {
                                Thread.sleep(CHECK_INTERVAL);
                            } catch (InterruptedException var2) {
                            }
                        }

                    }
                }, "application-holder");
                holdThread.setDaemon(false);
                holdThread.start();
            }
        }

        if(applicationEvent instanceof ContextClosedEvent) {
            running = Boolean.FALSE;
            if(null != holdThread) {
                holdThread.interrupt();
                holdThread = null;
            }
        }

    }
}
