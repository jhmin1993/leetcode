package defanging_an_ip_address;

public class DefangingAnIpAddress {
    public static void main(String[] args) {
        DefangingAnIpAddress defangingAnIpAddress = new DefangingAnIpAddress();
        System.out.println(defangingAnIpAddress.defangIPaddr("1.1.1.1"));
    }
    
    public String defangIPaddr(String address) {
        StringBuilder resultAddr = new StringBuilder();
        String[] addrArr = address.split("\\.");
        for (int i = 0; i < addrArr.length; i++) {
            if (i == addrArr.length-1)
                resultAddr.append(addrArr[i]);
            else
                resultAddr.append(addrArr[i]).append("[.]");
        }
        return resultAddr.toString();
    }
}
