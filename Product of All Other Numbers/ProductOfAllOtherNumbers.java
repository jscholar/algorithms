public class ProductOfAllOtherNumbers {
  public static int[] getProductsOfAllIntsExceptAtIndex(int[] nums) {

    int[] result = new int[nums.length];

    int productLeft = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = productLeft;
      productLeft *= nums[i];
    }
    
    int productRight = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        result[i] *= productRight;
        productRight *= nums[i];
    }

    return result;
  }
}