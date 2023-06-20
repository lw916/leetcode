import java.util.Arrays;

class KthLargest {

    int[] num = new int[10^4];
    int length;
    int pointer;

    public KthLargest(int k, int[] nums) {
        pointer = k;
        int i = 0;
        for(int key : nums){
            num[i++] = key;
        }
        length = nums.length;
    }

    public int add(int val) {
        num[length++] = val;
        Arrays.sort(num);
        return num[pointer];
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));

    }
}