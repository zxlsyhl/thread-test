package zxl.com.threadtest.entity;

public class Money {
    private int yue;

    public int getYue() {
        return yue;
    }

    public void setYue(int yue) {
        this.yue = yue;
    }

    public Money(int yue) {
        this.yue = yue;
    }

    public void add(int add){
        yue= yue+add;
    }
}
