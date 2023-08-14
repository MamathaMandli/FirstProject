package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(0);
        arrayList.add(13);
        arrayList.add(15);
        arrayList.add(14);
        arrayList.add(16);
        System.out.println(arrayList);
      //  List<Integer> list =arrayList.stream().filter(i->i%2==0).collect(Collectors.toList());
        List<Integer> list =arrayList.stream().map(i->i+5).collect(Collectors.toList());

        System.out.println(list);

    }
}
