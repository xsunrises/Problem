package ColorProblem;

import java.util.Scanner;

/**
 * 颜色分类问题
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        String[] in = null;
        in = scan.nextLine().split(" ");
        int nums[]=new int[in.length];
        for(int i=0;i<nums.length;i++) {
            nums[i] = Integer.valueOf(in[i]);
        }

        //bubbleSort(nums);
        //selectionSort(nums);
        insertionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
  /**
    * 1.冒泡排序
    *
    * 第一层循环表示循环的次数，即数组的长度
    * 第二层循环中比较最两个左边两个数大小，右边大则交换，右边小则不动。
    */
    public static void bubbleSort(int[] nums) {
        int tem = 0;
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - j - 1; i++) {	//不减1越界了！！
                if (nums[i] > nums[i + 1]) {
                    tem = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = tem;
                }
            }
        }
    }

    /**
     * 2.选择排序
     *
     * 具体实现待排序数据序列的第一个元素和这个序列中的其他所有元素比较，这样拿到最小值，就放在刚才这个待排序序列的第一个位置。
     * 第一层循环:每循环一次确认一个nums[i]的位置（依次从左至右）循环nums.length次
     * 第二层循环:每次循环用nums[i]与剩下的nums[i+1]到nums[nums.length] Ps(nums[j])的数字进行对比;
     * 若nums[j]小于nums[i], int temp=nums[i];nums[i]=nums[j],nums[j]=temp; else,不操作
     */
    public static void selectionSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {				//从数组第一位循环到最后一位，一次从左至右确认最小值。
                for (int j = i + 1; j < nums.length; j++) {		//每次循环和数组中剩下的元素比较若小于则对换位置，若大于则不操作
                    if (nums[j] < nums[i]) {					//判断大于还是小于
                        int temp = nums[i];						//设定临时地址存放nums[i]；
                        nums[i] = nums[j];						//交换
                        nums[j] = temp;							//交换
                    }

                }
            }
    }

    /**
     * 3.插入排序
     * 插入排序像是洗牌一样
     * 从左至右从数组中拿出数字i记做temp。拿出的temp跟它左边的数字进行比较若左边的数字比它大则该数字向右挪一个位置。
     * 依次循环，若遇到比他小的数字则跳出循环。因为左边的数字比他小右边的数字又都比它大则这就是temp当前该待的相对位置。
     */
    public static void insertionSort(int[] nums) {
            for(int i = 1;i<nums.length;i++) {	//直接让i=1了因为若是i从0开始左边没数可以比。没有必要
                int temp = nums[i];			//用一个临时地址记住nums[i]的值，是因为nums[i]会被动态的赋值。
                int j;							//在外面定义j是因为第二重循环结束时，还需要用到j这个局部变量。
                for(j=i-1;j>=0;j--) {			//循环的次数为nums[i]左边的牌数。所以是j=i-1。循环到没牌时结束即0时。
                    if(nums[j]>temp) {		//必须跟temp比值，不能跟nums[i]比。因为nums[i]的值已经改变（变成nums[j]）
                        nums[j+1]=nums[j];	//必须是nums[j]赋值给nums[j+1] 不能是nums[i]=nums[j] 因为是比temp大的往上挪一位，若是用i表示就变成插入。
                    }else {
                        break;					//若是temp比左边的牌大或是一样大，直接跳出第二重for循环。
                    }
                }
                nums[j+1]=temp;			//这里才是temp真正要插入的位置。因为循环结束j--了。所以需要加一，回到循环结束时j的位置插入temp。
            }
    }
}
