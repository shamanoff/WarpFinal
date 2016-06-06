import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Input
        int SIZE =100;
        int[] unsorted = new int[SIZE];
        Random rnd = new Random();
        for (int i = 0; i <unsorted.length ; i++) {
            unsorted[i]= ((int)(Math.random() * SIZE) - SIZE/2);}
        System.out.println("Unsorted");
        System.out.println(Arrays.toString(unsorted));
        //Duplicate solution
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < unsorted.length; i++) {
            int key =0; int count=0;
            for (int j = 0; j <unsorted.length ; j++) {
                if(unsorted[i]== unsorted[j]){
                    key = unsorted[j];
                    count++; }
            }
            if(count>1){hashmap.put(key,count);}
        }
        List<Integer> dub = new ArrayList<>();
        for (Map.Entry entry : hashmap.entrySet()) {
            for (int i = 0; i < (int)entry.getValue(); i++) {
                dub.add((int)entry.getKey());}
        }
        dub.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;}
        });
        System.out.println("Duplicate");
        System.out.println(dub.toString());
        ArrayList<Integer> temp = new ArrayList<>();
        for (int anUnsorted : unsorted) {
            if (anUnsorted < 0) {
                temp.add(anUnsorted);}
        }
        //Negative
        Integer[]negative = new Integer[temp.size()];
        negative = Arrays.copyOf(temp.toArray(), temp.size(), Integer[].class );
        Set<Integer> negativeSet = new TreeSet<>(Comparator.reverseOrder());
        for (Integer i: negative ) {
            negativeSet.add(i);}
        System.out.println("Negative ");
        System.out.println(negativeSet.toString());
        //Positive
        Integer[] sorted = new Integer[SIZE];
        for (int i = 0; i <sorted.length ; i++) {
            int perm = unsorted[i];
            if (perm >= 0) {
                sorted[perm] = perm; }
            if(perm<0){
                sorted[i]= null;}
        }
        //FinalSorted
        List<Integer> finalSorted = new LinkedList<>();
        for (int i = 0; i < sorted.length; i++) {
            if(sorted[i]!=null){
                finalSorted.add(sorted[i]);}
        }
        //Arrays merge
        for (Integer i:negativeSet ) {
            finalSorted.add(0, i);}
        //Try final solution
        for (Map.Entry<Integer, Integer> entry :hashmap.entrySet()) {
            Integer key = entry.getKey();
            Integer value= entry.getValue();
            for (int i = 0; i < value-1; i++) {
                int pos = finalSorted.indexOf(key);
                finalSorted.add(pos+1, key);}
        }
        //Output
        System.out.println("---------Final Sorted--------");
        System.out.println(Arrays.toString(finalSorted.toArray()));















    }
}