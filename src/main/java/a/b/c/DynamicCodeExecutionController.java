package a.b.c;

import org.codehaus.janino.ScriptEvaluator;

@Controller
public class DynamicCodeExecutionController {

    @GetMapping(value = "/")
    public void executeDynamicCode(@RequestParam("input") String input) throws IOException, InvocationTargetException {
        // 允许动态执行用户输入的代码（存在安全风险）
        ScriptEvaluator se = new ScriptEvaluator();

        // 动态拼接输入的内容到脚本中
        String script = "System.out.println(\"" + input + "\");";

        // 执行动态代码
        se.cook(script); // 编译脚本
        se.evaluate(null); // 执行脚本
    }
}
