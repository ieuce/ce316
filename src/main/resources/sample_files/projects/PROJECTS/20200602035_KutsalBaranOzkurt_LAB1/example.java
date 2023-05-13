public class example {
    public static void main(String[] args) {
        int total = 0;
        for(int i=0; i<args.length; i++){
            total += Integer.parseInt(args[i]);
        }
        System.out.println(total);
    }
}
