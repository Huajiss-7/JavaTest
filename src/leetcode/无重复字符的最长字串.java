package leetcode;

import java.util.HashMap;

public class 无重复字符的最长字串 {
    public static void main(String[] args) {
        String s="abcabcbb";
        String s1="aaaaaaaaaaa";
        int maxLength=lengthOfLongestSubstring(s1);
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int max=0;//记录最大长度
        int left=0;//记录当前不重复字串的左边界
        HashMap<Character,Integer>hm=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {//遍历字符串，i就是其右界
            if(hm.containsKey(s.charAt(i))){//如果出现重复字符
                if(hm.get(s.charAt(i))+1>left) //如果重复字符的索引比left小，则表明，重复字符在当前不重复字串之外，已经可以忽略
                    left=hm.get(s.charAt(i))+1;
                //hm.put(s.charAt(i),i);//更新重复字符的位置
            }
            hm.put(s.charAt(i),i);//把当前字符和其位置放入map
            if(i-left+1>max)max=i-left+1;//i-left+1为当前不重复字串的长度
        }
        return max;
    }
}

    /*要理解 left = Math.max(left,map.get(s.charAt(i)) + 1);需要回归到滑动窗口的原理上。

        窗口中始终是无重复字母的字符串。 我们通过窗口的左界和右界控制窗口。

        右界不用特意操作，因为它是+1，+1地涨上去，记得在循环里+1就好。

        左界：每当有一个字符曾经出现过，就需要判断左界。

        重点来了：

        若，被判断的字符上一次出现的位置就在滑动窗口内，即 [ i，j ] 内， 则需要left改变位置，改变为该字符上次出现位置+1。也就是left = map.get(s.charAt(i)) + 1的情况。

        例如：

        abcdb中，窗口正常运行到abcd时，下一个字符为b，b上一次出现在实在窗口里，所以需要把left设置为上一次出现的位置+1的位置，得到新的窗口为cdb，不然你不这样设置，窗口里有重复的字符（bcdb），不符合窗口的定义。

        若，不在滑动窗口内，则不用管。 不用管是因为：窗口中字符串没有重复字符。窗口符合定义。所以left = left。 left = left就表示这个窗口暂时不变。

        Math.max(left,map.get(s.charAt(i)) + 1);无非是一种筛选在不在窗口内的具体筛选，表达形式罢了。

        改成

//    l：左界下标
//    r：右界下标
        if(map.get(s.charAt(i)) <= r && map.get(s.charAt(i)) >= l ){l
        left = map.get(s.charAt(i)) + 1;//在窗口内， map.get(s.charAt(i)) + 1
        }
        else if(map.get(s.charAt(i)) < l){
        left = left;//在窗口前，不变
        }
        else//tan 90°
        也一样

        PS：

        我觉得写成这样虽然麻烦，但是能更清晰地表达原理。
        个人认为面向求学者的题解都应该用这种让人一目了然的代码形式。
        记得更新字符最新一次出现的位置 map.put(s.charAt(i),i);

        因为我们要判断字符出现的位置是否在窗口内，如果被判断的符号一直在窗口外，无所谓更不更新。

        但是，现实是

        一旦被判断的字符就在窗口内，再用“过去的”，“以前的”的位置标记就不行了。

        这回导致窗口内出现了重复字符，但没被检测出来的状况

        所以必须用最新的位置，最新的位置能帮助我们判断该字符是否出现在窗口内。*/