class GreatestCandyKid {
      public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatestKid = 0;
        
        for (int i = 0; i < candies.length; i++) {
            greatestKid = Math.max(greatestKid, candies[i]);
        }
        
        List<Boolean> canBeGreatest = new ArrayList<Boolean>();
        int candyDiff = greatestKid - extraCandies;
        
        for (int i = 0; i < candies.length; i++) {
            canBeGreatest.add(candies[i] >= candyDiff);
        }
        
        return canBeGreatest;
    }
}
