CarRent.java

import java.util.Date;

public class CarRent {
    private String carname;
    boolean availableforrent;
    private Date returndate;
    boolean isrented;
    private char[] platenumber;

    public char[] getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(char[] platenumber) {
        this.platenumber = platenumber;
    }


    public int getTotalCosttopay() {
        return totalCosttopay;
    }

    public void setTotalCosttopay(int totalCosttopay) {
        this.totalCosttopay = totalCosttopay;
    }

    private int totalCosttopay;

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public boolean isAvailableforrent() {
        return availableforrent;
    }

    public void setAvailableforrent(boolean availableforrent) {
        this.availableforrent = availableforrent;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public boolean isIsrented() {
        return isrented;
    }

    public void setIsrented(boolean isrented) {
        this.isrented = isrented;
    }

    public String toString(){
        return new StringBuffer().append(" car name " + this.carname + " car plate number " + this.platenumber
                + " Return date " + this.returndate ).toString();
    }


}
