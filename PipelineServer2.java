import nanomsg.pipeline.PushSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIan on 17/1/11.
 */
public class PipelineServer2 {

    public static void main(String[] args) {
        PushSocket pushSocket = new PushSocket(1);
        pushSocket.bind("tcp://127.0.0.1:7897");
        pushSocket.setSendTimeout(10000);
        List<String> data = new ArrayList<String>();
        data.add("test1");
        data.add("test2");
        data.add("test3");
        for(String s : data){
            pushSocket.send(s);
        }
        pushSocket.close();

    }
}
