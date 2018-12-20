package cendy.chen.org.test;

public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String somebody) {
        return "hello " + somebody + "!";
    }


}
