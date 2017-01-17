import nanomsg.Socket;
import nanomsg.async.*;
import nanomsg.pipeline.PushSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIan on 17/1/11.
 */
public class SyncPushSocket {
    public static void main(String[] args) throws  Exception{
        PushSocket pushSocket = new PushSocket();
        AsyncSocket asyncSocket = new AsyncSocket(pushSocket);
        pushSocket.bind("tcp://127.0.0.1:7897");

        List<String> data = new ArrayList<String>();
        data.add("test8");
        data.add("test7");
        data.add("test6");
        for(String s : data){
            asyncSocket.send(s, new IAsyncCallback<Boolean>() {
                @Override
                public void success(Boolean result) {
                    System.out.println(result);
                }

                @Override
                public void fail(Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
        }
        pushSocket.close();
    }
}
