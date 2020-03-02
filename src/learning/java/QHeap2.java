package learning.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QHeap2 {

    private static MyList minNode = null;
    private static MyList maxNode = null;

    public static void runMe(String fileLocation) throws IOException {

        File inputFile = new File(fileLocation);
        File outputFile = new File(fileLocation.replace("input", "output"));

        if (outputFile.exists()) {
            outputFile.delete();
        }

        try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFile))) {

            minNode = new MyList();
            maxNode = new MyList();

            Scanner scan = new Scanner(inputFile);
            int inputs = scan.nextInt();

            for (int i = 0; i < inputs; i++) {
                int action = scan.nextInt();
                if (action == 1) {
                    int val = scan.nextInt();
                    if (minNode.getValue() == null) {
                        minNode.addNodeFromLeft(val);
                    } else if (val < minNode.getValue()){
                        minNode.addNodeFromLeft(val);
                    } else if (val > maxNode.getValue()) {
                        maxNode.addNodeFromRight(val);
                    } else {
                        if ((val - minNode.getValue()) <= (val - maxNode.getValue())) {
                            minNode.addNodeFromLeft(val);
                        } else {
                            maxNode.addNodeFromRight(val);
                        }
                    }
                } else if (action == 2) {
                    int val = scan.nextInt();
                    if ((val - minNode.getValue()) <= (val - maxNode.getValue())) {
                        minNode.deactivateNode(val);
                    } else {
                        maxNode.deactivateNode(val);
                    }
                    boolean removeExcess = true;
                    while (removeExcess) {
                        removeExcess = minNode.removeExcessNodes();
                    }
                } else {
                    minNode.printMin(outputFileWriter);
                }
            }
            scan.close();
        }
    }

    private static class MyList {
        private Integer value;
        private MyList leftNode;
        private MyList rightNode;
        private boolean isActive;

        public MyList() {
        }

        public MyList(int value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
            this.isActive = true;
        }

        public void addNodeFromLeft(int value) {
            if (this.value == null) {
                this.value = value;
                this.isActive = true;
                maxNode = minNode;
            } else if (value < this.value) {
                MyList temp = new MyList(value);
                if (this.leftNode == null) {
                    this.leftNode = temp;
                    temp.rightNode = minNode;
                    minNode = temp;
                } else {
                    temp.leftNode = this.leftNode;
                    temp.rightNode = this;
                    this.leftNode.rightNode = temp;
                    this.leftNode = temp;
                }
            } else if (value > this.value) {
                if (this.rightNode == null) {
                    this.rightNode = new MyList(value);
                    maxNode = this.rightNode;
                } else {
                    this.rightNode.addNodeFromLeft(value);
                }
            } else {
                this.isActive = true;
            }
        }

        public void addNodeFromRight(int value) {
            if (value > this.value) {
                MyList temp = new MyList(value);
                if (this.rightNode == null) {
                    this.rightNode = temp;
                    temp.leftNode = this;
                    maxNode = temp;
                } else {
                    temp.leftNode = this;
                    temp.rightNode = this.rightNode;
                    this.rightNode.leftNode = temp;
                    this.rightNode = temp;
                }
            } else if (value < this.value) {
                if (this.leftNode == null) {
                    this.leftNode = new MyList(value);
                    minNode = this.leftNode;
                } else {
                    this.leftNode.addNodeFromRight(value);
                }
            } else {
                this.isActive = true;
            }
        }

        public void deactivateNode(int value) {
            if (this.value == value) {
                this.isActive = false;
            } else if (value < this.value) {
                this.leftNode.deactivateNode(value);
            } else {
                this.rightNode.deactivateNode(value);
            }
        }

        public boolean removeExcessNodes() {
            if ((this.leftNode == null) && !this.isActive) {
                if (this.rightNode != null) {
                    minNode = this.rightNode;
                    minNode.leftNode = null;
                    return true;
                } else {
                    minNode = new MyList();
                    rightNode = new MyList();
                    return false;
                }
            }
            return false;
        }

        public void printMin(BufferedWriter outputFile) throws IOException {
            outputFile.write(String.format("%d%n", minNode.getValue()));
        }

        public Integer getValue() {
            return value;
        }
    }
}
