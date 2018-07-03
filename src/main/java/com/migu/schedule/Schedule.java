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
    private TreeMap<Integer ,BasicTaskInfo> taskMaps = new TreeMap<Integer ,BasicTaskInfo>();

    public int init() {
        if(null!=taskMaps){
            taskMaps.clear();
        }
        if(null!=nodes){
            nodes.clear();
        }
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
        if(nodeId<=0){
            return ReturnCodeKeys.E004;
        }
        Integer n=new Integer(nodeId);
        if(nodes.indexOf(n)<0){
            return ReturnCodeKeys.E007;
        }else{
            nodes.remove(nodes.indexOf(n));
            return ReturnCodeKeys.E006;
        }
    }


    public int addTask(int taskId, int consumption) {
        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }
        if(taskMaps.containsKey(taskId)){
            return ReturnCodeKeys.E010;
        }else{
            BasicTaskInfo info=new BasicTaskInfo(taskId,consumption);
            taskMaps.put(taskId,info);
            return ReturnCodeKeys.E008;
        }
    }


    public int deleteTask(int taskId) {
        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }
        if(!taskMaps.containsKey(taskId)){
            return ReturnCodeKeys.E012;
        }else{
            taskMaps.remove(taskId);
            return ReturnCodeKeys.E011;
        }
    }



    public int scheduleTask(int threshold) {
        if(threshold<=0){
            return ReturnCodeKeys.E002;
        }
        if(nodes.isEmpty()){
            return ReturnCodeKeys.E014;
        }
        if (taskMaps.isEmpty()) {
            return ReturnCodeKeys.E013;
        }

        return ReturnCodeKeys.E014;
    }

    public int queryTaskStatus(List<TaskInfo> tasks) {
        if(null == tasks){
            return ReturnCodeKeys.E016;
        }
        tasks.clear();
        for (BasicTaskInfo info : taskMaps.values()) {
            TaskInfo task = new TaskInfo();
            task.setNodeId(info.getNodeId());
            task.setTaskId(info.getTaskId());
            tasks.add(task);
        }
        return ReturnCodeKeys.E015;
    }

}
