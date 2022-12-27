package hello.hellospring.domain;

public class Coupon {
    static Integer num = 10; //초기 쿠폰 수 10개로 설정.

    public Integer getNum() {
        return num;
    }
    public void setNum() {
        this.num = this.num == 0 ? null:this.num-1;
    }
}
