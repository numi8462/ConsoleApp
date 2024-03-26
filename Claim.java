/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Claim {
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private Double claimAmount;
    private String status;
    private String reciverBankingInfo;
}
