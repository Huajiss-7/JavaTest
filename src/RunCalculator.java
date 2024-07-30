public class RunCalculator {
    public static void main(String[] args) {
        try {
            // 执行计算器的命令
            String command = "calc";
            Process process = Runtime.getRuntime().exec(command);

            // 等待计算器进程结束
            process.waitFor();

            // 打印计算器的返回值（通常为0）
            System.out.println("Calculator exited with code: " + process.exitValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
