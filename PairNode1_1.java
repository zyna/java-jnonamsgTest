import nanomsg.pair.PairSocket;

/**
 * Created by BIan on 17/1/11.
 */
public class PairNode1_1 {
    public static void main(String[] args) {
        PairSocket pairSocket = new PairSocket(1);
        pairSocket.connect("tcp://127.0.0.1:7899");
        pairSocket.setRecvTimeout(10000);
        //pairSocket.setSendTimeout(10000);
        while (true) {
            System.out.println(pairSocket.recvString());
           // pairSocket.send("pair node1 send!");
        }
    }
}
