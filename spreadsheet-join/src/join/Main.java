package join;

import java.io.*;

public class Main {
    public static double timeSpent = 10;


    /**
     * Effect: takes in csv file name as a string and return a linked list representation of the csv table
     *
     */

    public static LList<LList<String>> csvToList(String s){

        String path = s;
        LList<LList<String>> l1 = new SLinkedList<>();

        try (Reader in = new FileReader(path);
             BufferedReader br = new BufferedReader(in) ) {
            String line = br.readLine();
            while (line != null) {
                LList<String> lrow = new SLinkedList<>();
                String [] row = line.split(",",Integer.MAX_VALUE);
                for (int i = 0; i<row.length;i++){
                    lrow.append(row[i]);
                }
                l1.append(lrow);
                line = br.readLine();
            }

        } catch (FileNotFoundException e){
            System.err.println("File not found: " + path);
            System.exit(0);
        }
        catch (IOException e) {
            System.err.println("Error reading from file " + path);
            System.exit(0);
        }
        return l1;
    }



    /**
     * Effect: takes in 2 lists (table1,table2) and returns a linked list of their left join
     *
     */
    public static LList<LList<String>> join(LList<LList<String>> table1,
                                            LList<LList<String>> table2) {
        LList<LList<String>> table3 = new SLinkedList<>();
        for (LList<String> r1 : table1){
            if (tableContains(table2,r1.head())==false){
                table3.append(r1);
            }
            for (LList<String> r2 : table2){
                if (r1.head().equals(r2.head())){
                    LList <String> n = new SLinkedList<>();
                    for (String s: r1){
                        n.append(s);
                    }
                    for(int i = 1; i<r2.size(); i++){
                        n.append(r2.get(i));
                    }
                    table3.append(n);
                }
            }
        }
        return table3;
    }

    /**
     * returns whether string s is in LList<LList<String>> table
     */
    public static boolean tableContains(LList<LList<String>> table, String s){
        for (LList<String> r1 : table){
            if (r1.contains(s)==true){
                return true;
            }
        }
        return false;

    }

    /** Effect: Print a usage message to standard error. */
    public static void usage() {
        System.err.println("Usage: a3.Main <file1.csv> <file2.csv>");
    }

    /**
     * Effect: Prints a linked list (table1) in CSV format
     *
     */

    public static void printTable(LList<LList<String>> table1){
        for (LList<String> r1: table1){
            String row = "";
            for (String s : r1){
                row+=s;
                if (r1.tail().equals(s)){
                    break;
                }
                row+=",";
            }
            System.out.println(row);
        }
    }


    public static void main (String [] args){
        if (args.length!=2){
            usage();
            System.err.println("Enter only 2 files");
            System.exit(0);
        }
        LList<LList<String>> l1 = csvToList(args[0]);
        LList<LList<String>> l2 = csvToList(args[1]);
        printTable(join(l1,l2));

    }
}


