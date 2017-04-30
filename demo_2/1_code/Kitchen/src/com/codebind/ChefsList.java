package com.codebind;


public class ChefsList {

    private String order;
    private String notes;
    private int tableNo;
    private String server;
    private int id;

    public ChefsList(String Order, String Notes, int TableNo, String Server, int Id){
        this.order = Order;
        this.notes = Notes;
        this.tableNo = TableNo;
        this.server = Server;
        this.id = Id;
    }

    public String getOrder(){
        return order;
    }

    public String getNotes(){
        return notes;
    }

    public int getTableNo(){
        return tableNo;
    }

    public String getServer(){
        return server;
    }

    public int getid() {return id;}


}
