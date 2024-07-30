public class 快速排序 {
    public static void main(String[] args) {
        int[]arr={10,3,2,5,9,1,4,6,8,7};
        int[]arr1={9,1,2,3,4,5,6,7,10,8};
        quickSort5(arr1,0,arr1.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    public static void quickSort1(int[]arr,int i,int j){
        int start=i;
        int end=j;

        if(start>=end)return;

        int baseNumber=arr[start];
        while(start!=end){//start和end的变化顺序很重要，应该end先变
            while (start<end&&arr[start]<=baseNumber){
                start++;
            }
            while (start<end&&arr[end]>=baseNumber){
                end--;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        //arr[start]=baseNumber;
        int temp=arr[i];
        arr[i]=arr[end];
        arr[end]=temp;

        quickSort1(arr,i,end-1);
        quickSort1(arr,start+1,j);
    }

    public static void quickSort2(int[]arr,int i,int j){
        int start=i;
        int end=j;

        if(start>=end)return;

        int baseNumber=arr[start];
        while(start!=end){
            while(true){
                if(end <= start || arr[end] < baseNumber){
                    break;
                }
                end--;
            }
            while(true){
                if(end <= start || arr[start] > baseNumber){
                    break;
                }
                start++;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        //arr[start]=baseNumber;
        int temp=arr[i];
        arr[i]=arr[end];
        arr[end]=temp;

        quickSort2(arr,i,end-1);
        quickSort2(arr,start+1,j);
    }

    public static void quickSort3(int[]arr,int i,int j){
        int start=i;
        int end=j;

        if(start>=end)return;

        int baseNumber=arr[start];
        while(start!=end){
            while (start<end&&arr[end]>=baseNumber){
                end--;
            }
            while (start<end&&arr[start]<=baseNumber){
                start++;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        //arr[start]=baseNumber;
        int temp=arr[i];
        arr[i]=arr[end];
        arr[end]=temp;

        quickSort3(arr,i,end-1);
        quickSort3(arr,start+1,j);
    }

    public static void quickSort4(int[]arr,int i,int j){
        int start=i;
        int end=j;

        if(start>=end)return;

        int baseNumber=arr[start];
        while(start!=end){
            while(true){
                if(end <= start || arr[start] > baseNumber){
                    break;
                }
                start++;
            }
            while(true){
                if(end <= start || arr[end] < baseNumber){
                    break;
                }
                end--;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        //arr[start]=baseNumber;
        //这种是需要归位的
        int temp=arr[i];
        arr[i]=arr[end];
        arr[end]=temp;

        quickSort4(arr,i,end-1);
        quickSort4(arr,start+1,j);
    }

    public static void quickSort(int[] arr, int i, int j) {
        int start = i;
        int end = j;

        if (start >= end) return;

        // 选择中间元素作为基准值
        int mid = start + (end - start) / 2;
        int baseNumber = arr[mid];

        while (start <= end) {
            while (arr[start] < baseNumber) {
                start++;
            }
            while (arr[end] > baseNumber) {
                end--;
            }
            if (start <= end) {
                // 交换元素
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, i, end);
        quickSort(arr, start, j);
    }

    //2024.4.7号版本
    public static void quickSort6(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        // 选择中间元素作为pivot
        //int middle = low + (high - low) / 2;
        int pivot = arr[low];//基准元素随便选

        // 将数组分为两部分
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //这种方式，不用把pivot归位，因为pivot有可能被归进左半边或右半边，只是一种逻辑上把比pivot大(或相等)的归到一边，小(或相等)的归到一边，再对每一边这样操作，直到最后每一边只剩一个元素，这时候才是归位
        // 递归排序左半部分和右半部分
        if (low < j) {
            quickSort5(arr, low, j);
        }
        if (high > i) {
            quickSort5(arr, i, high);
        }
    }

    public static void quickSort5(int[]arr,int low,int high){
        if(low>=high)return;
        int pivot=arr[low];
        int i=low,j=high;
        while (i<=j){
            while (arr[i]<pivot)i++;
            while (arr[j]>pivot)j--;
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        quickSort5(arr,low,j);
        quickSort5(arr,i,high);
    }
}
