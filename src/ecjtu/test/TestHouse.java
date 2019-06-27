package ecjtu.test;

import ecjtu.dao.IFindHouse;
import ecjtu.dao.impl.Master;
import ecjtu.handler.LinkHome;

public class TestHouse {
    public static void main(String[] args) {
        IFindHouse house =(IFindHouse) new LinkHome().getInstance(new Master());
        house.rentHouse();
    }
}
