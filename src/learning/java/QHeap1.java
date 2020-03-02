package learning.java;

import java.io.*;
import java.util.*;

public class QHeap1 {

    private static MyTree minNode = null;

    public static void runMe(String fileLocation) throws IOException {

        File inputFile = new File(fileLocation);
        File outputFile = new File(fileLocation.replace("input", "output"));

        if (outputFile.exists()) {
            outputFile.delete();
        }

        try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFile))) {

            Scanner scan = new Scanner(inputFile);
            int inputs = scan.nextInt();

            MyTree heap = new MyTree();
            minNode = null;

            for (int i = 0; i < inputs; i++) {
                int action = scan.nextInt();
                if (action == 1) {
                    int val = scan.nextInt();
                    if (minNode == null && heap.getValue() == null) {
                        heap.addNode(val);
                    } else {
                        if (minNode != null && val < minNode.getValue()) {
                            minNode.addNode(val);
                        } else {
                            heap.addNode(val);
                        }
                    }
                } else if (action == 2) {
                    int val = scan.nextInt();
                    heap.removeNode(val);
                } else {
                    heap.printMin(outputFileWriter);
                }
            }
            scan.close();
        }
    }

    private static class MyTree {
        private Integer value;
        private MyTree leftNode;
        private MyTree rightNode;
        private boolean isActive;

        public MyTree() {
        }

        public MyTree(int value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
            this.isActive = true;
        }

        public void addNode(int value) {
            if (this.value == null) {
                this.value = value;
                this.isActive = true;
                minNode = this;
            } else if (value < this.value) {
                if (this.leftNode == null) {
                    this.leftNode = new MyTree(value);
                    if (minNode != null) {
                        minNode = (value < minNode.getValue()) ? this.leftNode : minNode;
                    }
                } else {
                    this.leftNode.addNode(value);
                }
            } else if (value > this.value) {
                if (this.rightNode == null) {
                    this.rightNode = new MyTree(value);
                } else {
                    this.rightNode.addNode(value);
                }
            } else {
                isActive = true;
            }
        }

        public void removeNode(int value) {
            if (value < this.value) {
                this.leftNode.removeNode(value);
            } else if (value > this.value) {
                this.rightNode.removeNode(value);
            } else {
                this.isActive = false;
                if (minNode != null && minNode.getValue() == value) {
                    minNode = null;
                }
            }
        }

        public boolean printMin(BufferedWriter outputFile) throws IOException {
            if (minNode == null) {
                boolean cont = true;
                if (this.leftNode != null) {
                    cont = this.leftNode.printMin(outputFile);
                }
                if (this.isActive && cont) {
                    outputFile.write(String.format("%d%n", this.value));
                    return false;
                }
                if (this.rightNode != null && cont) {
                    cont = this.rightNode.printMin(outputFile);
                }
                return cont;
            } else {
                outputFile.write(String.format("%d%n", minNode.getValue()));
                return false;
            }
        }

        public Integer getValue() {
            return value;
        }
    }
}
