package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.BasicTaskInfo;
import com.migu.schedule.info.TaskInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/*
*类名和方法不能修改
 */
public class Schedule {

    private LinkedList<Integer> nodes = new LinkedList<Integer>();
    private TreeMap<Integer ,BasicTaskInfo> tms = new TreeMap<Integer ,BasicTaskInfo>();

    public int init() {
    	
    		tms.clear();
            nodes.clear();
      
           return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        if(nodeId<=0){
            return ReturnCodeKeys.E004;
        }
        Integer n=new Integer(nodeId);
        if(nodes.indexOf(n)>=0){
            return ReturnCodeKeys.E005;
        }else{
            nodes.addFirst(n);
            return ReturnCodeKeys.E003;
        }
    }

    public int unregisterNode(int nodeId) {
    	 Integer n=new Integer(nodeId);
    	if(nodes.indexOf(n)<0){
    		return ReturnCodeKeys.E007;
    	}else if(n<=0){
    		return ReturnCodeKeys.E004;
    		
    	}else{
    		 nodes.remove(nodes.indexOf(n));
             return ReturnCodeKeys.E006;
    	}
    	
    }


    public int addTask(int taskId, int consumption) {
    	
    	if(tms.containsKey(taskId)){
    		return ReturnCodeKeys.E010;
    	}else if(taskId<=0){
    		return ReturnCodeKeys.E009;
    		
    	}else{
    		BasicTaskInfo info=new BasicTaskInfo(taskId,consumption);
            tms.put(taskId,info);
            return ReturnCodeKeys.E008;
    		
    	}
    	
    	
      
    }


    public int deleteTask(int taskId) {
        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }else if(!tms.containsKey(taskId)){
            return ReturnCodeKeys.E012;
        }else{
        	tms.remove(taskId);
            return ReturnCodeKeys.E011;
        }
    }



    public int scheduleTask(int threshold) {
        return ReturnCodeKeys.E014;
    }

    public int queryTaskStatus(List<TaskInfo> tasks) {
    	return ReturnCodeKeys.E015;
    }

}
