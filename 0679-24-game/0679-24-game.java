class Solution {
    private static final double EPSILON = 1e-6;
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }
    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPSILON;
        }

         for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> nextNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        nextNums.add(nums.get(k));
                    }
                }

                double num1 = nums.get(i);
                double num2 = nums.get(j);

                List<Double> results = new ArrayList<>();
                results.add(num1 + num2);
                results.add(num1 - num2);
                results.add(num2 - num1);
                results.add(num1 * num2);
                if (Math.abs(num2) > EPSILON) {
                    results.add(num1 / num2);
                }
                if (Math.abs(num1) > EPSILON) {
                    results.add(num2 / num1);
                }

                for (Double result : results) {
                    nextNums.add(result);
                    if (solve(nextNums)) {
                        return true; 
                    }
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        return false;
    }
}


