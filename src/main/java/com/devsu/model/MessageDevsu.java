package com.devsu.model;

import jakarta.persistence.*;

@Entity
public class MessageDevsu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "`message`")
    private String message;
    @Column(name = "`to`")
    private String to;
    @Column(name = "`from`")
    private String from;
    @Column(name = "`timeToLifeSec`")
    private long timeToLifeSec;

    public MessageDevsu() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTo() {
        return to;
    }

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
