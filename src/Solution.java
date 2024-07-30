class Solution {

    public static void main(String[] args) {
        /*int[]a={2,4,3,3};//q1
        int target=6;
        int[]b=twoSum(a,target);
        System.out.println(""+b[0]+" "+b[1]);*/

        String s=" hello world  ";
        String s1=reverseWords(s);
        System.out.println(s1);


    }
    /*public static int[] twoSum(int[] nums, int target) {//q1
        int[]c=new int[2];
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    if(i==j){
                        continue;
                    }
                    a=i;
                    b=j;
                    c[0]=a;
                    c[1]=b;
                    return c;

                }

            }
        }
        return c;
    }*/

    public static String reverseWords(String s) {
        String s1=s.trim();
        StringBuilder sb=new StringBuilder(s1);
        String result="";
        String s2=sb.reverse().toString();
        for (int i =0; i <s2.length() ; i++) {
            int flag=0;
            String s3=new String();
            StringBuilder sb1=new StringBuilder();
            while(i<s2.length()&&s2.charAt(i)!=' '){//不加前面i<s2.length()会卡内循环，内部越界了，但还没出来，for不会进行判定
                sb1.append(s2.charAt(i));
             i++;
             flag=1;
            }
            if(flag==0){
                continue;
            }
            s3=sb1.reverse().toString();
            result+=s3+" ";
        }
        String f=result.trim();
        return f;
    }

}
