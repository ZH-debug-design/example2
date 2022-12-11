package com.ZH.community.entity;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/28 21:38
 * @Description
 */
public class Page {

    //当前页
    private int current=1;
    //帖子显示数量
    private int limit=10;
    //总页数
    private int rows;
    //路径（每个页码对应一个路径，这个属性是为了减少冗余代码）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>0){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>0 && limit<=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows > 0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取全部页
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }else {
            return rows/limit+1;
        }
    }

    //获取当前页首行
    public int getOffset(){
        return (current-1)*limit;
    }

    //获取开始页（当前页前两个位置，显示的有5页，当前页为中间的页）
    public int getFrom(){
        if(current-2>=1)
            return  current-2;
        else
            return  1;
    }
    //获取尾页
    public int getTo(){
        int total=getTotal();
        if(current+2>=total)
            return  total;
        else
            return  current+2;
    }

}
