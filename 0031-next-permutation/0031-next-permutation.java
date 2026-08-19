class Solution {
    public void nextPermutation(int[] nums) {

        int breakpoint = -1;

        // Step 1: Find breakpoint
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                breakpoint = i - 1;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse whole array
        if(breakpoint == -1){
            int i = 0;
            int j = nums.length - 1;

            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j--;
            }

            return;
        }

        // Step 3: Find next greater element and swap
        for(int i = nums.length - 1; i > breakpoint; i--){
            if(nums[i] > nums[breakpoint]){

                int temp = nums[i];
                nums[i] = nums[breakpoint];
                nums[breakpoint] = temp;

                break;
            }
        }

        // Step 4: Reverse after breakpoint
        int i = breakpoint + 1;
        int j = nums.length - 1;

        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}