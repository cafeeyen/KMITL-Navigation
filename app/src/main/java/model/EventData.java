package model;

public class EventData {
    private String header, descrpt, month, date, position;

    public EventData(String header, String descrpt){
        this.header = header;
        this.descrpt = descrpt;
    }

    public EventData(String header, String descrpt, String month, String date, String position){
        this.header = header;
        this.descrpt = descrpt;
        this.month = month;
        this.date = date;
        this.position = position;
    }

    public String getDescrpt() {return descrpt;}

    public void setDescrpt(String descrpt) {this.descrpt = descrpt;}

    public String getHeader() {return header;}

    public void setHeader(String header) {this.header = header;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getMonth() {return month;}

    public void setMonth(String month) {this.month = month;}

    public String getPosition() {return position;}

    public void setPosition(String position) {this.position = position;}
}
