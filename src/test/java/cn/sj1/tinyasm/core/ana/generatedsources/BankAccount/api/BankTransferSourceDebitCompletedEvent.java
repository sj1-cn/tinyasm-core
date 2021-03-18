package cn.sj1.tinyasm.core.ana.generatedsources.BankAccount.api;

public class BankTransferSourceDebitCompletedEvent
{
  private String axonBankAccountId;
  private String bankTransferId;
  private long amount;
  
  public BankTransferSourceDebitCompletedEvent(String axonBankAccountId, String bankTransferId, long amount)
  {
    this.axonBankAccountId = axonBankAccountId;
    this.bankTransferId = bankTransferId;
    this.amount = amount;
  }
  
  public String getAxonBankAccountId()
  {
    return this.axonBankAccountId;
  }
  
  public String getBankTransferId()
  {
    return this.bankTransferId;
  }
  
  public long getAmount()
  {
    return this.amount;
  }
  
  public String toString(String axonBankAccountId, String bankTransferId, long amount)
  {
    return "BankTransferSourceDebitCompletedEvent(" + "axonBankAccountId=" + this.axonBankAccountId + "," + "bankTransferId=" + this.bankTransferId + "," + "amount=" + this.amount + ")";
  }
}
