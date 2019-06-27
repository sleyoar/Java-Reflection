package ecjtu.test;

import ecjtu.dao.ITicketDao;
import ecjtu.dao.impl.Ticket_Station;
import ecjtu.handler.TicketInvocationHandler;

import java.lang.reflect.Proxy;

public class TestTicket {
    public static void main(String[] args) {
        Ticket_Station station=new Ticket_Station();
        ITicketDao ticketDao =(ITicketDao) Proxy.newProxyInstance(TestTicket.class.getClassLoader(),station.getClass().getInterfaces(),new TicketInvocationHandler(station));
        ticketDao.buy();
    }
}
