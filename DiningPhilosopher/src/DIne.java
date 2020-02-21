public class DIne {
    public static void main(String args[]){
        int number = 5;
        int rounds = 5;
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];
        for(int a=0;a<number;a++){
            forks[a] = new Fork(a);
        }
        for(int i=0; i<number; i++){
            Fork left_fork = forks[i];
            Fork right_fork = forks[(i+1)%number];
            if(i==(number-1))
                philosophers[i] = new Philosopher(right_fork,left_fork,rounds);
            else
                philosophers[i] = new Philosopher(left_fork, right_fork, rounds);
            Thread t = new Thread(philosophers[i],"philosopher "+(i+1));
            t.start();
        }

    }
}
