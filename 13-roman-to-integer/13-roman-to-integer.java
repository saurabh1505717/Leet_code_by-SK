class Solution {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer>Hm = new HashMap<>();
        Hm.put("I",1);
        Hm.put("V",5);
        Hm.put("X",10);
        Hm.put("L",50);
        Hm.put("C",100);
        Hm.put("D",500);
        Hm.put("M",1000);
        
        int nextValue=0;
        for(int i=s.length()-1; i>=0; i--){
            String RomanString=s.substring(i,i+1);
            System.out.println(RomanString);
            int IntegerEquivalence=Hm.get(RomanString);
            
            if(nextValue!=0 && IntegerEquivalence<nextValue){
                result-=IntegerEquivalence;
            }
            else{
                result+=IntegerEquivalence;
            }
            
            nextValue=IntegerEquivalence;
        }
        return result;
    }
}