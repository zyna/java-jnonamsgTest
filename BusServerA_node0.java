import nanomsg.bus.BusSocket;

/**
 * Created by BIan on 17/1/11."
 */
public class BusServerA_node0 {
    public static void main(String[] args) {
        BusSocket busSocket = new BusSocket(1);
        busSocket.connect("ipc:///tmp/node0.ipc");
        while (true){
            System.out.println(busSocket.recvString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
