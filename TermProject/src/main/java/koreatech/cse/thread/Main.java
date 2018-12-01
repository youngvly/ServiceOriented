package koreatech.cse.thread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/***main함수 어떻게쓰지,,??
@Component
public class Main {

    private static final String[] SPRING_CONFIG_XML = new String[] {"service.xml"};
    //    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String [] args){
//        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ApplicationContext context = new ClassPathXmlApplicationContext(SPRING_CONFIG_XML);
        //60초마다 joblist에 있는 뉴스 받아오기

        Main mainclass = context.getBean(Main.class);
        mainclass.setTimeThread();
    }

    private static void setTimeThread() {
        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate( new TimerAutoPull(),
                10,                         //1초뒤에
                60,                         //1초마다 한번씩 실행
                TimeUnit.SECONDS);
    }
}
*/
