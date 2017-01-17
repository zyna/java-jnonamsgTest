import nanomsg.bus.BusSocket;

/**
 * Created by BIan on 17/1/11.
 */
public class BusNode2 {
    public static void main(String[] args) {
        BusSocket busSocket = new BusSocket(1);

        busSocket.bind("ipc:///tmp/node1.ipc");
        busSocket.connect("ipc:///tmp/node2.ipc");
        busSocket.connect("ipc:///tmp/node3.ipc");
    busSocket.setSendTimeout(10000);
    busSocket.setRecvTimeout(10000);
        while (true){
            busSocket.send("Node1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(busSocket.recvString());
        }
    }
}
