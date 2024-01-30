//Egemen BALLI 4 Dec 2023

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class ElevatorAlgorithm {
    static Scanner scanner = new Scanner(System.in);
    static int arr[] = new int[8];
    static int disk_size = 200;

    public static void main(String[] args) {
        System.out.println("Enter initial head position:");
        int headPos = scanner.nextInt();
        System.out.println("Enter direction  left or right:");
        String direction = scanner.next();
        System.out.println("Enter sequence");
        for (int i = 0; i < 8; i++) {
            arr[i] = scanner.nextInt();
        }

        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();

        if (direction.equals("left"))
            left.add(0);
        else if (direction.equals("right"))
            right.add(disk_size - 1);

        for (int i = 0; i < 8; i++) {
            if (arr[i] < headPos)
                left.add(arr[i]);
            if (arr[i] > headPos)
                right.add(arr[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        int distance, cur_track;
        int seek_count = 0;
        Vector<Integer> seek_sequence = new Vector<Integer>();

        for (int i = 0; i < 2; i++){
            if (direction.equals("left"))
            {
                for (int j = left.size() - 1; j >= 0; j--)
                {
                    cur_track = left.get(j);
                    seek_sequence.add(cur_track);
                    distance = Math.abs(cur_track - headPos);
                    seek_count += distance;
                    headPos = cur_track;
                }
                direction = "right";
            }
            else if (direction.equals("right"))
            {
                for (int j = 0; j < right.size(); j++)
                {
                    cur_track = right.get(j);
                    seek_sequence.add(cur_track);
                    distance = Math.abs(cur_track - headPos);
                    seek_count += distance;
                    headPos = cur_track;
                }
                direction = "left";
            }
        }

        System.out.println("Seek Sequence is");
        for(int i = 0; i < seek_sequence.size(); i++){
            System.out.println(seek_sequence.get(i));
        }
        System.out.println("Total number of seek operations = " + seek_count);
    }
}
