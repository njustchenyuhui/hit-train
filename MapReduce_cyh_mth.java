import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapReduce_cyh_mth {

    private ConcurrentMap<String,Integer> resultMap=new ConcurrentHashMap<String, Integer>();

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


        int num=input.size();
        for(int i=0 ; i<num; i++ )
        {
            Task task=new Task(input.get(i));
            Thread t=new Thread(task).start();

        }


        System.out.println(input);
        return input;
    }




    public static void main(String[] args) throws Exception{
        MapReduce_cyh_mth mth=new MapReduce_cyh_mth();
        ArrayList<ArrayList<String>> splitOut=mth.readFileAndSplit();
        System.out.println(mth.resultMap);
    }


    public class Task implements Runnable
    {
        private ArrayList<String> list;

        Task(ArrayList<String> input)
        {
            list=input;
        }

        public void run() {
            IdentityHashMap<String,Integer> mapOut = mapping(list);
            HashMap<String, ArrayList<Integer>> map=shuffling(mapOut);
            reducing(map);
        }

        public IdentityHashMap<String,Integer> mapping(ArrayList<String> input)
        {
            IdentityHashMap<String,Integer> mapOut=new IdentityHashMap<String, Integer>();
            for(int i=0;i<input.size();i++)
            {
                mapOut.put(input.get(i),1);
            }
            System.out.println(mapOut);
            return mapOut;
        }


        public HashMap<String, ArrayList<Integer>> shuffling(IdentityHashMap<String,Integer> input)
        {
            HashMap<String, ArrayList<Integer>> shuffOut=new HashMap<String, ArrayList<Integer>>();

            for(Map.Entry<String, Integer> entry: input.entrySet())
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

            System.out.println(shuffOut);
            return shuffOut;
        }



        public void reducing(HashMap<String, ArrayList<Integer>> shuffInput)
        {
            HashMap<String,Integer> ret = new HashMap<String,Integer>();
            for(Map.Entry<String, ArrayList<Integer>> entry: shuffInput.entrySet())
            {
                String key = entry.getKey();
                if(resultMap.containsKey(key))
                {
                    resultMap.put(key,resultMap.get(key) +entry.getValue().size());
                }
                else
                {
                    resultMap.put(key , entry.getValue().size());
                }
            }
            return;
        }
    }



}

