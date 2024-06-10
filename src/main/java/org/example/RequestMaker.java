package org.example;

public class RequestMaker implements Food {
    String lunch;

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    @Override
    public void food(String name) {
        System.out.println(name + "님이 점심에 " + lunch + "을(를) 사주셧습니다.");
    }
}
