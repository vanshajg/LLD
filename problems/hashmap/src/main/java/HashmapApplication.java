public class HashmapApplication {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();

        hashMap.put(1, "A");
        hashMap.put(1, "E");
        System.out.println(hashMap.get(1));
    }
}
