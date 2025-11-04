import java.util.Scanner;

public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi)
    {
        int result = 0;
        boolean done = false;
        String trash = "";
        do
        {
            // Code and control logic to loop until validated
            System.out.print(prompt + "[" + lo + " - " + hi + "]: ");
            if(pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine(); // clear input buffer
                if(result >= lo && result <= hi)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + lo + " - " + hi + "]: " + result);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int [" + lo + " - " + hi + "]: " + trash);
            }

        }while(!done);

        return result;
    }



    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You mest enter an int: " + trash);
            }
        }while(!done);
        return  retVal;
    }


    public static double getRangeDouble(Scanner pipe, String prompt, int low, int high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);
        return retVal;
    }


    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answer [Y/N]! " + response);
            }
        } while (!gotAVal);

        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }
        }while(!gotAVal);

        return response;

    }
    public class PrettyHeader {

        public static void main(String[] args) {
            prettyHeader("Message Centered Here");
            prettyHeader("CS Class Assignment");
            prettyHeader("Java Rocks!");
        }

        public static void prettyHeader(String msg) {
            final int TOTAL_WIDTH = 60; //this is a constant hence caps

            // Top border
            for (int i = 0; i < TOTAL_WIDTH; i++) {
                System.out.print("*");
            }
            System.out.println();

            // Middle row
            System.out.print("***"); // left border
            int msgLen = msg.length();
            int spaceAvail = TOTAL_WIDTH - 6; // remove 3 stars on each side
            int leftSpaces = (spaceAvail - msgLen) / 2;
            int rightSpaces = spaceAvail - msgLen - leftSpaces;

            for (int i = 0; i < leftSpaces; i++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int i = 0; i < rightSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println("***"); // right border

            // Bottom border
            for (int i = 0; i < TOTAL_WIDTH; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
}
}