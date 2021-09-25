package com.jerry.jerryinterfaces.facade;



import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yiche
 */
@RequestMapping("/log")
@RestController
public class LogbackFacade {
    /**
     * logback动态修改包名的日志级别
     * @param level 日志级别
     * @param packageName 包名ß
     * @return 当前的日志级别
     * @throws Exception
     */
    @RequestMapping(value = "/setlevel")
    public String updateLogbackLevel( @RequestParam(value="level") String level,
                                      @RequestParam(value="packageName",defaultValue = "-1") String packageName) {
        ch.qos.logback.classic.LoggerContext loggerContext =(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger= null;
        if(packageName.equals("-1")) {
            // 默认值-1，更改全局日志级别；否则按传递的包名或类名修改日志级别。
            logger=  loggerContext.getLogger("root");
        } else {
            logger= loggerContext.getLogger(packageName);
        }
        logger.setLevel(ch.qos.logback.classic.Level.toLevel(level));
        return logger.getLevel().levelStr;
    }

}