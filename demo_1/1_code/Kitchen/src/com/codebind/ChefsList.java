package com.codebind;


public class ChefsList {

    private String order;
    private String notes;
    private int tableNo;
    private String server;

    public ChefsList(String Order, String Notes, int TableNo, String Server){
        this.order = Order;
        this.notes = Notes;
        this.tableNo = TableNo;
        this.server = Server;
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


}
