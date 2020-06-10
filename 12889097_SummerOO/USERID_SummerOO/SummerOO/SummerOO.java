/**
 * This Object-Oriented version of the "Summer" class
 * is a simple introduction to constructors / 
 * private data members / static vs. not static / and the
 * "toString" method. 
 *
 * SKELETON FOR LAB TEST.
 * 
 * @author Raymond Lister
 * @version April 2015;
 */
public class SummerOO
{
    private static int numSummers = 0;
    // The above variable is used to count the number of
    // instances of the class SummerOO that have been created.
    // (i.e. the number of objects that have been created.)
    //
    // Note: "numSummers" is declared as "static". It is a
    //       variable that belongs to the class, not an
    //       individual object.
    // See Parsons page 117, 
    //             section "6.8 Static Fields and Methods"
    // See https://docs.oracle.com/javase/tutorial/java/ ... 
    //           ... javaOO/classvars.html
    // Or google java tutorial static fields

    /*
     * The instance variables follow (i.e. not static). These
     * are also called "fields? or ?private data members?.
     * Each object has its own copy of these variables.
     */

    private int sum;   // sum of all integers received
    private int count; // number of integers received

    /**
     * The constructors now follow. There are two constructors.
     * Both constructors have the same name, since all
     * constructors always have the same name as the class.
     * The constructors are distinguishable because one of the
     * constructors requires zero parameters while the other
     * constructor requires a single integer parameter.
     * See Parsons, page 105, 
     *              section 6.3.1 "Overloaded Constructors"
     */

    /**
     * This is a ?dangerous? constructor, since the average is
     * undefined when the object is created.
     * 
     * This constructor and the method reset()
     * are similar. The differences are that:
     * (1) The constructor can only be used once, when the
     *     object is created.
     * (2) The method reset() can't create an object, but it can
     *     be used whenever we like, as many times as we like,
     *     after the object has been created.
     */
    public SummerOO()
    {
        sum = 0;
        count = 0;
        numSummers++;
    } 

    /**
     * This is a safer constructor, since the average is
     * well defined when the object is created.
     * 
     * This constructor and the method reset(int firstNumber)
     * are similar. The differences are that:
     * (1) The constructor can only be used once, when the
     *     object is created.
     * (2) The method reset() can't create an object, but can
     *     be used whenever we like, as many times as we like,
     *     after the object has been created.
     * 
     * @param   firstNumber The first number of a series 
     */
    public SummerOO(int num)
    {
        count = 1;
        sum = num;
        numSummers++;
    } 

    /**
     * Receives and processes a new number in the series.
     * 
     * NOTE TO STUDENTS: When studying this code, experiment in
     * BlueJ, by adding "static" into "public void putNumber".
     * When you compile, you'll get an error message ...
     * 
     * "non-static variable sum cannot be referenced from a
     * static context".
     * 
     * In other words a "static" method (which belongs to the
     * class, not an individuaual object), can't access the
     * variables in an object. This is for two reasons:
     * (1) If we haven't created ANY objects yet, then there is
     *     no variable "sum" to access!
     * (2) If multiple objects ("instances") of this
     *     class exist, then there are multiple versions of
     *     the "sum" variable, one version of "sum" in each
     *     object. The static method (which belongs to the
     *     class) cannot choose from the many versions of "sum".
     *  The same applies to the variable "count". The error
     *  message singled out "sum" because it occured before
     *  "count".
     * 
     * @param  newNumber   a new number in the series 
     */
    public /* not static! */ void putNumber(int newNumber)
    {
        // This method is complete. No changes are required to
        // "putNumber" in the lab test.
        
        sum = sum + newNumber; // could write "sum += newNumber"
        count = count + 1;     // could write "++count"
    }

    /*
     * A number of the methods from the "static" version 
     * have been left out of this object-oriented version.  
     * That's because Raymond did not wish to test you on 
     * those methods a second time, having already tested 
     * your knowledge of those methods in the "static"
     * version.
     * 
     * All those methods would appear in a complete
     * version of this object-oriented version of the 
     * class, with the *ONLY* change being that the reserved 
     * word "static" would be deleted from the method 
     * header. 
     * 
     * The method putNumber() has been copied across to support 
     * the experiment of adding "static" to its header,
     */

    /**
     * Note that this is a static method. 
     * 
     * @return  The number of objects that have been created. 
     */ 
    public static int getNumSummers()
    {
        return numSummers;
    }

    /**
     * It is common practise to supply a "toString" method 
     * in an object-oriented class.  In fact, if you don't 
     * explicitly supply such a method, Java produces an 
     * implicit, simplistic "toString" method which produces
     * a String like "SummerOO@1edd1f0". The word before 
     * the "@" is the name of the class. The hexadecimal 
     * number after the "@" is called the objects "hash code". 
     *  
     * Note: Method "toString" method is NOT "static". It 
     * can't be static, since the values in the data members 
     * may vary between objects of this class.
     * 
     * See Nielsen, page  78,
     *          section "5.2.4 The toString Method"
     * See Nielsen, page 165,
     *          section "8.2.1 Overriding the toString Method"
     * 
     *@return   The state of this "class instance" / "object"  
     */
    public String toString()
    {
        return "sum = "  +  sum  +  " count = "  +  count;
    }

    /**
     * The purpose of this main method is to reinforce the
     * lesson that anything that can be done through a BlueJ
     * menu can also been done in some Java code.
     * 
     * @param   args Isn't used. Its here because PLATE always expects to see "main" methods which accepts as a parameter an array of Strings.
     */
    public static void main(String [] args)
    { 
        SummerOO summer1 = new SummerOO();
        // the above line used the zero parameter constructor.

        summer1.putNumber(17);
        summer1.putNumber(1);

        System.out.println(summer1.toString());
        // in the above line, the ".toString()" can be omitted,
        // to give just ...
        //                  System.out.println(summer1);
        //
        // When the name of an object is given where a String
        // is required (and println requires a String), Java
        // automatically calls the "toString()" method of the
        // object. 

        // Repeat for a second set of numbers
        System.out.println();

        SummerOO summer2 = new SummerOO(3);
        // above line used the constructor that takes a parameter

        summer2.putNumber(5);
        summer2.putNumber(7);
        System.out.println(summer2);
        // in the above line, Java automatically calls the
        // "toString()" method of the "summer2" object.

    } // method main

} // class SummerOO
