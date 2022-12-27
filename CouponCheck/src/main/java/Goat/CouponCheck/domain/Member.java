package Goat.CouponCheck.domain;

public class Member {

    private Long id; //임의의 값, 데이터 구분을 위함.
    private String name;
    private Integer couponNum;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(Integer couponNum) {
        this.couponNum = couponNum;
    }
}
