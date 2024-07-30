package leetcode;

import java.util.*;

public class 找出出现至少三次的最长特殊子字符串 {
    public static void main(String[] args) {
        String s="cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde";
        System.out.println(maximumLength(s));
    }

    public static int maximumLength(String s) {
        Map<String,Integer>map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for(int j=i+1;j<=s.length();j++){
                String substring = s.substring(i, j);
                if (!isSameChar(substring)) {
                    continue;
                }
                map.put(substring,map.getOrDefault(substring,0)+1);
            }
        }
        int max=-1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()>=3){
                max=Math.max(max,entry.getKey().length());
            }
        }
        return max;
    }

    private static boolean isSameChar(String str){
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    //优化
    public int maximumLength1(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            cnt++;
            if (i + 1 == s.length || s[i] != s[i + 1]) {//i+1==s.length防止越界，也就是当到末尾了，直接结束计数，添加进去，其它情况遇到下一个不一样了停止计数，加入列表
                groups[s[i] - 'a'].add(cnt); // 统计连续字符长度
                cnt = 0;
            }
        }

        int ans = 0;
        for (List<Integer> a : groups) {
            if (a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());//从大到小排序
            a.add(0);//不用特判a的长度小于三的情况
            a.add(0); // 假设还有两个空串
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }

        return ans > 0 ? ans : -1;
    }
    /*由于特殊子串只包含单一字母，我们按照相同字母分组，每组统计相同字母连续出现的长度。例如字符串 aaaabbbabb 分成 aaaa+bbb+a+bb 四组，字母 a 有长度 444 和长度 111，字母 b 有长度 333 和长度 222。所以字母 a 的长度列表为 [4,1][4,1][4,1]，字母 b 的长度列表为 [3,2][3,2][3,2]。

    遍历每个字母对应的长度列表 aaa，把 aaa 从大到小排序。

    有哪些取出三个特殊子串的方法呢？

    从最长的特殊子串（a[0]a[0]a[0]）中取三个长度均为 a[0]−2a[0]-2a[0]−2 的特殊子串。例如示例 1 的 aaaa 可以取三个 aa。
    或者，从最长和次长的特殊子串（a[0],a[1]a[0],a[1]a[0],a[1]）中取三个长度一样的特殊子串：
    如果 a[0]=a[1]a[0]=a[1]a[0]=a[1]，那么可以取三个长度均为 a[0]−1a[0]-1a[0]−1 的特殊子串。
    如果 a[0]>a[1]a[0]>a[1]a[0]>a[1]，那么可以取三个长度均为 a[1]a[1]a[1] 的特殊子串：从最长中取两个，从次长中取一个。
    这两种情况合并成 min⁡(a[0]−1,a[1])\min(a[0]-1, a[1])min(a[0]−1,a[1])。
    又或者，从最长、次长、第三长的的特殊子串（a[0],a[1],a[2]a[0],a[1],a[2]a[0],a[1],a[2]）中各取一个长为 a[2]a[2]a[2] 的特殊子串。
    这三种情况取最大值，即

    max⁡(a[0]−2,min⁡(a[0]−1,a[1]),a[2])\max(a[0]-2, \min(a[0]-1, a[1]), a[2])
    max(a[0]−2,min(a[0]−1,a[1]),a[2])
    对每个长度列表计算上式，取最大值即为答案。

    如果答案是 0，返回 −1。

    代码实现时，在数组末尾加两个 0，就无需特判 a 长度小于 3 的情况了。*/


}

    /*给你一个仅由小写英文字母组成的字符串 s 。

        如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。

        返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。

        子字符串 是字符串中的一个连续 非空 字符序列。



        示例 1：

        输入：s = "aaaa"
        输出：2
        解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
        可以证明最大长度是 2 。
        示例 2：

        输入：s = "abcdef"
        输出：-1
        解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
        示例 3：

        输入：s = "abcaba"
        输出：1
        解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
        可以证明最大长度是 1 。*/