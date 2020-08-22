package org.javadominicano.telegram.bot.handler.register;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "contacts", schemaVersion= "1.0")
public class Contact {

    @Id
    private String username;
    private boolean temporal;
    private String joined;

    public Contact(){
        joined();
    }

    public Contact(String username){
        this.username = username;
        joined();
    }

    private void joined(){
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        this.joined = dateFormat.format(date);  
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }
}