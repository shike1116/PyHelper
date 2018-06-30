package com.mao.baseapp.common.net.dto;
import java.util.List;



public class ListDTO<T> extends RestStatus{
    public List<T> list;
    public ListDTO(){
    }
    public ListDTO(Boolean status,List<T> list){
        super(status);
        this.list=list;
    }
    public List<T> getList(){
        return list;
    }
    public void setList(List<T> list){
        this.list=list;
    }
}