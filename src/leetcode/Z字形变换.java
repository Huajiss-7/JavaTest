package leetcode;

public class Z字形变换 {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if(numRows==1||numRows>=s.length())return s;//只有一行或一列，就是原字符串

        int t=2*numRows-2;
        int column = (int)(Math.ceil((double)s.length() / t)) * (numRows - 1);//一个周期t有numRows+numRows-2个字符,总共(s.length/t)个周期,一个周期有numRows-2+1列，假设最后周期完整，所以要用向上取整，中间不加(double)会偏小，因为整数相除的结果还是整数
        char [][]ans=new char[numRows][column];

        for(int i=0,x=0,y=0;i<s.length();i++){
            ans[x][y]=s.charAt(i);
            if(i%t<numRows-1){//一个周期共t(numRows+numRows-2)个字符在一个周期索引为前numRow-1个字符向下排列
                x++;//向下排列
            }else {
                x--;
                y++;//向右上排列
            }
        }

        StringBuffer sb=new StringBuffer();
        for (char[]row:ans){
            for (char ch:row){
                if(ch!=0)sb.append(ch);//空字符的ASCII码为0
            }
        }
        return sb.toString();
    }
}

   /* 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。(把Z放倒，反着的N   |/|/|形状)

        比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

        P   A   H   N
        A P L S I I G
        Y   I   R
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
*/


/*
方法一：利用二维矩阵模拟
        设 nnn 为字符串 sss 的长度，r=numRowsr=\textit{numRows}r=numRows。对于 r=1r=1r=1（只有一行）或者 r≥nr\ge nr≥n（只有一列）的情况，答案与 sss 相同，我们可以直接返回 sss。对于其余情况，考虑创建一个二维矩阵，然后在矩阵上按 Z 字形填写字符串 sss，最后逐行扫描矩阵中的非空字符，组成答案。

        根据题意，当我们在矩阵上填写字符时，会向下填写 rrr 个字符，然后向右上继续填写 r−2r-2r−2 个字符，最后回到第一行，因此 Z 字形变换的周期 t=r+r−2=2r−2t=r+r-2=2r-2t=r+r−2=2r−2，每个周期会占用矩阵上的 1+r−2=r−11+r-2=r-11+r−2=r−1 列。

        因此我们有 ⌈nt⌉\Big\lceil\dfrac{n}{t}\Big\rceil⌈
        t
        n
        ​
        ⌉ 个周期（最后一个周期视作完整周期），乘上每个周期的列数，得到矩阵的列数 c=⌈nt⌉⋅(r−1)c=\Big\lceil\dfrac{n}{t}\Big\rceil\cdot(r-1)c=⌈
        t
        n
        ​
        ⌉⋅(r−1)。

        创建一个 rrr 行 ccc 列的矩阵，然后遍历字符串 sss 并按 Z 字形填写。具体来说，设当前填写的位置为 (x,y)(x,y)(x,y)，即矩阵的 xxx 行 yyy 列。初始 (x,y)=(0,0)(x,y)=(0,0)(x,y)=(0,0)，即矩阵左上角。若当前字符下标 iii 满足 i mod t<r−1i\bmod t<r-1imodt<r−1，则向下移动，否则向右上移动。

        填写完成后，逐行扫描矩阵中的非空字符，组成答案。

        作者：力扣官方题解
        链接：https://leetcode.cn/problems/zigzag-conversion/solutions/1298127/z-zi-xing-bian-huan-by-leetcode-solution-4n3u/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
