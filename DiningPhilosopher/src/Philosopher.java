public class Philosopher extends Thread {
    public Fork left_fork;
    public Fork right_fork;
    public int rounds;

    public Philosopher(Fork left_fork, Fork right_fork,int rounds){
        this.left_fork = left_fork;
        this.right_fork = right_fork;
        this.rounds = rounds;
    }
    public void action(String act){
        System.out.println(Thread.currentThread().getName()+" "+act);
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){

        }
    }
    public void run(){
        int i=1;
        while (i < rounds){
            action("Thinking");
            synchronized (left_fork){
                action("Picked up left fork: "+left_fork.getNo());
                synchronized (right_fork){
                    action("Picked up right fork: "+right_fork.getNo());
                    action("Eating");
                    action("Put down right fork: "+right_fork.getNo());
                }
                action("Put down left fork: "+left_fork.getNo());
            }
            i++;
        }
    }
}
