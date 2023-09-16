package com.lhj.exception;

/**
 * 异常类：文本内容过短
 *
 * @author 梁鸿俊
 */
public class ContentShortException extends Exception {

    public ContentShortException() {
        super();
    }

    public ContentShortException(String message) {
        super(message);
    }

    public ContentShortException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentShortException(Throwable cause) {
        super(cause);
    }
}
