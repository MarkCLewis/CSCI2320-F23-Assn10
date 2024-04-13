/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package csci2320;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    static record IndexValuePair(int index, int value) {}

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String testType = sc.next();
            if (testType.equals("speed")) {
                speed(1000000);
                return;
            }
            Random rand = new Random(sc.nextLong());
            int size1 = sc.nextInt();
            int size2 = sc.nextInt();

            switch (testType) {
                case "basic":
                    testGet(size1, rand);
                    testSet(size1, rand);
                    testGet(size2, rand);
                    testSet(size2, rand);
                    break;
                case "immutable":
                    testImmutable(size1, rand);
                    testImmutable(size2, rand);
                    break;
            }
        }
    }

    static void printSeqSums(BTVector<Integer> seq) {
        int sum = 0;
        for (int i: seq) sum += i;
        System.out.println(sum);
    }

    static void testGet(int size, Random rand) {
        System.out.println("Start get.");
        BTVector<Integer> vec = BTVector.empty();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            var n = rand.nextInt();
            vec = vec.add(n);
            nums.add(n);
        }
        for (int i = 0; i < size; ++i) {
            if (!nums.get(i).equals(vec.get(i))) {
                System.out.println("get failed " + i + ", " + nums.get(i) + " != " + vec.get(i));
                return;
            }
        }
        printSeqSums(vec);
    }

    static void testSet(int size, Random rand) {
        System.out.println("Start set.");
        BTVector<Integer> vec = BTVector.empty();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            var n = rand.nextInt();
            vec = vec.add(n);
            nums.add(n);
        }
        printSeqSums(vec);
        List<IndexValuePair> ivps = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            if (rand.nextDouble() < 0.3) {
                var n = rand.nextInt();
                vec = vec.set(i, n);
                ivps.add(new IndexValuePair(i, n));
            }
        }
        for (var ivp : ivps) {
            if (!vec.get(ivp.index).equals(ivp.value)) {
                System.out.println("get failed " + ivp + ", " + vec.get(ivp.index));
                return;
            }
        }
        printSeqSums(vec);
    }

    static void testImmutable(int size, Random rand) {
        System.out.println("Start immutable.");
        List<Double> nums = new ArrayList<>();
        List<BTVector<Double>> vecs = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            double x = rand.nextDouble();
            nums.add(x);
            if (i == 0) {
                vecs.add(BTVector.<Double>empty().add(x));
            } else {
                vecs.add(vecs.get(i-1).add(x));
            }
        }
        for (int i = 0; i < size; ++i) {
            var v = vecs.get(i);
            if (i+1 != v.size()) {
                System.out.println("Vector " + i + " is wrong size: " + vecs.get(i).size());
                return;
            }
            for (int j = 0; j <= i; ++j) {
                if (!v.get(j).equals(nums.get(j))) {
                    System.out.println("Wrong value in vector " + i + " at " + j);
                }
            }
        }
        double sum = 0.0;
        for (var x : vecs.get(size - 1)) sum += x;
        System.out.printf("Sum1: %1.4f\n", sum);
        var v1 = vecs.get(size - 2);
        var v2 = vecs.get(size - 1);
        for (int i = 0; i < size - 1; ++i) {
            var oldx = v1.get(i);
            var newx = rand.nextDouble();
            if (rand.nextDouble() < 0.3) {
                v2 = v2.set(i, newx);
                if (!v2.get(i).equals(newx)) {
                    System.out.println("New vector not set properly: " + i);
                    return;
                }
            }
            if (!oldx.equals(v1.get(i))) {
                System.out.println("Changed wrong vector on set: " + i);
                return;
            }
        }
        sum = 0.0;
        for (var x : v2) sum += x;
        System.out.printf("Sum2: %1.4f\n", sum);
        sum = 0.0;
        for (var x : vecs.get(size - 1)) sum += x;
        System.out.printf("Sum3: %1.4f\n", sum);
    }

    static void speed(int size) {
        var start = System.nanoTime();
        Random rand = new Random(45283);

        testGet(100000, rand);
        System.out.println("Get time: " + (System.nanoTime() - start)*1e-9);
        testSet(100000, rand);
        System.out.println("Set time: " + (System.nanoTime() - start)*1e-9);
        testImmutable(100000, rand);
        System.out.println("Final time: " + (System.nanoTime() - start)*1e-9);
    }
}
