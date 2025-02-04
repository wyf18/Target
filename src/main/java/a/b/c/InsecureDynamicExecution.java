package a.b.c;

import javax.script.*;
import java.util.Scanner;

public class InsecureDynamicExecution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter JavaScript code to execute: ");
        String userInput = scanner.nextLine();  // 🚨 Source：用户输入

        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            Object result = engine.eval(userInput);  // 🚨 Sink：未经清理的输入直接执行
            System.out.println("Execution result: " + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
