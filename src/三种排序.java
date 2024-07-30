public class 三种排序 {
    public static void main(String[] args) {
        int[]arr={10,3,2,5,9,1,4,6,8,7};
        //bubble(arr);
        //select(arr);
        //insert(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void insert(int[]arr){
        //找到无序开始的索引
        int startIndex=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>arr[i+1]){
                startIndex=i+1;
                break;
            }
        }
        //System.out.println(startIndex);

        for (int i = startIndex; i <arr.length ; i++) {
            int j=i;
            while(j>0&&arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }
    public static void select(int[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void bubble(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
