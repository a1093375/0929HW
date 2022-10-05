import java.util.*;
class sellTickets implements Runnable{
    static int Tickets=10;
    int mTickets;
    Thread t;
    sellTickets(String name){
        mTickets=0;
        t=new Thread(this, name);
        t.start();

    }
    int random = (int) (Math.random()*4)+1;
    
    public void run(){
        while(sellout()==true){
            
            System.out.println(random);
            for(int i=0;i<random;i++){
                mTickets++;
            }

            
            
            System.out.println(t.getName()+"賣了"+mTickets+"張票");

            break;
           
        }

    }

    synchronized private  boolean sellout() {
        if(Tickets>0){
            for(int i=0;i<=random;i++){
                Tickets--;
            }
            return true;
        }else return false;
        
    }
}


public class H0929{
    public static void main(String[] args) {
        
        sellTickets M1=new sellTickets("machine1");
        sellTickets M2=new sellTickets("machine2");
        sellTickets M3=new sellTickets("machine3");
        sellTickets M4=new sellTickets("machine4");
    }
}
