// Given all three arrays, write a method to check that my service is first-come, first-served.
// All food should come out in the same order customers requested it.

public class Solution {

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        if (takeOutOrders.length + dineInOrders.length != servedOrders.length)
        {
            return false;
        }

        // check if we're serving orders first-come, first-served
        int takeOutIndex = 0;
        int dineInIndex = 0;
        
        for (int order : servedOrders) {
            if (takeOutIndex < takeOutOrders.length && takeOutOrders[takeOutIndex] == order) 
            {
                takeOutIndex++;
            } 
            else if (dineInIndex < dineInOrders.length && dineInOrders[dineInIndex] == order)
            {
                dineInIndex++;
            } 
            else
            {
                return false;
            }
        }
        
        if (takeOutIndex != takeOutOrders.length || dineInIndex != dineInOrders.length) 
        {
            return false;   
        }

        return true;
    }
}