
package Entity;

import Action.Dealer_Detail;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Dealer{
    
    @Id
    @GeneratedValue
    private int did;
    
    @Embedded //to join with Dealer_Detail
    private String name;
    
    private Dealer_Detail dd;//to join with Dealer_Detail
    

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dealer_Detail getDd() {
        return dd;
    }

    public void setDd(Dealer_Detail dd) {
        this.dd = dd;
    }
    
}
