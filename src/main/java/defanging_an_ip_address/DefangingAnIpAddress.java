package defanging_an_ip_address;

public class DefangingAnIpAddress {
    public String defangIPaddr(String address) {
        String resultAddr = "";
        String[] addrArr = address.split("\\.");
        for (int i = 0; i < addrArr.length; i++) {
            if (i == addrArr.length-1)
                resultAddr = resultAddr + addrArr[i];
            else
                resultAddr = resultAddr + addrArr[i] + "[.]";
        }
        return resultAddr;
    }
}
