import nanomsg.pair.PairSocket;

/**
 * Created by BIan on 17/1/11.
 */
public class PairServer {


    public static void main(String[] args) {
        PairSocket pairSocket = new PairSocket(1);
        pairSocket.bind("tcp://127.0.0.1:7899");
        pairSocket.setSendTimeout(10000);
        //pairSocket.setRecvTimeout(10000);
        while (true) {
           // System.out.println(pairSocket.recvString());
            pairSocket.send("pair test");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(pairSocket.recvString());
        }
    }
}
