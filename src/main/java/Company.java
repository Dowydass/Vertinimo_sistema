public class Company {
    private int CompanyId;
    private String companyName;
    private String assistance;

    public Company(int companyId, String companyName, String assistance) {
        CompanyId = companyId;
        this.companyName = companyName;
        this.assistance = assistance;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAssistance() {
        return assistance;
    }

    public void setAssistance(String assistance) {
        this.assistance = assistance;
    }
}
