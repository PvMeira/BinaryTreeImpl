package run;

import core.impl.BinarySearchTreeImpl;

import java.util.Scanner;

/**
 * Created by pvmeira on 27/04/17.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* Creating object of BST */

        BinarySearchTreeImpl node = new BinarySearchTreeImpl();

        System.out.println("Binary Search Tree Test\n");

        char ch;

        /*  Perform tree operations  */

        do

        {

            System.out.println("\nBinary Search Tree Operations\n");

            System.out.println("1. insert ");

            System.out.println("2. delete");

            System.out.println("3. search");

            System.out.println("4. count nodes");

            System.out.println("5. check empty");


            int choice = scan.nextInt();

            switch (choice)

            {

                case 1:

                    System.out.println("Enter integer element to insert");

                    node.insert(scan.nextInt());

                    break;

                case 2:

                    System.out.println("Enter integer element to delete");

                    node.delete(scan.nextInt());

                    break;

                case 3:

                    System.out.println("Enter integer element to search");

                    System.out.println("Search result : " + node.search(scan.nextInt()));

                    break;

                case 4:

                    System.out.println("Nodes = " + node.countNodes());

                    break;

                case 5:

                    System.out.println("Empty status = " + node.isEmpty());

                    break;

                default:

                    System.out.println("Wrong Entry \n ");

                    break;

            }

            /*  Display tree  */

            System.out.print("\nPost order : ");

            node.postorder();

            System.out.print("\nPre order : ");

            node.preorder();

            System.out.print("\nIn order : ");

            node.inorder();


            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

    }

}
