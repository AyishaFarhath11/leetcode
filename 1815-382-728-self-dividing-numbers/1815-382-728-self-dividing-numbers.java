class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
          List<Integer> list = new ArrayList<>();

        for(int number = left; number <= right; number++){
            if(isSelfDevide(number)) list.add(number);
        }
        return list;
    }
        private boolean isSelfDevide(int num){
        int ogNum = num;

        while(num > 0){
            int digit = num % 10;
            num /= 10;

            if(digit == 0 || ogNum % digit != 0)    return false;
        }
        return true;
    }
}