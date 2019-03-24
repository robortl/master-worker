

public class MyWorker extends Worker{

    public static Object handle(Task input){
        Object output = null;
        try {
            //处理任务的耗时。。 比如说进行操作数据库。。。
            System.out.println("taskID:"+input.getId());
            Thread.sleep(500);
            output = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}