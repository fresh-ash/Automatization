package goodtests.login;

import java.util.function.Function;

public class LogInPage extends Page<LogInPage>{

    public LogInPage getPage(){
        return this;
    }

    static Function<Integer, Integer> getHandler(int handler) {
        return (amount) -> {
            if (amount >= handler) {
                System.out.println("Dispatching $" + handler + " x " + amount / handler);
            }
            return amount % handler;
        };
    }

}
