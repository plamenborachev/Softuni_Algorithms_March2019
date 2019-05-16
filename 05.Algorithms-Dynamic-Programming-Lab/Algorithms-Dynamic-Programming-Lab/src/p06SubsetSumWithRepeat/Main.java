package p06SubsetSumWithRepeat;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[]{3, 5, 2};

        int targetSum = 17;

        boolean[] possibleSums = new boolean[targetSum + 1];

        possibleSums[0] = true;

        for (int sum = 0; sum < possibleSums.length; sum++) {
            if (possibleSums[sum]){
                for (int number : numbers) {
                    int newSum = sum + number;
                    if (newSum <= targetSum) {
                        possibleSums[newSum] = true;
                    }
                }
            }
        }

        while (targetSum != 0){
            for (int i = 0; i < numbers.length; i++) {
                int sum = targetSum - numbers[i];
                if (sum >= 0 && possibleSums[sum]){
                    System.out.print(numbers[i] + " ");
                    targetSum = sum;
                }
            }
        }

        System.out.println(possibleSums[targetSum]);
    }
}
