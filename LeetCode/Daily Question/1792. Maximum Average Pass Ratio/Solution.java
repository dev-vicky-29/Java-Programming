import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store the classes by their potential gain in pass ratio
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Helper function to calculate the gain in pass ratio
        for (int[] cls : classes) {
            int passed = cls[0], total = cls[1];
            double gain = gain(passed, total);
            maxHeap.offer(new double[]{gain, passed, total});
        }

        // Distribute extra students
        for (int i = 0; i < extraStudents; i++) {
            double[] top = maxHeap.poll();
            int passed = (int) top[1];
            int total = (int) top[2];
            passed++;
            total++;
            maxHeap.offer(new double[]{gain(passed, total), passed, total});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int passed = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) passed / total;
        }

        return totalRatio / classes.length;
    }

    // Function to calculate the gain in pass ratio
    private double gain(int passed, int total) {
        return ((double) (passed + 1) / (total + 1)) - ((double) passed / total);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Input number of classes
        System.out.print("Enter number of classes: ");
        int n = scanner.nextInt();

        // Input classes
        int[][] classes = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter passed and total students for class " + (i + 1) + ": ");
            classes[i][0] = scanner.nextInt();
            classes[i][1] = scanner.nextInt();
        }

        // Input number of extra students
        System.out.print("Enter number of extra students: ");
        int extraStudents = scanner.nextInt();

        // Create Solution object and get the result
        Solution solution = new Solution();
        double result = solution.maxAverageRatio(classes, extraStudents);
        System.out.printf("Maximum average pass ratio: %.5f\n", result);

        scanner.close();
    }
}
