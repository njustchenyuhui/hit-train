import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MapReduce_cyh {


    public ArrayList<ArrayList<String>> readFileAndSplit() throws Exception
    {
        ArrayList<ArrayList<String>> input=new ArrayList<ArrayList<String>>();
        String FilePath="test.txt";
        BufferedReader in = new BufferedReader(new FileReader(FilePath));
        String str;
        while ((str = in.readLine()) != null) {
            String[] strs = str.split(" ");
            ArrayList<String> list=new ArrayList<String>();
            for (String s : strs) {

                list.add(s);
            }
            input.add(list);
        }
        System.out.println(input);
        return input;
    }


    public ArrayList<IdentityHashMap<String,Integer>> mapping(ArrayList<ArrayList<String>> input)
    {
        ArrayList<IdentityHashMap<String,Integer>> mapOut=new ArrayList<IdentityHashMap<String, Integer>>();
        for(int i=0;i<input.size();i++)
        {
            IdentityHashMap<String,Integer> map=new IdentityHashMap<String, Integer>();
            for(int j=0;j<input.get(i).size();j++)
            {
                map.put(input.get(i).get(j),1);
            }
            mapOut.add(map);
        }
        System.out.println(mapOut);
        return mapOut;
    }


    public HashMap<String, ArrayList<Integer>> shuffling(ArrayList<IdentityHashMap<String,Integer>> input)
    {
        HashMap<String, ArrayList<Integer>> shuffOut=new HashMap<String, ArrayList<Integer>>();
        for(int i=0;i<input.size();i++)
        {
            IdentityHashMap<String,Integer> tmp=input.get(i);
            for(Map.Entry<String, Integer> entry: tmp.entrySet())
            {

                if(shuffOut.get(entry.getKey())!=null)
                {
                    ArrayList<Integer> tmplist=shuffOut.get(entry.getKey());
                    tmplist.add(1);
                    shuffOut.put(entry.getKey(),tmplist);
                }
                else
                    {
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(1);
                        shuffOut.put(entry.getKey(),list);
                    }
            }
        }
        System.out.println(shuffOut);
        return shuffOut;
    }

    public HashMap<String,Integer> reducing(HashMap<String, ArrayList<Integer>> shuffInput)
    {
        HashMap<String,Integer> out=new HashMap<String,Integer>();
        for(Map.Entry<String, ArrayList<Integer>> entry: shuffInput.entrySet())
        {
            out.put(entry.getKey(),entry.getValue().size());
        }
        return out;
    }


    public static void main(String[] args) throws Exception{
        MapReduce_cyh mapReduce_cyh=new MapReduce_cyh();

        ArrayList<ArrayList<String>> splitOut=mapReduce_cyh.readFileAndSplit();
        ArrayList<IdentityHashMap<String,Integer>> mapOut=mapReduce_cyh.mapping(splitOut);
        HashMap<String, ArrayList<Integer>> shuffOut=mapReduce_cyh.shuffling(mapOut);
        HashMap<String,Integer> reducOut=mapReduce_cyh.reducing(shuffOut);
        System.out.println(reducOut);
    }
}
