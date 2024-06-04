import java.util.*;


public class Main {
    public static void addNumber(String key, int value,  Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);

        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);

        }
    }


    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> PhoneBook = new HashMap<>();
        addNumber("Ivanov", 123, PhoneBook);
        addNumber("Petrov", 1234, PhoneBook);
        addNumber("Sidorov", 12345, PhoneBook);
        addNumber("Ivanov", 123456, PhoneBook);
        addNumber("Ivanov", 1234567, PhoneBook);
        addNumber("Petrov", 789789, PhoneBook);
        addNumber("Вася", 789789, PhoneBook);
        addNumber("Вася", 123123, PhoneBook);

        System.out.println(PhoneBook);
        System.out.println();


        SortedSet<Map.Entry<String, ArrayList<Integer>>> sortedset = new TreeSet<>(
                new Comparator<>() {

                    @Override
                    public int compare(Map.Entry<String, ArrayList<Integer>> arg0,
                                       Map.Entry<String, ArrayList<Integer>> arg1) {
                        if (arg0.getValue().size() < arg1.getValue().size())
                            return 1;
                        else if (arg0.getValue().size() > arg1.getValue().size())
                            return -1;
                        else
                            return 1;
                    }
                }
        );
        sortedset.addAll(PhoneBook.entrySet());

        System.out.println("Sorted:");
        for (Map.Entry<String, ArrayList<Integer>> pb : sortedset){
            System.out.println(
                    pb.getKey()+" : "+ pb.getValue()+"\n"

            );
        }

    }

}