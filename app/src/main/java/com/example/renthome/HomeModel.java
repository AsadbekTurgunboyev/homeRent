package com.example.renthome;

public class HomeModel {
    String name;
    String location;
    int room_number;
    double space_room;
    double price;
    String pic;

    public HomeModel() {
    }

    public HomeModel(String name, String location, int room_number, double space_room, double price, String pic) {
        this.name = name;
        this.location = location;
        this.room_number = room_number;
        this.space_room = space_room;
        this.price = price;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public double getSpace_room() {
        return space_room;
    }

    public void setSpace_room(double space_room) {
        this.space_room = space_room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
