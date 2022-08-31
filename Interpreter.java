import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Interpreter
{

    // variables for ra, rb, rc
    public int ra = 0;
    public int rb = 0;
    public int rc = 0;
    public int rd = 0;
    int count = 0;
    public void readProgram(String filename)
    {
        // You can ignore the "try" and "catch" parts. These are just
        // to deal with I/O errors (e.g., file not found).
        try {
            Scanner fileIn = new Scanner(new File(filename));

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();

                // if statement for running methods
                String [] command = line.split(" ");
                String run = command[0];
                switch(run)
                {
                    case "add":
                        // command[3] = command[1] + command [2];
                        add(command[1], command[2], command[3]);
                        break; 
                    case "sub":
                        sub(command[1], command[2], command[3]);
                        break; 
                    case "mul":
                        mul(command[1], command[2], command[3]);
                        break; 
                    case "div":
                        div(command[1], command[2], command[3]);
                        break; 
                    case "incr": 
                        incr(command[1]);
                        break; 
                    case "decr":
                        decr(command[1]);
                        break; 
                    case "copy":
                        copy(command[1], command[2]);
                        break; 
                    case "load":
                        int num = Integer.parseInt(command[1]);
                        load(num, command[2]);
                        break;
                    case "read":
                        read(command[1]);
                        break; 
                    case "print":
                        print(command[1]);
                        break;
                    case "goto":
                        fileIn = goTo(command[1], filename, fileIn);
                        break;
                    case "if":
                        fileIn = condition(line.substring(line.indexOf(" ") + 1, line.indexOf("goto")), command[command.length - 1], filename, fileIn);
                        break;
                }
                count++;
            }
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //* Add Command
    public void add(String argumentOne, String argumentTwo, String argumentThree)
    {
        int firstAddend = 0;
        int secondAddend = 0;
        switch(argumentOne)
        {
            case "ra":
                firstAddend = ra;
                break;
            case "rb":
                firstAddend = rb;
                break;
            case "rc":
                firstAddend = rc;
                break;
            case "rd":
                firstAddend = rd;
                break;
        }

        switch(argumentTwo)
        {
            case "ra":
                secondAddend = ra;
                break;
            case "rb":
                secondAddend = rb;
                break;
            case "rc":
                secondAddend = rc;
                break;
            case "rd":
                secondAddend = rd;
                break;
        }

        switch(argumentThree)
        {
            case "ra":
                ra = firstAddend + secondAddend;
                break;
            case "rb":
                rb = firstAddend + secondAddend;
                break;
            case "rc":
                rc = firstAddend + secondAddend;
                break;
            case "rd":
                rd = firstAddend + secondAddend;
                break;
        }
    }
    //* sub command
    public void sub(String argumentOne, String argumentTwo, String argumentThree)
    {
        int firstSubend = 0;
        int secondSubend = 0;
        switch(argumentOne)
        {
            case "ra":
                firstSubend = ra;
                break;
            case "rb":
                firstSubend = rb;
                break;
            case "rc":
                firstSubend = rc;
                break;
            case "rd":
                firstSubend = rd;
                break;
        }

        switch(argumentTwo)
        {
            case "ra":
                secondSubend = ra;
                break;
            case "rb":
                secondSubend = rb;
                break;
            case "rc":
                secondSubend = rc;
                break;
            case "rd":
                secondSubend = rd;
                break;
        }

        switch(argumentThree)
        {
            case "ra":
                ra = firstSubend - secondSubend;
                break;
            case "rb":
                rb = firstSubend - secondSubend;
                break;
            case "rc":
                rc = firstSubend - secondSubend;
                break;
            case "rd":
                rd = firstSubend - secondSubend;
                break;
        }
    }
    //* mul command
    public void mul(String argumentOne, String argumentTwo, String argumentThree)
    {
        int firstMultiplier = 0;
        int secondMultiplier = 0;
        switch(argumentOne)
        {
            case "ra":
                firstMultiplier = ra;
                break;
            case "rb":
                firstMultiplier = rb;
                break;
            case "rc":
                firstMultiplier = rc;
                break;
            case "rd":
                firstMultiplier = rd;
                break;
        }

        switch(argumentTwo)
        {
            case "ra":
                secondMultiplier = ra;
                break;
            case "rb":
                secondMultiplier = rb;
                break;
            case "rc":
                secondMultiplier = rc;
                break;
            case "rd":
                secondMultiplier = rd;
                break;
        }

        switch(argumentThree)
        {
            case "ra":
                ra = firstMultiplier * secondMultiplier;
                break;
            case "rb":
                rb = firstMultiplier * secondMultiplier;
                break;
            case "rc":
                rc = firstMultiplier * secondMultiplier;
                break;
            case "rd":
                rd = firstMultiplier * secondMultiplier;
                break;
        }
    }
    //* div command
    public void div(String argumentOne, String argumentTwo, String argumentThree)
    {
        int firstDivider = 0;
        int secondDivider = 0;
        switch(argumentOne)
        {
            case "ra":
                firstDivider = ra;
                break;
            case "rb":
                firstDivider = rb;
                break;
            case "rc":
                firstDivider = rc;
                break;
            case "rd":
                firstDivider = rd;
                break;
        }

        switch(argumentTwo)
        {
            case "ra":
                secondDivider = ra;
                break;
            case "rb":
                secondDivider = rb;
                break;
            case "rc":
                secondDivider = rc;
                break;
            case "rd":
                secondDivider = rd;
                break;
        }

        switch(argumentThree)
        {
            case "ra":
                ra = firstDivider / secondDivider;
                break;
            case "rb":
                rb = firstDivider / secondDivider;
                break;
            case "rc":
                rc = firstDivider / secondDivider;
                break;
            case "rd":
                rd = firstDivider / secondDivider;
                break;
        }
    }
    //* incr command
    public void incr(String argument)
    {
        switch(argument)
        {
            case "ra":
                ra++;
                break;
            case "rb":
                rb++;
                break;
            case "rc":
                rc++;
                break;
            case "rd":
                rd++;
                break;
        }
    }
    //* decr command
    public void decr(String argument)
    {
        switch(argument)
        {
            case "ra":
                ra--;
                break;
            case "rb":
                rb--;
                break;
            case "rc":
                rc--;
                break;
            case "rd":
                rd--;
                break;
        }
    }
    //* copy command
    public void copy(String argumentOne, String argumentTwo)
    {
        int copiedValue = 0;
        switch(argumentOne)
        {
            case "ra":
                copiedValue=ra;
                break;
            case "rb":
                copiedValue=rb;
                break;
            case "rc":
                copiedValue=rc;
                break;
            case "rd":
                copiedValue=rd;
                break;
        }
        switch(argumentTwo)
        {
            case "ra":
                ra = copiedValue;
                break;
            case "rb":
                rb = copiedValue;
                break;
            case "rc":
                rc = copiedValue;
                break;
            case "rd":
                rd = copiedValue;
                break;
        }

    }
    //* load command
    public void load(int num, String r)
    {
        if(r.equals("ra"))
        {
            ra = num;
        }
        if(r.equals("rb"))
        {
            rb = num;
        }
        if(r.equals("rc"))
        {
            rc = num;
        }
        if(r.equals("rd"))
        {
            rd = num;
        }
    }
    //* read command
    public void read(String r)
    {
        Scanner sc = new Scanner(System.in);
        switch(r)
        {
            case "ra":
                ra = sc.nextInt();
                break;
            case "rb":
                rb = sc.nextInt();
                break;
            case "rc":
                rc = sc.nextInt();
                break;
            case "rd":
                rd = sc.nextInt();
                break;
        }
    }
    //* print command
    public void print(String r)
    {
        switch(r)
        {
            case "ra":
                System.out.println(ra);
                break;
            case "rb":
                System.out.println(rb);
                break;
            case "rc":
                System.out.println(rc);
                break;
            case "rd":
                System.out.println(rd);
                break;
        }
    }
    //* goto command
    public Scanner goTo(String lineNumber, String file, Scanner scanner) throws FileNotFoundException
    {
        int lineNum = Integer.parseInt(lineNumber);
        if(lineNum < count){
            scanner.close();
            Scanner newScanner = new Scanner(new File(file));
            for(int i = 0; i < lineNum; i++){
                newScanner.nextLine();
            }
            count = lineNum;
            return newScanner;
        }

        return scanner;
    }
    public Scanner condition(String condition, String goToNumber, String File, Scanner scanner) throws FileNotFoundException {
            String reversed = condition.trim();
//        System.out.println(reversed + "chicken");
            String firstComparison = condition.substring(0, condition.indexOf(" "));
//        System.out.println(firstComparison);
            String conditionalValueBuilder = condition.substring(condition.indexOf(" ") + 1);
//        System.out.println(conditionalValueBuilder);
            String conditionValue = conditionalValueBuilder.substring(0, conditionalValueBuilder.indexOf(" ")).trim();
//        System.out.println(conditionValue);
            String comparedValue = new StringBuilder(reversed.substring(0, reversed.indexOf(" "))).reverse().toString();
//        System.out.println(comparedValue);

            int firstComparisonValue = 0;
            int secondComparisonValue = 0;
            
            switch(firstComparison)
            {
                case "ra":
                    firstComparisonValue = ra;
                    break;
                case "rb":
                    firstComparisonValue = rb;
                    break;
                case "rc":
                    firstComparisonValue = rc;
                    break;
                case "rd":
                    firstComparisonValue = rd;
                    break;
            }


            try {
                int x = Integer.parseInt(comparedValue);
                secondComparisonValue = x;
            } catch(NumberFormatException e) {
                switch(comparedValue)
                {
                    case "ra":
                        secondComparisonValue = ra;
                        break;
                    case "rb":
                        secondComparisonValue = rb;
                        break;
                    case "rc":
                        secondComparisonValue = rc;
                        break;
                    case "rd":
                        secondComparisonValue = rd;
                        break;
                }
            }


            switch(conditionValue)
            {
                case ">":
                    if (firstComparisonValue > secondComparisonValue)
                    {
                        return goTo(goToNumber, File, scanner);
                    }
                    break;
                case ">=":
                    if (firstComparisonValue >= secondComparisonValue)
                    {
                        return goTo(goToNumber, File, scanner);
                    }
                    break;
                case "<":
                    if (firstComparisonValue < secondComparisonValue)
                    {
                        return goTo(goToNumber, File, scanner);
                    }
                    break;
                case "<=":
                    if (firstComparisonValue <= secondComparisonValue)
                    {
                        return goTo(goToNumber, File, scanner);
                    }
                    break;
                    case "==":
                    if (firstComparisonValue == secondComparisonValue)
                    {
                        return goTo(goToNumber, File, scanner);
                    }
                    break;
                case "!=":
                    if (firstComparisonValue != secondComparisonValue)
                    {
                        return goTo(goToNumber, File, scanner);
                    }
                    break;
            }
            return scanner;
    }


    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Usage: java Interpreter <filename>");
            return;
        }

        Interpreter interpreter = new Interpreter();
        interpreter.readProgram(args[0]);
    }
}