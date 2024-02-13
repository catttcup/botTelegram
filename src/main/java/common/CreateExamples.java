package common;
import java.util.HashMap;
import java.util.Random;

public class CreateExamples {
    private final HashMap<Integer, String> operators;
     

    public CreateExamples(){
        operators = new HashMap<>();
        operators.put(1, "+");
        operators.put(2, "-");
        operators.put(3, "*");
        operators.put(4, "/");
    }

    /**
     * Answer
     */
    public class Answer{
        public String strAnsw;
        public int sum; 
    }
    


    public Answer GenerationExamples()
    {
            Answer answer = new Answer();
            Random random = new Random();
            int oper =  random.nextInt(1,4);
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            
            switch (oper) {
                case 1:
                    answer.sum = num1 + num2;
                    break;
                case 2:
                    answer.sum = num1 - num2;
                    break;
                case 3:
                    answer.sum = num1 * num2;
                    break;
                // case 4:
                //     answer.sum = num1 / num2;
                //     break;
            }
            
            answer.strAnsw = Integer.toString(num1) + operators.get(oper) + Integer.toString(num2) + "= ";
            return answer;

    }


       
}