package ecjtu.dao.impl;

import ecjtu.dao.ITicketDao;

public class Ticket_Station implements ITicketDao {
    @Override
    public void buy() {
    System.out.println("请等待，正在出票");
        for(int i=0;i<10000;i++){
            int j=i*45666666;//模拟网络耗时操作
        }
    }
}
