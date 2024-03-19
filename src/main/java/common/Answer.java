package common;

import java.util.Random;

public class Answer {
    public String strAnsw;
    public int sum;
    /*
     * 1 - '+'
     * 2 - '-'
     * 3 - '*'
     */

    public Answer() {
        Random random = new Random();
        int oper = random.nextInt(1, 4);
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);

        switch (oper) {
            case 1:
                this.sum = num1 + num2;
                this.strAnsw = Integer.toString(num1) + " + " + Integer.toString(num2) + " = ";
                break;
            case 2:
                this.sum = num1 - num2;
                this.strAnsw = Integer.toString(num1) + " - " + Integer.toString(num2) + " = ";
                break;
            case 3:
                this.sum = num1 * num2;
                this.strAnsw = Integer.toString(num1) + " * " + Integer.toString(num2) + " = ";
                break;
            // case 4:
            // this.sum = num1 / num2;
            // break;
        }
    }
}
