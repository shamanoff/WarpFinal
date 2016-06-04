import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Input
        int SIZE =10;
        int[] unsorted = new int[SIZE];
        Random rnd = new Random();
        for (int i = 0; i <unsorted.length ; i++) {
            unsorted[i]= ((int)(Math.random() * SIZE) - SIZE/2);
        }
        System.out.println("Unsorted");
        System.out.println(Arrays.toString(unsorted));
        //Dublicate solution
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < unsorted.length; i++) {
            int key =0;
            int count=0;
            for (int j = 0; j <unsorted.length ; j++) {
                if(unsorted[i]== unsorted[j]){
                    key = unsorted[j];
                    count++;
                }
            }
            if(count>1){hashmap.put(key,count);}
        }
        List<Integer> dub = new LinkedList<Integer>();
        for (Map.Entry entry : hashmap.entrySet()) {
            for (int i = 0; i < (int)entry.getValue(); i++) {
                dub.add((int)entry.getKey());
            }

        }
        //Dublicates
        Integer[]dublicate = new Integer[dub.size()];
        dublicate = Arrays.copyOf(dub.toArray(), dub.size(), Integer[].class );
        Arrays.sort(dublicate);
        System.out.println("Dublicate ");
        System.out.println(Arrays.toString(dublicate));
        //Algorithm
        ArrayList<Integer> temp = new ArrayList<>();
        for (int anUnsorted : unsorted) {
            if (anUnsorted < 0) {
                temp.add(anUnsorted);
            }
        }
        //Negative
        Integer[]negative = new Integer[temp.size()];
        negative = Arrays.copyOf(temp.toArray(), temp.size(), Integer[].class );
        Set<Integer> negativeSet = new TreeSet<>();
        for (Integer i: negative ) {
            negativeSet.add(i);
        }
        System.out.println("Negative ");
        System.out.println(negativeSet.toString());


        //Pozitive
        Integer[] sorted = new Integer[SIZE];
        for (int i = 0; i <sorted.length ; i++) {
            int perm = unsorted[i];
            if (perm >= 0) {
                sorted[perm] = perm;
            }
            if(perm<0){
                sorted[i]= null;
            }
        }
        //FinalSorted
        List<Integer> finalSorted = new LinkedList<>();
        for (int i = 0; i < sorted.length; i++) {
            if(sorted[i]!=null){
                finalSorted.add(sorted[i]);
            }
        }


        //Arrays merge
        for (int i = negative.length-1; i >=0 ; i--) {
            finalSorted.add(0,negative[i]);
        }

        //Try final solution
        for (Integer i:finalSorted) {
            if(hashmap.containsKey(i)){
                for (int j = 0; j < (int)hashmap.get(i) ; j++) {
                    int index = finalSorted.indexOf(i);
                    finalSorted.add(index, i);

                }
            }

        }



        //Output
        System.out.println("Sorted");
        System.out.println(Arrays.toString(finalSorted.toArray()));

//        List<Integer> dub2 = new ArrayList<>();
//        for (int d :dublicate) {
//            dub2.add(d);
//
//        }

        System.out.println("Final Sorted");
        System.out.println(finalSorted.toString());





    }
}