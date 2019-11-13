package ToBeDeleted;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Iterator;

public class JsonCompare {

    static String s = "";

@SuppressWarnings("unchecked")
public static void compareJson(JSONObject json1, JSONObject json2, String key,String sortKey) {
        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
        key = i.next();
        if(json2.containsKey(key)){
        compareJson(json1.get(key), json2.get(key), key,sortKey);
        }else{
            s = s + "不一致：key:" + key + ",json1:" + json1.get(key) + ",json2不存在这个key";
        }

        }
        }

public static void compareJson(Object json1, Object json2, String key,String sortKey) {
        if (json1 instanceof JSONObject) {
        compareJson((JSONObject) json1, (JSONObject) json2, key,sortKey);
        } else if (json1 instanceof JSONArray) {
        compareJson((JSONArray) json1, (JSONArray) json2, key,sortKey);
        } else if (json1 instanceof String) {
//            System.out.println("this String----" + key);
//            compareJson((String) json1, (String) json2, key);
        try {
        String json1ToStr = json1.toString();
        String json2ToStr = json2.toString();
        compareJson(json1ToStr, json2ToStr, key,sortKey);
        } catch (Exception e) {
        System.out.println("转换发生异常 key:" + key);
        e.printStackTrace();
        }

        } else {
        if (json1 == null && json2 == null){
        //System.out.println("一致：key:" + key + ",json1:null" + ",json2:null" );
        }else if(json1 == null && json2 != null){
            s = s +"不一致：key:" + key + ",json1:null" + json2.toString();
        }else if(json2 == null && json1 != null){
                s = s +"不一致：key:" + key + ",json2:null" + json1.toString();
        }else
        {
        compareJson(json1.toString(), json2.toString(), key,sortKey);
        }

        }
        }

public static void compareJson(String str1, String str2, String key,String sortKey) {
        if (!str1.equals(str2)) {
            s = s +"不一致key:" + key + ",sortKey:" + sortKey +  ",json1:" + str1 + ",json2:" + str2;
        } else {
        //System.out.println("一致：key:" + key + ",json1:" + str1 + ",json2:" + str2);
        }
        }

public static void compareJson(JSONArray json1, JSONArray json2, String key, String sortKey) {
        if (json1 != null && json2 != null) {
        Iterator i1 = json1.iterator();
        Iterator i2 = json2.iterator();
        while (i1.hasNext()) {
                Object i1Key = i1.next();
                if( i1Key instanceof JSONObject && sortKey != null && ((JSONObject)i1Key).containsKey(sortKey)){
                        String keyValue = (String) ((JSONObject) i1Key).get(sortKey);
                        if(json2 == null){
                                s = s + "key:" + key + "的json2为空;";
                        }else{
                                Iterator i2Inner = json2.iterator();
                                boolean found = false;
                                while(i2Inner.hasNext()){
                                        Object i2Next = i2Inner.next();
                                        if(i2Next  instanceof JSONObject) {
                                                if(((JSONObject) i2Next).containsKey(sortKey) && ((JSONObject)i2Next).get(sortKey).toString().equalsIgnoreCase(keyValue)){
                                                        found = true;
                                                        compareJson(i1Key, i2Next, key,keyValue);
                                                }
                                        }else continue;
                                }
                                if(found == false){
                                        s = s + "在json2的key:" + key + "中无法找到" + sortKey + "=" + keyValue + "的数据";
                                }
                        }
                }else{
                        compareJson(i1Key, i2.next(), key,sortKey);
                }

        }
        } else {
        if (json1 == null && json2 == null) {
                s = s +"不一致：key:" + key + "  在json1和json2中均不存在";
        } else if (json1 == null) {
                s = s +"不一致：key:" + key + "  在json1中不存在";
        } else if (json2 == null) {
                s = s +"不一致：key:" + key + "  在json2中不存在";
        } else {
            s = s +"不一致：key:" + key + "  未知原因";
        }

        }
        }

private final static String st1 = "{\"Status\":1,\"Data\":[{\"Id\":\"5da9569ed4844c55595c6764\",\"AreaName\":\"上海交大\",\"GPS\":[{\"Longitude\":\"22\",\"Latitude\":31.028095},{\"Longitude\":\"33\",\"Latitude\":31.02633},{\"Longitude\":\"44\",\"Latitude\":31.038612},{\"Longitude\":\"55\",\"Latitude\":31.038465},{\"Longitude\":\"66\",\"Latitude\":31.038576},{\"Longitude\":\"77\",\"Latitude\":31.015776}],\"CreatedAt\":\"0001-01-01T00:00:00Z\",\"OwnBy\":\"abc\",\"UpdatedAt\":\"0001-01-01T00:00:00Z\",\"Cars\":[\"20191015\",\"20191011\"]}]}";
private final static String st2 = "{\"Status\":1,\"Data\":[{\"Id\":\"5da9569ed4844c55595c6764\",\"AreaName\":\"上海交大\",\"GPS\":[{\"Longitude\":\"22\",\"Latitude\":41.028095},{\"Longitude\":\"33\",\"Latitude\":31.02634},{\"Longitude\":\"44\",\"Latitude\":31.038612},{\"Longitude\":\"55\",\"Latitude\":31.038465},{\"Longitude\":\"77\",\"Latitude\":31.038576}],\"CreatedAt\":\"0001-01-01T00:00:00Z\",\"OwnBy\":\"abc\",\"UpdatedAt\":\"0001-01-01T00:00:00Z\",\"Cars\":[\"20191016\",\"20191011\"]}]}";
private final static String st3 = "{\"_id\":{\"$oid\":\"5db27f149275a100012c2fbc\"},\"AreaName\":\"富士康\",\"MiniTaskList\":[{\"_id\":{\"$numberInt\":\"1\"},\"PointStart\":{\"$numberInt\":\"32\"},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G9\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"2\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"31\"},\"PointStartName\":\"A2\",\"PointEndName\":\"G2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"3\"},\"PointStart\":{\"$numberInt\":\"31\"},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G2\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"4\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"50\"},\"PointStartName\":\"A2\",\"PointEndName\":\"F2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"5\"},\"PointStart\":{\"$numberInt\":\"50\"},\"PointEnd\":{\"$numberInt\":\"33\"},\"PointStartName\":\"F2\",\"PointEndName\":\"F20\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"6\"},\"PointStart\":{\"$numberInt\":\"33\"},\"PointEnd\":{\"$numberInt\":\"35\"},\"PointStartName\":\"F20\",\"PointEndName\":\"B9\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]}],\"TimeEnd\":null,\"PathPoints\":null,\"CreatedBy\":\"smileyqp\",\"DeliverTo\":\"\",\"Status\":\"BeforeSend\",\"StatusReason\":\"\",\"TimeStart\":null,\"CreatedTime\":{\"$date\":{\"$numberLong\":\"1571979028495\"}},\"CarID\":\"110\"}";
private final static String st4 = "{\"_id\":{\"$oid\":\"5db27f149275a100012c2fbc\"},\"AreaName\":\"富士康\",\"MiniTaskList\":[{\"_id\":{\"$numberInt\":\"2\"},\"PointStart\":{},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G9\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"2\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"31\"},\"PointStartName\":\"A2\",\"PointEndName\":\"G2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"3\"},\"PointStart\":{\"$numberInt\":\"31\"},\"PointEnd\":{\"$numberInt\":\"34\"},\"PointStartName\":\"G2\",\"PointEndName\":\"A2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"4\"},\"PointStart\":{\"$numberInt\":\"34\"},\"PointEnd\":{\"$numberInt\":\"50\"},\"PointStartName\":\"A2\",\"PointEndName\":\"F2\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"5\"},\"PointStart\":{\"$numberInt\":\"50\"},\"PointEnd\":{\"$numberInt\":\"33\"},\"PointStartName\":\"F2\",\"PointEndName\":\"F20\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]},{\"_id\":{\"$numberInt\":\"6\"},\"PointStart\":{\"$numberInt\":\"33\"},\"PointEnd\":{\"$numberInt\":\"35\"},\"PointStartName\":\"F20\",\"PointEndName\":\"B9\",\"TimeStart\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"TimeEnd\":{\"$date\":{\"$numberLong\":\"-62135596800000\"}},\"DeliverTo\":\"\",\"Status\":\"\",\"StatusReason\":\"\",\"PathPoints\":[]}],\"TimeEnd\":null,\"PathPoints\":null,\"CreatedBy\":\"smileyqp\",\"DeliverTo\":\"\",\"Status\":\"BeforeSend\",\"StatusReason\":\"\",\"TimeStart\":null,\"CreatedTime\":{\"$date\":{\"$numberLong\":\"1571979028495\"}},\"CarID\":\"110\"}";

//private final static String st2 = "{username:\"tom\",age:18}";

public static void main(String[] args) {
        JSONObject jsonObject1 = JSONObject.parseObject(st1);
        JSONObject jsonObject2 = JSONObject.parseObject(st2);
        compareJson(jsonObject1, jsonObject2, null,"Longitude");
        //compareJson(jsonObject2, jsonObject1, null);
        System.out.println(s);

        }

        }