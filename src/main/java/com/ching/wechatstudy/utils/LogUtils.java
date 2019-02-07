/*
* ------------------------------------------------------------------
* Copyright © 2018 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
* ------------------------------------------------------------------
*       Product: SMR(case-center)
*   Module Name: 框架
* Date Created: 2018-10-17
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-10-17      黄棠 1082
* ------------------------------------------------------------------
*/

package com.ching.wechatstudy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    private Logger logger;

    /*哪个类需要打印日志，就需要在该类中创建日志*/
    public LogUtils(Class clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public void error(String logContent) {
        logger.error(logContent);
    }

    public void error(Exception e) {
        logger.error("", e);
    }

    public void error(String errorMsg, Exception e) {
        logger.error(errorMsg, e);
    }

    public void error(String errorMsg, Throwable e) {
        logger.error(errorMsg, e);
    }

    public void warn(String logContent) {
        logger.warn(logContent);
    }

    public void info(String logContent) {
        logger.info(logContent);
    }

    public void debug(String logContent) {
        logger.debug(logContent);
    }

    public void trace(String logContent) {
        logger.trace(logContent);
    }
}
