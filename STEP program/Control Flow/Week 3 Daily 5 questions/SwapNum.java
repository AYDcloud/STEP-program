import java.util.Scanner;

class SwapNum {
    public static void swap(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter num2: ");
        int num2 = scanner.nextInt();

        int[] nums = {num1, num2}; 
        swap(nums);

        System.out.println("Swapped numbers are " + nums[0] + " and " + nums[1]);
        scanner.close();
    }
}
