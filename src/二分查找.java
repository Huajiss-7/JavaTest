public class 二分查找 {
    public static void main(String[] args) {
        int[]arr={7,23,79,81,103,127,131,147};
        int index=binarySearch(arr,23);
        System.out.println("目标值的索引是："+index);
    }

    /*public static int binarySearch(int[] arr, int search) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            mid = min + (max - min) / 2;
            if (arr[mid] == search) {
                return mid; // 找到目标值，直接返回索引
            } else if (arr[mid] < search) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1; // 目标值不存在
    }*/

    public static int binarySearch(int[]arr,int search){
        int min=0;
        int max=arr.length-1;
        int mid=(max+min)/2;
        int index=-1;
        while(min<=max){

            if(arr[mid]<search){
               min=mid+1;
               mid=(min+max)/2;
            }
            else if(arr[mid]>search){
                max=mid-1;
                mid=(min+max)/2;
            }
            if(arr[mid]==search){index=mid;break;}

        }

        return index;
    }
}
