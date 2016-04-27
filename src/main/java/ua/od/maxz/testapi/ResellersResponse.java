package ua.od.maxz.testapi;

import java.util.ArrayList;
import java.util.List;

/**
 * User: maxz
 * Date: 27.04.2016
 */
public class ResellersResponse {

    public List<Reseller> resellers = new ArrayList<>();

    public ResellersResponse() {
    }

    public ResellersResponse(List<Reseller> resellers) {
        setResellers(resellers);
    }

    public ResellersResponse setResellers(List<Reseller> resellers) {
        this.resellers.addAll(resellers);
        return this;
    }

    public ResellersResponse addResseller(Reseller r) {
        if(resellers==null) {
            resellers = new ArrayList<Reseller>();
        }
        resellers.add(r);
        return this;
    }

    @Override
    public String toString() {
        return "ResellersResponse{" +
                "resellers=" + resellers +
                '}';
    }
}
