package learning.java;

import java.io.*;
import java.util.*;

public class QHeap1 {

    private static Integer currentMinValue = null;

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

            for (int i = 0; i < inputs; i++) {
                int action = scan.nextInt();
                if (action == 1) {
                    int val = scan.nextInt();
                    heap.addNode(val);
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
                currentMinValue = value;
            } else if (value < this.value) {
                if (this.leftNode == null) {
                    this.leftNode = new MyTree(value);
                    if (currentMinValue != null) {
                        currentMinValue = Math.min(currentMinValue, value);
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
                if (currentMinValue != null && currentMinValue.equals(this.value)) {
                    currentMinValue = null;
                }
                this.isActive = false;
            }
        }

        public boolean printMin(BufferedWriter outputFile) throws IOException {
            if (currentMinValue == null) {
                boolean cont = true;
                if (this.leftNode != null) {
                    cont = this.leftNode.printMin(outputFile);
                }
                if (this.isActive && cont) {
                    outputFile.write(this.value.toString());
                    outputFile.newLine();
                    return false;
                }
                if (this.rightNode != null && cont) {
                    cont = this.rightNode.printMin(outputFile);
                }
                return cont;
            } else {
                outputFile.write(currentMinValue.toString());
                outputFile.newLine();
                return false;
            }
        }
    }
}
