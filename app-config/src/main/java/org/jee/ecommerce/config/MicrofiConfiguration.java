package org.jee.ecommerce.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "microfi")
public class MicrofiConfiguration {

    @Value("${microfi.transaction.account.statement.url}")
    private String accountStatement;

    @Value("${microfi.transaction.detail.url}")
    private String detailTransaction;

    @Value("${microfi.customer.dat.url}")
    private String customerDAT;

    @Value("${microfi.account.customer.url}")
    private String customerAccounts;

    @Value("${micro.account.historic.url}")
    private String historicN;

    @Value("${microfi.customer.url}")
    private String customerUrl;

    @Value("${microfi.faqs.url}")
    private String faqs;

    @Value("${microfi.claim.url}")
    private String createClaim;

    @Value("${mirofi.loan.url}")
    private String loanUrl;

    @Value("${mirofi.cash-voucher.url}")
    private String cashVoucherUrl;

    @Value("${beneficiaire.create}")
    private String beneficiaireCreate;

    @Value("${beneficiaire.update}")
    private String beneficiaireUpdate;

    @Value("${beneficiaire.get}")
    private String beneficiaireGet;

    @Value("${beneficiaire.delete}")
    private String beneficiaireDelete;

    @Value("${virement.doMultipleTransferFromAccountToAccounts}")
    private String multipleTransferFromAccountToAccounts;

    @Value("${virement.doAccountTranfert}")
    private String accountTranfert;

    @Value("${virement.doRecurrentTranfert}")
    private String recurrentTranfert;

    @Value("${virement.doBankTranfert}")
    private String bankTranfert;

    @Value("${virement.findTransaction}")
    private String findTransaction;

    @Value("${virement.doViremntCompteaCompte}")
    private String viremntCompteaCompte;

    @Value("${topUp.doBuyAirtimeFromAccount}")
    private String buyAirtimeFromAccount;

    @Value("${virement.doInterBankTranfert}")
    private String interBankTranfert;

    @Value("microfi.notification.url")
    private String notification;

    @Value("${email.registration.subject.template}")
    private String emailSubjectTemplate;

    @Value("${email.registration.body.template}")
    private String emailbodyTemplate;

    @Value("${topUp.listTelcos}")
    private String listTelcos;

    @Value("${login.agent}")
    private String loginAgent;

    @Value("${produit.demandeCheque}")
    private String demandeCheque;

    @Value("${produit.listCustomerDemandeCheque}")
    private String listDemandeCheque;

    @Value("${localisation.listBranches}")
    private String listBranches;

    @Value("${localisation.listATMs}")
    private String listATMs;

    @Value("${localisation.listTowns}")
    private String listTowns;

    @Value("${deploy.name}")
    private String deployName;

    @Value("${deploy.version}")
    private String deployVersion;

    @Value("${virement.doDeposit}")
    private String doDeposit;

    @Value("${localisation.listLocalBanks}")
    private String listLocalBanks;

    @Value("${account.info}")
    private String accountInfo;

    @Value("ip-allowed")
    private String whitelist;

    @Value("${send.sms}")
    private String sendSMSNotification;

    @Value("${sms.notification}")
    private String smsNotification;
    
    @Value("${bills.createCustomerCode}")
    private String createCustomerCode;
    
    @Value("${bills.updateCustomerCode}")
    private String updateCustomerCode;
    
    @Value("${bills.listAllCustomCode}")
    private String listAllCustomCode;
    
    @Value("${bills.findByIdCustomCode}")
    private String findByIdCustomCode;
    
    @Value("${bills.request}")
    private String request;
    
    @Value("${bills.deleteCustomCode}")
    private String deleteCustomCode;
    
    @Value("${bills.getCustomerCodeByCustomerIdAndPartnerCode}")
    private String customerCodeByCustomerIdAndPartnerCode;
    
    
    
    
    
    public String getCreateCustomerCode() {
		return createCustomerCode;
	}

	public void setCreateCustomerCode(String createCustomerCode) {
		this.createCustomerCode = createCustomerCode;
	}

	public String getUpdateCustomerCode() {
		return updateCustomerCode;
	}

	public void setUpdateCustomerCode(String updateCustomerCode) {
		this.updateCustomerCode = updateCustomerCode;
	}

	public String getListAllCustomCode() {
		return listAllCustomCode;
	}

	public void setListAllCustomCode(String listAllCustomCode) {
		this.listAllCustomCode = listAllCustomCode;
	}

	public String getFindByIdCustomCode() {
		return findByIdCustomCode;
	}

	public void setFindByIdCustomCode(String findByIdCustomCode) {
		this.findByIdCustomCode = findByIdCustomCode;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getDeleteCustomCode() {
		return deleteCustomCode;
	}

	public void setDeleteCustomCode(String deleteCustomCode) {
		this.deleteCustomCode = deleteCustomCode;
	}

	public String getCustomerCodeByCustomerIdAndPartnerCode() {
		return customerCodeByCustomerIdAndPartnerCode;
	}

	public void setCustomerCodeByCustomerIdAndPartnerCode(String customerCodeByCustomerIdAndPartnerCode) {
		this.customerCodeByCustomerIdAndPartnerCode = customerCodeByCustomerIdAndPartnerCode;
	}

	public String getSmsNotification() {
		return smsNotification;
	}

	public void setSmsNotification(String smsNotification) {
		this.smsNotification = smsNotification;
	}

	public String getSendSMSNotification() {
        return sendSMSNotification;
    }

    public void setSendSMSNotification(String sendSMSNotification) {
        this.sendSMSNotification = sendSMSNotification;
    }

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getDoDeposit() {
        return doDeposit;
    }

    public void setDoDeposit(String doDeposit) {
        this.doDeposit = doDeposit;
    }

    public String getListLocalBanks() {
        return listLocalBanks;
    }

    public void setListLocalBanks(String listLocalBanks) {
        this.listLocalBanks = listLocalBanks;
    }

    public String getDeployName() {
        return deployName;
    }

    public void setDeployName(String deployName) {
        this.deployName = deployName;
    }

    public String getDeployVersion() {
        return deployVersion;
    }

    public void setDeployVersion(String deployVersion) {
        this.deployVersion = deployVersion;
    }

    public String getListBranches() {
        return listBranches;
    }

    public void setListBranches(String listBranches) {
        this.listBranches = listBranches;
    }

    public String getListATMs() {
        return listATMs;
    }

    public void setListATMs(String listATMs) {
        this.listATMs = listATMs;
    }

    public String getListTowns() {
        return listTowns;
    }

    public void setListTowns(String listTowns) {
        this.listTowns = listTowns;
    }

    public String getListDemandeCheque() {
        return listDemandeCheque;
    }

    public void setListDemandeCheque(String listDemandeCheque) {
        this.listDemandeCheque = listDemandeCheque;
    }

    public String getDemandeCheque() {
        return demandeCheque;
    }

    public void setDemandeCheque(String demandeCheque) {
        this.demandeCheque = demandeCheque;
    }

    public String getLoginAgent() {
        return loginAgent;
    }

    public void setLoginAgent(String loginAgent) {
        this.loginAgent = loginAgent;
    }

    public String getListTelcos() {
        return listTelcos;
    }

    public void setListTelcos(String listTelcos) {
        this.listTelcos = listTelcos;
    }

    public String getBuyAirtimeFromAccount() {
        return buyAirtimeFromAccount;
    }

    public void setBuyAirtimeFromAccount(String buyAirtimeFromAccount) {
        this.buyAirtimeFromAccount = buyAirtimeFromAccount;
    }


    public String getBeneficiaireCreate() {
        return beneficiaireCreate;
    }

    public void setBeneficiaireCreate(String beneficiaireCreate) {
        this.beneficiaireCreate = beneficiaireCreate;
    }

    public String getBeneficiaireUpdate() {
        return beneficiaireUpdate;
    }

    public void setBeneficiaireUpdate(String beneficiaireUpdate) {
        this.beneficiaireUpdate = beneficiaireUpdate;
    }

    public String getBeneficiaireGet() {
        return beneficiaireGet;
    }

    public void setBeneficiaireGet(String beneficiaireGet) {
        this.beneficiaireGet = beneficiaireGet;
    }

    public String getBeneficiaireDelete() {
        return beneficiaireDelete;
    }

    public void setBeneficiaireDelete(String beneficiaireDelete) {
        this.beneficiaireDelete = beneficiaireDelete;
    }

    public String getMultipleTransferFromAccountToAccounts() {
        return multipleTransferFromAccountToAccounts;
    }

    public void setMultipleTransferFromAccountToAccounts(String multipleTransferFromAccountToAccounts) {
        this.multipleTransferFromAccountToAccounts = multipleTransferFromAccountToAccounts;
    }

    public String getInterBankTranfert() {
        return interBankTranfert;
    }

    public void setInterBankTranfert(String interBankTranfert) {
        this.interBankTranfert = interBankTranfert;
    }

    public String getAccountTranfert() {
        return accountTranfert;
    }

    public void setAccountTranfert(String accountTranfert) {
        this.accountTranfert = accountTranfert;
    }

    public String getRecurrentTranfert() {
        return recurrentTranfert;
    }

    public void setRecurrentTranfert(String recurrentTranfert) {
        this.recurrentTranfert = recurrentTranfert;
    }

    public String getBankTranfert() {
        return bankTranfert;
    }

    public void setBankTranfert(String bankTranfert) {
        this.bankTranfert = bankTranfert;
    }

    public String getFindTransaction() {
        return findTransaction;
    }

    public void setFindTransaction(String findTransaction) {
        this.findTransaction = findTransaction;
    }

    public String getViremntCompteaCompte() {
        return viremntCompteaCompte;
    }

    public void setViremntCompteaCompte(String viremntCompteaCompte) {
        this.viremntCompteaCompte = viremntCompteaCompte;
    }

    public String getLoanUrl() {
        return loanUrl;
    }

    public String getCashVoucherUrl() {
        return cashVoucherUrl;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }

    public void setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
    }

    public void setLoanUrl(String loanUrl) {
        this.loanUrl = loanUrl;
    }

    public void setCashVoucherUrl(String cashVoucherUrl) {
        this.cashVoucherUrl = cashVoucherUrl;
    }

    public String getFaqs() {
        return faqs;
    }

    public void setFaqs(String getFaqs) {
        this.faqs = getFaqs;
    }

    public String getCreateClaim() {
        return createClaim;
    }

    public void setCreateClaim(String createClaim) {
        this.createClaim = createClaim;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getEmailSubjectTemplate() {
        return emailSubjectTemplate;
    }

    public void setEmailSubjectTemplate(String emailSubjectTemplate) {
        this.emailSubjectTemplate = emailSubjectTemplate;
    }

    public String getEmailbodyTemplate() {
        return emailbodyTemplate;
    }

    public void setEmailbodyTemplate(String emailbodyTemplate) {
        this.emailbodyTemplate = emailbodyTemplate;
    }

    public String getHistoricN() {
        return historicN;
    }

    public void setHistoricN(String historicN) {
        this.historicN = historicN;
    }

    public String getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(String customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    public String getCustomerDAT() {
        return customerDAT;
    }

    public void setCustomerDAT(String customerDAT) {
        this.customerDAT = customerDAT;
    }

    public String getDetailTransaction() {
        return detailTransaction;
    }

    public void setDetailTransaction(String detailTransaction) {
        this.detailTransaction = detailTransaction;
    }

    public String getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(String getAccountStatement) {
        this.accountStatement = getAccountStatement;
    }
}
