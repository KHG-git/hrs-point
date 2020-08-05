package HotelReservationSystem;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Point_table")
public class Point {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String customerName;
    private Integer pointAmount;
    private Long reservationId;

    @PostPersist
    public void onPostPersist(){
        PointSaved pointSaved = new PointSaved();
        BeanUtils.copyProperties(this, pointSaved);
        pointSaved.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        PointSaveCancled pointSaveCancled = new PointSaveCancled();
        BeanUtils.copyProperties(this, pointSaveCancled);
        pointSaveCancled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Integer getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
    }

    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

}
