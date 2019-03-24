import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("本机器可用processor数量："+Runtime.getRuntime().availableProcessors());
        /**创建work来处理任务*/
        Master master = new Master(new Worker(), Runtime.getRuntime().availableProcessors());

        Random r = new Random();
        for(int i = 1; i <= 100; i++){
            Task t = new Task();
            t.setId(i);
            t.setPrice(r.nextInt(1000));
            /**接收任务*/
            master.submit(t);
        }
        /**分配任务给worker去执行*/
        master.execute();
        long start = System.currentTimeMillis();

        while(true){
            if(master.isComplete()){
                long end = System.currentTimeMillis() - start;
                int priceResult = master.getResult();
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
                break;
            }
        }

    }
}