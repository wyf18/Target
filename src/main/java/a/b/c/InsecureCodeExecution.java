package a.b.c;

import java.io.*;

public class InsecureCodeExecution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter command: ");
        String userInput = reader.readLine().trim();  // 获取用户输入

        Process process = Runtime.getRuntime().exec(userInput);

        // 读取标准输出
        BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = outputReader.readLine()) != null) {
            System.out.println(line);
        }

        // 读取错误输出（如果有）
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while ((line = errorReader.readLine()) != null) {
            System.err.println(line);
        }
    }
}

