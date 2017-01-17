import nanomsg.bus.BusSocket;

import java.util.Date;

/**
 * Created by BIan on 17/1/11."
 */
public class BusServerB {
    public static void main(String[] args) {
        BusSocket busSocket = new BusSocket(1);
        busSocket.bind("ipc:///tmp/node0.ipc");
        busSocket.setRecvTimeout(10000);
        busSocket.setSendTimeout(10000);
        while (true){
            busSocket.send(new Date().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println(busSocket.recvString());
        }
    }
}
