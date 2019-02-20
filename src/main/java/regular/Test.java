package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        first();
//        rep();
//        mail();
//        pat();
        part3();
    }

    private static void part2(){
        String str = "[]1, 2,3,4,5]";
        String regex = "[\\[\\] ,]";
        System.out.println(regex);
        System.out.println(str.replaceAll(regex, ""));
    }

    public static void part3(){
        String str="sd54f65sd4f";
        String reg="[a-z]\\d";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }
    }



    // 匹配模式
    private static void pat1() {
        String sr = "dada ada     adad adsda ad asdda adr3 fas daf fas fdsf 234 adda";
        //包含两个匹配组，一个是三个字符，一个是匹配四个字符
        Pattern pet = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b");
        Matcher match = pet.matcher(sr);
        int countAll = match.groupCount();//2
        while (match.find()) {
            System.out.print("匹配组结果：");
            for (int i = 0; i < countAll; i++) {
                System.out.print(String.format("\n\t第%s组的结果是:%s",i+1,match.group(i + 1)));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(match.group());
        }
    }

    // 匹配模式
    private static void pat() {
        Pattern p = Pattern.compile("\\w{3}");
        String str = "abc 124 ewqeq qeqe   qeqe   qeqe  aaaa  fs fsdfs d    sf sf sf  sf sfada dss dee ad a f s f " +
                "sa a'lfsd;'l";
        Matcher matcher = p.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    //判断邮箱是否合法
    private static void mail() {
        String str = "17513158065@163.com";
        String regex = "\\w+@(163|126)\\.com";
        System.out.println(str.matches(regex));
    }

    // 字符串的替换
    private static void rep() {
        String str = "fsdklfjd8f79845rhdksfhiruytiuhfuiddfg8yf89sd7g98sdyg89sdy";
        String regex = "[a-zA-Z]";
        System.out.println(str.replaceAll(regex, "-"));
    }

    //正则表达式使得代码变得简洁
    private static void first() {
        String str = "123508097";
        String regex = "\\d+";
        System.out.println(str.matches(regex));
    }

}
