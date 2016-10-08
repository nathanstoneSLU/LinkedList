/**
 * Created by nathanielstone on 4/4/16.
 */
import static java.lang.System.in;
import java.util.Scanner;
public class LinkedList390 {


    public static class node {

        public int data;
        public node next;
    }

    static class LinkedList {

        node front;

        void init() {
            front = null;
        }

        node findTail() {
            node current;
            current = front;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }

        void makeList(int len) {

            int j;
            node tail;
            for (j = 0; j < len; j++) {
                if (j == 0) {
                    front = makeNode(j);
                } else {
                    tail = findTail();
                    tail.next = makeNode(j);
                }
            }

        }

        void addAtEndofList(int data) {
            node tail;
            if (front == null) {
                front = makeNode(data);
            } else {
                tail = findTail();
                tail.next = makeNode(data);
            }
        }

        void myList(int len) {

            for (int j = 0; j < len; j++) {
                makeList(j);
                addAtEndofList(j);

            }

        }

        void showList(node front) {
            node current;
            current = front;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        static node makeNode(int num) {
            node newNode;
            newNode = new node();
            newNode.data = num;
            newNode.next = null;

            return newNode;
        }

        node FindSpot(node front, int num) {
            node curr;
            node prev;
            curr = front;
            prev = front;
            while (curr != null && curr.data <= num) {
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }

        void addAfter(node spot, int data) {
            node newNode;
            newNode = makeNode(data);
            newNode.next = spot.next;
            spot.next = newNode;
        }

        void deleteAfter(node spot) {
            node nextNode;
            nextNode = spot.next;
            spot.next = nextNode.next;
        }
    }

    public static void main(String[] args) {
        int NodeEntered;
        node front = null;
        while (true){
        Scanner input = new Scanner(System.in);
            System.out.println("----------------------------------------------------------------\n");
            System.out.println("               +Welcome to the node creator+                   \n");
            System.out.println("----------------------------------------------------------------\n\n");
        System.out.print("first, how many nodes do you want?");
        NodeEntered = input.nextInt();
        LinkedList List = new LinkedList();
        List.myList(NodeEntered);
        List.showList(List.front);

        System.out.println("\n");


            System.out.print("pick a node to place the [new node] after? \n");
            int NextNode = input.nextInt();

            List.FindSpot(List.front, NextNode);

            System.out.print("What is the value of this new node? \n");
            int NewNode = input.nextInt();

            List.addAfter(List.FindSpot(List.front, NextNode), NewNode);
            List.showList(List.front);

            System.out.println(" ");

            System.out.print("Delete after? \n[pick a number] \nnote*"
                    + "(The node after the one you type will be deleted)?\n");
            int DeleteNode = input.nextInt();

            List.FindSpot(front, DeleteNode);
            List.deleteAfter(List.FindSpot(List.front, DeleteNode));
            List.showList(List.front);
        System.out.println("Start Over?");
        String response = input.nextLine();
        if(response.equalsIgnoreCase("Y")) {
            return;
        }else {
            break;
        }
        }

    }
}



