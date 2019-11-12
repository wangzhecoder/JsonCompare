package ToBeDeleted;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Iterator;

public class JsonCompare {

    static HashMap unMatchMap = new HashMap();

@SuppressWarnings("unchecked")
public static void compareJson(JSONObject json1, JSONObject json2, String key) {
        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
        key = i.next();
        if(json2.containsKey(key)){
        compareJson(json1.get(key), json2.get(key), key);
        }else{
            unMatchMap.put(key,",json1:" + json1.get(key) + ",json2不存在这个key");
        //System.err.println("不一致：key:" + key + ",json1:" + json1.get(key) + ",json2不存在这个key" );
        }

        }
//        return sb.toString();
        }

public static void compareJson(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
//            System.out.println("this JSONObject----" + key);
        compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
//            System.out.println("this JSONArray----" + key);
        compareJson((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
//            System.out.println("this String----" + key);
//            compareJson((String) json1, (String) json2, key);
        try {
        String json1ToStr = json1.toString();
        String json2ToStr = json2.toString();
        compareJson(json1ToStr, json2ToStr, key);
        } catch (Exception e) {
        System.out.println("转换发生异常 key:" + key);
        e.printStackTrace();
        }

        } else {
//            System.out.println("this other----" +
        if (json1 == null && json2 == null){
        //System.out.println("一致：key:" + key + ",json1:null" + ",json2:null" );
        }else if(json1 == null && json2 != null){
            unMatchMap.put(key,",json1:" + ",json1:null" + json2.toString());
        //System.err.println("不一致：key:" + key + ",json1:null" + json2.toString() );
        }else if(json2 == null && json1 != null){
            unMatchMap.put(key,",json1:" + ",json2:null" + json1.toString());
        //System.err.println("不一致：key:" + key + ",json2:null" + json1.toString() );
        }else
        {
        compareJson(json1.toString(), json2.toString(), key);
        }

        }
        }

public static void compareJson(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
        // sb.append("key:" + key + ",json1:" + str1 + ",json2:" + str2);
            unMatchMap.put(key,",json1:" + str1 + ",json2:" + str2);
        //System.err.println("不一致key:" + key + ",json1:" + str1 + ",json2:" + str2);
        } else {
        //System.out.println("一致：key:" + key + ",json1:" + str1 + ",json2:" + str2);
        }
        }

public static void compareJson(JSONArray json1, JSONArray json2, String key) {
        if (json1 != null && json2 != null) {
        Iterator i1 = json1.iterator();
        Iterator i2 = json2.iterator();
        while (i1.hasNext()) {
        compareJson(i1.next(), i2.next(), key);
        }
        } else {
        if (json1 == null && json2 == null) {
            unMatchMap.put(key,"  在json1和json2中均不存在");
        //System.err.println("不一致：key:" + key + "  在json1和json2中均不存在");
        } else if (json1 == null) {
            unMatchMap.put(key,"  在json1中不存在");
        //System.err.println("不一致：key:" + key + "  在json1中不存在");
        } else if (json2 == null) {
            unMatchMap.put(key,"  在json2中不存在");
        //System.err.println("不一致：key:" + key + "  在json2中不存在");
        } else {
            unMatchMap.put(key,"未知原因");
        //System.err.println("不一致：key:" + key + "  未知原因");
        }

        }
        }

private final static String st1 = "{\"username\":\"tom\",\"age\":18,\"address\":[{\"province\":\"上海市\"},{\"city\":\"上海市\"},{\"disrtict\":\"静安区\"}]}";
private final static String st2 = "{\"username\":\"tom\",\"age\":18,\"address\":[{\"province\":\"深圳市\"},{\"city\":\"上海市\"},{\"disrtict\":\"静安区\"}]}";
private final static String st3 = "{\"_id\":{\"$oid\":\"5db27f149275a100012c2fbc\"},\"AreaName\":\"富士康\",\"MiniTaskList\":[{\"_id\":{\"$numberInt\":\"1\"},\"PointStart\":{\"$numberInt\":\"32\"},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G9\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"2\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"31\"},\"PointStartName\":\"A2\",\"PointEndName\":\"G2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"3\"},\"PointStart\":{\"$numberInt\":\"31\"},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G2\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"4\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"50\"},\"PointStartName\":\"A2\",\"PointEndName\":\"F2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"5\"},\"PointStart\":{\"$numberInt\":\"50\"},\"PointEnd\":{\"$numberInt\":\"33\"},\"PointStartName\":\"F2\",\"PointEndName\":\"F20\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"6\"},\"PointStart\":{\"$numberInt\":\"33\"},\"PointEnd\":{\"$numberInt\":\"35\"},\"PointStartName\":\"F20\",\"PointEndName\":\"B9\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]}],\"TimeEnd\":null,\"PathPoints\":null,\"CreatedBy\":\"smileyqp\",\"DeliverTo\":\"\",\"Status\":\"BeforeSend\",\"StatusReason\":\"\",\"TimeStart\":null,\"CreatedTime\":{\"$date\":{\"$numberLong\":\"1571979028495\"}},\"CarID\":\"110\"}";
private final static String st4 = "{\"_id\":{\"$oid\":\"5db27f149275a100012c2fbc\"},\"AreaName\":\"富士康\",\"MiniTaskList\":[{\"_id\":{\"$numberInt\":\"2\"},\"PointStart\":{},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G9\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"2\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"31\"},\"PointStartName\":\"A2\",\"PointEndName\":\"G2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"3\"},\"PointStart\":{\"$numberInt\":\"31\"},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G2\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"4\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"50\"},\"PointStartName\":\"A2\",\"PointEndName\":\"F2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"5\"},\"PointStart\":{\"$numberInt\":\"50\"},\"PointEnd\":{\"$numberInt\":\"33\"},\"PointStartName\":\"F2\",\"PointEndName\":\"F20\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"6\"},\"PointStart\":{\"$numberInt\":\"33\"},\"PointEnd\":{\"$numberInt\":\"35\"},\"PointStartName\":\"F20\",\"PointEndName\":\"B9\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]}],\"TimeEnd\":null,\"PathPoints\":null,\"CreatedBy\":\"smileyqp\",\"DeliverTo\":\"\",\"Status\":\"BeforeSend\",\"StatusReason\":\"\",\"TimeStart\":null,\"CreatedTime\":{\"$date\":{\"$numberLong\":\"1571979028495\"}},\"CarID\":\"110\"}";

//private final static String st2 = "{username:\"tom\",age:18}";

public static void main(String[] args) {
        JSONObject jsonObject1 = JSONObject.parseObject(st3);
        JSONObject jsonObject2 = JSONObject.parseObject(st4);
        compareJson(jsonObject1, jsonObject2, null);
        compareJson(jsonObject2, jsonObject1, null);
        Iterator it =  unMatchMap.keySet().iterator();
        while(it.hasNext()){
            System.err.println(it.next()  );
        }

        }

        }