package pro.sky.manukyants;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class ControllerCalc {


    private final ServiseCalc serviseCalc = new ServiseCalc();

    @GetMapping
    public String privet (){
        return "<h> Добро пожаловать в калькулятор <h>";
    }

    @GetMapping("/plus")
    public String plus (@RequestParam(name = "num1", required = false)Integer a,
                       @RequestParam(name = "num2", required = false)Integer b){
        if (a == null || b == null) return "Введите значение полей";
        int plus = serviseCalc.plus(a,b);
        return a + " + " + b + " = " + plus;
    }
    @GetMapping("/minus")
    public String minus (@RequestParam(name = "num1", required = false)Integer a,
                       @RequestParam(name = "num2", required = false)Integer b){
        if (a == null || b == null) return "Введите значение полей";
        int minus = serviseCalc.minus(a,b);
        return a + " - " + b + " = " + minus;
    }
    @GetMapping("/multiple")
    public String multiple(@RequestParam(name = "num1", required = false)Integer a,
                       @RequestParam(name = "num2", required = false)Integer b){
        if (a == null || b == null) return "Введите значение полей";
        int multiple = serviseCalc.multiple(a,b);
        return a + " * " + b + " = " + multiple;
    }
    @GetMapping("/divide")
    public String divide (@RequestParam(name = "num1", required = false)Integer a,
                           @RequestParam(name = "num2", required = false)Integer b){
        if (a == null || b == null) return "Введите значение полей";
        double divide;
        try {
            divide = serviseCalc.divide(a,b);
        }catch (Throwable e){
            return e.getMessage();
        }
        return a + " / " + b + " = " + divide;
    }

}

