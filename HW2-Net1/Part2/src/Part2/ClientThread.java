/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part2;

/**
 *
 * @author hp
 */
public class ClientThread implements Runnable {

    ClientChat c;
    boolean exit;
    public void stop()
    {
        exit = true;
    }

    ClientThread(ClientChat aThis) {
        c = aThis;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            //System.err.println(c.logedin);
            c.receive();
        }
    }
}
