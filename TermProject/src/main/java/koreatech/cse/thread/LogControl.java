package koreatech.cse.thread;

import org.apache.logging.log4j.Logger;

import java.util.logging.LogManager;

public class LogControl {

    private static org.apache.logging.log4j.Logger logger;
    private static LogControl logControl = new LogControl();
    private LogControl(){
         logger = org.apache.logging.log4j.LogManager.getLogger(LogControl.class);
    }

    public static void writeDebugMsg(String msg){
        logControl.logger.debug(msg);
    }
    public static void writeInfoMsg(String msg){
        logControl.logger.info(msg);
    }
    public static void func() {
        logControl.logger.debug("DEBUG MSG");
//        int wrong = 2/0;
    }
}
