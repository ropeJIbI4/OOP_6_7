package models;

public class Note {
    
    private String id = "";
    private String data;
    private String header;
    private String text;

    public Note(String data, String header, String text) {
        this.data = data;
        this.header = header;
        this.text = text;
    }

    public Note(String id, String data, String header, String text) {
        this(data, header, text);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nДата: %s,\nЗаголовок: %s,\nСодержанине: %s", getId(), getData(), getHeader(), getText());
    }
       
}