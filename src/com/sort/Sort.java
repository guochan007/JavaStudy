
public class Sort {

	public static void main(String[] args) {
		xuanZe();
		// maoPao();
	}

	private static void xuanZe() {
		int[] nums = { 5, 4, 3, 2, 1 };
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
			for (int x = 0; x < nums.length; x++) {
				System.out.print(nums[x] + ",");
			}
			System.out.print("\n");
		}
	}

	private static void maoPao() {
		int[] nums = { 5, 4, 3, 2, 1 };
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
			for (int x = 0; x < nums.length; x++) {
				System.out.print(nums[x] + ",");
			}
			System.out.print("\n");
		}
	}

}
