package com.devsu.model;

public class MessageDevsu {

    private String message;
    private String to;
    private String from;
    private long timeToLifeSec;

    public MessageDevsu() {
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getTimeToLifeSec() {
        return timeToLifeSec;
    }
    public void setTimeToLifeSec(long timeToLifeSec) {
        this.timeToLifeSec = timeToLifeSec;
    }
    public String getTo() { return to; }
    public void setTo(String to) {
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
}
